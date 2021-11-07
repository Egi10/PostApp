package id.buaja.domain.repository

import id.buaja.domain.model.Post
import id.buaja.domain.model.PostComments
import id.buaja.domain.util.ResultState
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    fun getPostWithUser(): Flow<ResultState<List<Post>>>
    fun getPostComments(idPost: Int): Flow<ResultState<List<PostComments>>>
}