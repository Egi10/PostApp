package id.buaja.home.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.buaja.component.PostTopAppBar
import id.buaja.domain.model.Post
import id.buaja.domain.model.PostComments
import id.buaja.home.R

@Composable
fun DetailPostScreen(
    post: Post?,
    comments: List<PostComments>,
    contentError: @Composable ColumnScope.() -> Unit,
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

            item {
                Spacer(
                    modifier = Modifier
                        .padding(top = 20.dp)
                )
                Divider()
            }

            item {
                Text(
                    modifier = Modifier
                        .padding(top = 15.dp),
                    text = stringResource(R.string.comments),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            item {
                contentError.invoke(this@Column)
            }

            items(comments) { item: PostComments ->
                PostCommentsItem(postComments = item)
            }
        }
    }
}