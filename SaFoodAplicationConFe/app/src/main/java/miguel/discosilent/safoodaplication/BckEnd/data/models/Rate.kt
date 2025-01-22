package miguel.discosilent.safoodaplication.BckEnd.data.models

data class Rate(
    val rate_id: Int,
    val points: Int,
    val description: String,
    val user_restaurant: Int,
    val restaurant_id: Int,
    val created_at: String
)
