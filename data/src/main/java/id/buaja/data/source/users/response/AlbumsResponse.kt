package id.buaja.data.source.users.response

import com.google.gson.annotations.SerializedName

data class AlbumsResponse(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("userId")
	val userId: Int? = null
)
