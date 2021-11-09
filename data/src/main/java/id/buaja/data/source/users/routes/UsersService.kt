package id.buaja.data.source.users.routes

import id.buaja.data.source.users.response.AlbumsResponse
import id.buaja.data.source.users.response.PhotosResponse
import id.buaja.data.source.users.response.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface UsersService {
    @GET("users/{idUser}")
    suspend fun getUserById(@Path("idUser") idUser: Int): UsersResponse

    @GET("users/{idUser}/albums")
    suspend fun getAlbumsByIdUser(
        @Path("idUser") idUser: Int
    ): List<AlbumsResponse>

    @GET("albums/{idAlbums}/photos")
    suspend fun getPhotosByIdAlbums(
        @Path("idAlbums") idAlbums: Int
    ): List<PhotosResponse>
}