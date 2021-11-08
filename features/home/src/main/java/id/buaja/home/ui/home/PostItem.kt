package id.buaja.home.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.buaja.domain.model.Post

@Composable
fun PostItem(
    post: Post,
    onClick: (Post) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick.invoke(post)
            }
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Text(
            text = post.title,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        
        Text(
            text = post.body,
            fontSize = 12.sp,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2
        )
        
        Spacer(modifier = Modifier.padding(top = 8.dp))
        
        Text(
            text = "${post.userName} | ${post.userCompanyName}",
            fontSize = 10.sp,
        )
    }
}