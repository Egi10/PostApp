package id.buaja.data.source.users

import id.buaja.data.di.IoDispatcher
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
}