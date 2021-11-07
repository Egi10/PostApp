package id.buaja.data.source.users.routes

import id.buaja.data.source.users.response.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface UsersService {
    @GET("users/{idUser}")
    suspend fun getUserById(@Path("idUser") idUser: Int): UsersResponse
}