package id.buaja.home.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.buaja.abstraction.util.UiState
import id.buaja.domain.model.Post
import id.buaja.domain.usecase.PostUseCase
import id.buaja.domain.util.ResultState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val postUseCase: PostUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(UiState<List<Post>>(loading = true))
    val uiState: StateFlow<UiState<List<Post>>> = _uiState.asStateFlow()

    init {
        getPost()
    }

    private fun getPost() {
        viewModelScope.launch {
            postUseCase.getPostWithUser()
                .onStart {
                    _uiState.update {
                        it.copy(loading = true)
                    }
                }
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