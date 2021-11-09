package id.buaja.users.users.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleAndDescription(
    title: String,
    description: String?,
    paddingTop: Boolean = true
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = if (paddingTop) {
                    10.dp
                } else {
                    0.dp
                }
            )
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )

        Text(
            text = description ?: "",
            fontSize = 12.sp
        )
    }
}