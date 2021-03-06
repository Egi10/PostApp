package id.buaja.domain.usecase.post

import id.buaja.domain.model.post.Post
import id.buaja.domain.model.post.PostComments
import id.buaja.domain.repository.PostRepository
import id.buaja.domain.util.ResultState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostUseCaseImpl @Inject constructor(
    private val postRepository: PostRepository
) : PostUseCase {
    override fun getPostWithUser(): Flow<ResultState<List<Post>>> {
        return postRepository.getPostWithUser()
    }

    override fun getPostComments(idPost: Int): Flow<ResultState<List<PostComments>>> {
        return postRepository.getPostComments(idPost)
    }
}