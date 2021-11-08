package id.buaja.home.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import id.buaja.component.ErrorMessage
import id.buaja.component.LoadingCircular
import id.buaja.component.PostTopAppBar
import id.buaja.domain.model.Post
import id.buaja.home.R

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onClick: (Post) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        PostTopAppBar(title = stringResource(R.string.post))

        when {
            uiState.loading -> {
                LoadingCircular()
            }

            uiState.data != null -> {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(top = 16.dp, bottom = 16.dp)
                ) {
                    items(uiState.data ?: emptyList()) { post ->
                        PostItem(post = post, onClick = onClick)
                    }
                }
            }

            else -> {
                ErrorMessage(
                    title = stringResource(R.string.ops_error),
                    message = uiState.error
                )
            }
        }

    }
}