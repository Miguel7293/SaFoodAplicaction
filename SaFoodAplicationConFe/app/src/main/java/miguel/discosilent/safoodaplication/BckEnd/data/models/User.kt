package miguel.discosilent.safoodaplication.BckEnd.data.models

data class User(
    val profile_image: String,
    val email: String,
    val user_uid: String,
    val type_user: String,
    val username: String,
    val created_at: String
)