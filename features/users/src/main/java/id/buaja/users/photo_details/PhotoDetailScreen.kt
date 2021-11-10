package id.buaja.users.photo_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import id.buaja.component.PostTopAppBar
import id.buaja.users.R

@Composable
fun PhotoDetailScreen(
    imageDetail: String,
    title: String,
    onClick: () -> Unit = {},
) {
    val painter = rememberImagePainter(
        data = imageDetail
    )
    var scale by remember { mutableStateOf(1f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        PostTopAppBar(
            title = title,
            icon = R.drawable.ic_arrow_back_black_24dp,
            onClick = onClick
        )

        Box {
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer(
                        scaleX = scale,
                        scaleY = scale
                    )
                    .pointerInput(Unit) {
                        detectTransformGestures { _, _, zoom, _ ->
                            scale = when {
                                scale < 0.5f -> 0.5f
                                scale > 4f -> 3f
                                else -> scale * zoom
                            }
                        }
                    }
            )

            when (painter.state) {
                is ImagePainter.State.Loading -> {
                    // Display a circular progress indicator whilst loading
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
                is ImagePainter.State.Error -> {
                    // If you wish to display some content if the request fails
                }
            }
        }
    }
}