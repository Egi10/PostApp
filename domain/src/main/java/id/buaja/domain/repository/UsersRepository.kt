package id.buaja.domain.repository

import id.buaja.domain.model.users.Users
import id.buaja.domain.util.ResultState
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    fun getUser(idUser: Int): Flow<ResultState<Users>>
}