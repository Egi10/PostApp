package id.buaja.home.ui.detail

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import id.buaja.abstraction.util.UiState
import id.buaja.component.ErrorMessage
import id.buaja.component.LoadingCircular
import id.buaja.domain.model.PostComments
import id.buaja.home.R

@Composable
fun LoadingAndErrorItem(result: UiState<List<PostComments>>) {
    when {
        result.loading -> {
            LoadingCircular()
        }

        result.error.isNotEmpty() -> {
            ErrorMessage(
                title = stringResource(R.string.ops_error),
                message = result.error
            )
        }
    }
}