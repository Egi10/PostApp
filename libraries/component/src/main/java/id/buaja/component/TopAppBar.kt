package id.buaja.component

import androidx.annotation.DrawableRes
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@Composable
fun PostTopAppBar(
    @DrawableRes icon: Int = 0,
    onClick: () -> Unit = {},
    title: String,
) {
    if (icon != 0) {
        TopAppBar(
            title = {
                TitleAppBar(title = title)
            },
            navigationIcon = {
                AppBarIcon(
                    icon = icon,
                    onClick = onClick
                )
            }
        )
    } else {
        TopAppBar(
            title = {
                TitleAppBar(title = title)
            }
        )
    }
}

@Composable
fun TitleAppBar(title: String) {
    Text(text = title)
}

@Composable
fun AppBarIcon(
    @DrawableRes icon: Int,
    onClick: () -> Unit,
) {
    IconButton(
        onClick = onClick
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null
        )
    }
}