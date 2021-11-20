package id.buaja.users.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.buaja.abstraction.util.UiState
import id.buaja.domain.model.users.Users
import id.buaja.domain.usecase.users.UserUseCase
import id.buaja.domain.util.ResultState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersDetailViewModel @Inject constructor(
    private val userUseCase: UserUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(UiState<Users>(loading = true))
    val uiState: StateFlow<UiState<Users>>
        get() = _uiState.stateIn(
            initialValue = UiState(),
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000)
        )

    fun getUser(userId: Int) {
        viewModelScope.launch {
            userUseCase.getUser(userId)
                .onCompletion {
                    _uiState.update {
                        it.copy(loading = false)
                    }
                }
                .collect { result ->
                    when (result) {
                        is ResultState.Success -> {
                            _uiState.update {
                                it.copy(data = result.data)
                            }
                        }

                        is ResultState.Error -> {
                            _uiState.update {
                                it.copy(error = result.exception.message ?: "Error")
                            }
                        }
                    }
                }
        }
    }
}