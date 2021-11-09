package id.buaja.home.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.buaja.domain.model.post.PostComments

@Composable
fun PostCommentsItem(
    postComments: PostComments
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        Text(
            text = postComments.name,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = postComments.body,
            fontSize = 12.sp,
        )
    }
}