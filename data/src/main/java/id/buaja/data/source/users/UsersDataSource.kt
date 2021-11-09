package id.buaja.data.source.users

import id.buaja.data.source.users.response.AlbumsResponse
import id.buaja.data.source.users.response.PhotosResponse
import id.buaja.data.source.users.response.UsersResponse
import kotlinx.coroutines.flow.Flow

interface UsersDataSource {
    fun getUserById(userId: Int): Flow<UsersResponse>
    fun getAlbumsByIdUser(userId: Int): Flow<List<AlbumsResponse>>
    fun getPhotosByIdAlbums(idAlbums: Int): Flow<List<PhotosResponse>>
}