package id.buaja.data.source.post

import id.buaja.data.source.post.response.PostResponse
import kotlinx.coroutines.flow.Flow

interface PostDataSource {
    fun getPost(): Flow<PostResponse>
}