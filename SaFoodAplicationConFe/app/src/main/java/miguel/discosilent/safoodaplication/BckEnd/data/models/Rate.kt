package miguel.discosilent.safoodaplication.BckEnd.data.models

data class Rate(
    val rate_id: String,
    val points: String,
    val description: String,
    val user_restaurant: String,
    val restaurant_id: String,
    val created_at: String
)
