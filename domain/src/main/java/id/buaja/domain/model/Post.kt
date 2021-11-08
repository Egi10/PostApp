package id.buaja.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(
    val id: Int,
    val idUser: Int,
    val title: String,
    val body: String,
    val userName: String,
    val userCompanyName: String
): Parcelable
