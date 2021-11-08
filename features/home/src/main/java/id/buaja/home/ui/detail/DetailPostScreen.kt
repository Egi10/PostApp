package id.buaja.home.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.buaja.component.PostTopAppBar
import id.buaja.domain.model.Post
import id.buaja.home.R

@Composable
fun DetailPostScreen(
    post: Post?,
    navigationBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        PostTopAppBar(
            title = stringResource(R.string.details_post),
            icon = R.drawable.ic_arrow_back_black_24dp,
            onClick = navigationBack
        )

        LazyColumn(
            contentPadding = PaddingValues(20.dp)
        ) {
            item {
                Text(
                    text = "${post?.userName} | ${post?.userCompanyName}",
                    fontSize = 12.sp,
                )
            }

            item {
                Text(
                    modifier = Modifier
                        .padding(top = 10.dp),
                    text = post?.title ?: "",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            item {
                Text(
                    modifier = Modifier
                        .padding(top = 20.dp),
                    text = post?.body ?: "",
                    fontSize = 14.sp,
                )
            }
        }
    }
}