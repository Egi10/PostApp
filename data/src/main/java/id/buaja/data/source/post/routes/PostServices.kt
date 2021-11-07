package id.buaja.data.source.post.routes

import id.buaja.data.source.post.response.PostCommentsResponse
import id.buaja.data.source.post.response.PostResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PostServices {
    @GET("posts")
    suspend fun getPost(): PostResponse

    @GET("posts/{postId}/comments")
    suspend fun getPostWithComments(
        @Path("postId") postId: Int
    ): PostCommentsResponse
}