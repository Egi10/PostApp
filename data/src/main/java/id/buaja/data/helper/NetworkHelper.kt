package id.buaja.data.helper


import id.buaja.data.util.ApiResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

fun <T> safeApiCall(dispatcher: CoroutineDispatcher, apiCall: suspend () -> T): Flow<ApiResult<T>> {
    return flow<ApiResult<T>> {
        emit(ApiResult.Success(apiCall.invoke()))
    }.catch { throwable ->
        emit(ApiResult.Error(throwable))
    }.flowOn(dispatcher)
}