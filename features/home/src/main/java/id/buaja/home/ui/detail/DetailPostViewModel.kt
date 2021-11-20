package id.buaja.home.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.buaja.abstraction.util.UiState
import id.buaja.domain.model.post.PostComments
import id.buaja.domain.usecase.post.PostUseCase
import id.buaja.domain.util.ResultState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailPostViewModel @Inject constructor(
    private val postUseCase: PostUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(UiState<List<PostComments>>(loading = true))
    val uiState: StateFlow<UiState<List<PostComments>>> get() = _uiState

    fun getPostComment(idPost: Int) {
        viewModelScope.launch {
            postUseCase.getPostComments(idPost)
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