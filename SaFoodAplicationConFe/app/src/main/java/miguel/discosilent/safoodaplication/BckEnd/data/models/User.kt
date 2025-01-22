package miguel.discosilent.safoodaplication.BckEnd.data.models

data class User(
    val user_id: Int,
    val profile_image: String,
    val email: String,
    val token: String,
    val type_user: String,
    val username: String,
    val created_at: String
)