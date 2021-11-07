package id.buaja.domain.usecase

import id.buaja.domain.model.Post
import id.buaja.domain.util.ResultState
import kotlinx.coroutines.flow.Flow

interface PostUseCase {
    fun getPostWithUser(): Flow<ResultState<List<Post>>>
}