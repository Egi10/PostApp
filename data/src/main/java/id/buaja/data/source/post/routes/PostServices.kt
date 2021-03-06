package id.buaja.data.source.post.routes

import id.buaja.data.source.post.response.PostCommentsResponseItem
import id.buaja.data.source.post.response.PostResponseItem
import retrofit2.http.GET
import retrofit2.http.Path

interface PostServices {
    @GET("posts")
    suspend fun getPost(): List<PostResponseItem>

    @GET("posts/{postId}/comments")
    suspend fun getPostWithComments(
        @Path("postId") postId: Int
    ): List<PostCommentsResponseItem>
}