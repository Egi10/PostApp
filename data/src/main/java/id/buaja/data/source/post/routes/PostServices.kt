package id.buaja.data.source.post.routes

import id.buaja.data.source.post.response.PostResponse
import retrofit2.http.GET

interface PostServices {
    @GET("posts")
    suspend fun getPost(): PostResponse
}