package id.buaja.domain.usecase.users

import id.buaja.domain.model.users.Users
import id.buaja.domain.util.ResultState
import kotlinx.coroutines.flow.Flow

interface UserUseCase {
    fun getUser(idUser: Int): Flow<ResultState<Users>>
}