package id.buaja.data.source.post

import id.buaja.data.source.post.response.PostCommentsResponseItem
import id.buaja.data.source.post.response.PostResponseItem
import id.buaja.data.util.ApiResult
import kotlinx.coroutines.flow.Flow

interface PostDataSource {
    fun getPost(): Flow<List<PostResponseItem>>
    fun getCommentsPost(idPost: Int): Flow<ApiResult<List<PostCommentsResponseItem>>>
}