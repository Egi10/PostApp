package id.buaja.data.source.users

import id.buaja.data.source.users.response.UsersResponse
import kotlinx.coroutines.flow.Flow

interface UsersDataSource {
    fun getUserById(userId: Int): Flow<UsersResponse>
}