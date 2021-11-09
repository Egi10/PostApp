package id.buaja.data.repository

import id.buaja.data.source.users.UsersDataSource
import id.buaja.data.source.users.response.AlbumsResponse
import id.buaja.domain.model.users.Albums
import id.buaja.domain.model.users.Photos
import id.buaja.domain.model.users.Users
import id.buaja.domain.repository.UsersRepository
import id.buaja.domain.util.ResultState
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val usersDataSource: UsersDataSource
): UsersRepository {
    override fun getUser(idUser: Int): Flow<ResultState<Users>> {
        return channelFlow {
            usersDataSource.getUserById(idUser)
                .combine(usersDataSource.getAlbumsByIdUser(idUser)) { user, albums ->
                    val listAlbums: List<Albums> = albumsUser(albums)

                    return@combine Users(
                        name = user.name ?: "",
                        email = user.email ?: "",
                        address = user.address?.street ?: "",
                        company = user.company?.name ?: "",
                        albums = listAlbums
                    )
                }
                .catch { throwable ->
                    send(ResultState.Error(throwable))
                }
                .collect {
                    send(ResultState.Success(it))
                }

        }
    }

    private suspend fun albumsUser(albums: List<AlbumsResponse>): List<Albums> {
        val listAlbums: MutableList<Albums> = mutableListOf()

        albums.forEach { albumsUser ->
            usersDataSource.getPhotosByIdAlbums(albumsUser.id ?: 0)
                .collectIndexed { index, value ->
                    listAlbums.add(
                        Albums(
                            name = albumsUser.title ?: "",
                            photos = listOf(
                                Photos(
                                    title = value[index].title ?: "",
                                    thumbnail = value[index].thumbnailUrl ?: ""
                                )
                            )
                        )
                    )
                }
        }
        return listAlbums
    }
}