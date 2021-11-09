package id.buaja.data.source.users

import id.buaja.data.di.IoDispatcher
import id.buaja.data.source.users.response.AlbumsResponse
import id.buaja.data.source.users.response.PhotosResponse
import id.buaja.data.source.users.response.UsersResponse
import id.buaja.data.source.users.routes.UsersService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UsersDataSourceImpl @Inject constructor(
    private val usersService: UsersService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : UsersDataSource {
    override fun getUserById(userId: Int): Flow<UsersResponse> {
        return flow {
            val result = usersService.getUserById(userId)
            emit(result)
        }.flowOn(ioDispatcher)
    }

    override fun getAlbumsByIdUser(userId: Int): Flow<List<AlbumsResponse>> {
        return flow {
            val result = usersService.getAlbumsByIdUser(userId)
            emit(result)
        }.flowOn(ioDispatcher)
    }

    override fun getPhotosByIdAlbums(idAlbums: Int): Flow<List<PhotosResponse>> {
        return flow {
            val result = usersService.getPhotosByIdAlbums(idAlbums)
            emit(result)
        }.flowOn(ioDispatcher)
    }
}