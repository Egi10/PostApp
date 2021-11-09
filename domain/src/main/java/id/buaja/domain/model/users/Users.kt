package id.buaja.domain.model.users

data class Users(
    val name: String,
    val email: String,
    val address: String,
    val company: String,
    val albums: List<Albums>
)
