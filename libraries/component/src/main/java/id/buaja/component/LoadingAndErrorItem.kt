package id.buaja.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import id.buaja.abstraction.util.UiState

@Composable
fun <T> LoadingAndErrorItem(result: UiState<T>) {
    when {
        result.loading -> {
            LoadingCircular()
        }

        result.error.isNotEmpty() -> {
            ErrorMessage(
                title = stringResource(R.string.maintenances),
                message = result.error
            )
        }
    }
}