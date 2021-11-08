package id.buaja.abstraction.util

data class UiState<T>(
    val data: T? = null,
    val loading: Boolean = false,
    val error: String = ""
) {
    val failedLoading: Boolean
        get() = !loading && data == null
}