package id.buaja.data.source.post

import id.buaja.data.di.IoDispatcher
import id.buaja.data.source.post.response.PostResponse
import id.buaja.data.source.post.routes.PostServices
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostDataSourceImpl @Inject constructor(
    private val postServices: PostServices,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : PostDataSource {
    override fun getPost(): Flow<PostResponse> {
        return flow {
            val result = postServices.getPost()
            emit(result)
        }.flowOn(ioDispatcher)
    }
}