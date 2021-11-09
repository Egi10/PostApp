package id.buaja.domain.usecase.users

import id.buaja.domain.model.users.Users
import id.buaja.domain.repository.UsersRepository
import id.buaja.domain.util.ResultState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserUseCaseImpl @Inject constructor(
    private val usersRepository: UsersRepository
) : UserUseCase {
    override fun getUser(idUser: Int): Flow<ResultState<Users>> {
        return usersRepository.getUser(idUser)
    }
}