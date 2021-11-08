package id.buaja.data.repository

import id.buaja.data.mapper.DataMapper
import id.buaja.data.source.post.PostDataSource
import id.buaja.data.source.users.UsersDataSource
import id.buaja.data.util.ApiResult
import id.buaja.domain.model.Post
import id.buaja.domain.model.PostComments
import id.buaja.domain.repository.PostRepository
import id.buaja.domain.util.ResultState
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postDataSource: PostDataSource,
    private val usersDataSource: UsersDataSource
) : PostRepository {
    override fun getPostWithUser(): Flow<ResultState<List<Post>>> {
        return channelFlow {
            postDataSource.getPost()
                .flatMapMerge { post ->
                    val result: MutableList<Post> = mutableListOf()

                    post.forEach { postResponse ->
                        usersDataSource.getUserById(postResponse.userId ?: 0)
                            .collect { user ->
                                val resultMap = DataMapper.mapResponseToModelPost(
                                    post = postResponse,
                                    user = user
                                )

                                result.addAll(resultMap)
                            }
                    }

                    return@flatMapMerge flow {
                        emit(result)
                    }
                }
                .catch { throwable ->
                    send(ResultState.Error(throwable))
                }
                .collect {
                    send(ResultState.Success(it))
                }
        }
    }

    override fun getPostComments(idPost: Int): Flow<ResultState<List<PostComments>>> {
        return flow {
            postDataSource.getCommentsPost(idPost)
                .collect { result ->
                    when(result) {
                        is ApiResult.Success -> {
                            val data = DataMapper.mapResponseToModelPostComments(
                                postComments = result.data
                            )
                            emit(ResultState.Success(data))
                        }

                        is ApiResult.Error -> {
                            emit(ResultState.Error(result.throwable))
                        }
                    }
                }
        }
    }
}