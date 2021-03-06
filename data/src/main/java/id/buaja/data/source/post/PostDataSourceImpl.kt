package id.buaja.data.source.post

import id.buaja.data.di.IoDispatcher
import id.buaja.data.helper.safeApiCall
import id.buaja.data.source.post.response.PostCommentsResponseItem
import id.buaja.data.source.post.response.PostResponseItem
import id.buaja.data.source.post.routes.PostServices
import id.buaja.data.util.ApiResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostDataSourceImpl @Inject constructor(
    private val postServices: PostServices,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : PostDataSource {
    override fun getPost(): Flow<List<PostResponseItem>> {
        return flow {
            val result = postServices.getPost()
            emit(result)
        }.flowOn(ioDispatcher)
    }

    override fun getCommentsPost(idPost: Int): Flow<ApiResult<List<PostCommentsResponseItem>>> {
        return safeApiCall(ioDispatcher) {
            postServices.getPostWithComments(idPost)
        }
    }
}