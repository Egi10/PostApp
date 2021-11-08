package id.buaja.abstraction.helper

import android.util.Log
import id.buaja.abstraction.util.UiState
import id.buaja.domain.util.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

suspend fun <T> safeCall(useCaseCall: () -> Flow<ResultState<T>>): UiState<T> {
    val uiState = UiState<T>()

    useCaseCall.invoke()
        .onStart {
            uiState.copy(
                loading = true
            )
        }
        .onCompletion {
            uiState.copy(
                loading = false
            )
        }
        .collect { result ->
            when (result) {
                is ResultState.Success -> {
                    Log.d("Disini", "Data ${result.data}")
                    uiState.copy(
                        data = result.data
                    )
                }

                is ResultState.Error -> {
                    uiState.copy(
                        error = result.exception.message ?: ""
                    )
                    Log.d("Disini", "Exception ${result.exception}")
                }
            }
        }

    return uiState
}