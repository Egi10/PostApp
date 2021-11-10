package id.buaja.users.users

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import id.buaja.abstraction.util.UiState
import id.buaja.component.LoadingAndErrorItem
import id.buaja.component.PostTopAppBar
import id.buaja.domain.model.users.Photos
import id.buaja.domain.model.users.Users
import id.buaja.users.R
import id.buaja.users.users.components.TitleAndDescription

@Composable
fun UsersDetailScreen(
    users: UiState<Users>,
    imageDetail: (Photos) -> Unit = {},
    onBack: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        PostTopAppBar(
            icon = R.drawable.ic_arrow_back_black_24dp,
            title = "Detail User",
            onClick = onBack
        )

        LazyColumn(
            contentPadding = PaddingValues(top = 15.dp, bottom = 15.dp)
        ) {
            item {
                LoadingAndErrorItem(result = users)
            }

            if (users.data != null) {
                item {
                    Column(
                        modifier = Modifier
                            .padding(start = 15.dp, end = 15.dp)
                    ) {
                        TitleAndDescription(
                            title = stringResource(R.string.name),
                            description = users.data?.name,
                            paddingTop = false
                        )

                        TitleAndDescription(
                            title = stringResource(R.string.email),
                            description = users.data?.email
                        )

                        TitleAndDescription(
                            title = stringResource(R.string.address),
                            description = users.data?.address
                        )

                        TitleAndDescription(
                            title = stringResource(R.string.company),
                            description = users.data?.company
                        )
                    }
                }

                item {
                    Spacer(modifier = Modifier.padding(top = 10.dp))

                    Text(
                        modifier = Modifier
                            .padding(start = 15.dp, end = 15.dp),
                        text = stringResource(R.string.albums),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )
                }

                items(users.data?.albums ?: emptyList()) { albums ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = albums.name,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(top = 10.dp, start = 15.dp, end = 15.dp)
                        )

                        Spacer(modifier = Modifier.padding(bottom = 8.dp))

                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            contentPadding = PaddingValues(start = 15.dp, end = 15.dp)
                        ) {
                            items(albums.photos) { photos ->
                                val painter = rememberImagePainter(
                                    data = photos.thumbnail,
                                    builder = {
                                        transformations(RoundedCornersTransformation(16f))
                                    }
                                )

                                Box {
                                    Image(
                                        painter = painter,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(80.dp)
                                            .clickable {
                                                imageDetail.invoke(photos)
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
                    }
                }
            }
        }
    }
}