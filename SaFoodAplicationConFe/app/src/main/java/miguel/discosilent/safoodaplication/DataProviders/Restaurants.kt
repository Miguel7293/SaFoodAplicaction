package miguel.discosilent.safoodaplication.DataProviders

data class Plate(
    val plate_id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val available: Boolean,
    val image: String,
    val cart_id: Int
)

data class Carta(
    val carta_id: Int,
    val type: String,
    val description: String,
    val rest_cart: Int,
    val updated_at: String
)

data class Restaurant(
    val restaurant_id: Int,
    val name: String,
    val location: String,
    val image_of_local: String,
    val contact_number: String,
    val horario: String,
    val category: String,
    val description: String,
    val state: String,
    val id_dueno: Int,
    val created_at: String
)

data class Rate(
    val rate_id: Int,
    val points: Int,
    val description: String,
    val user_restaurant: Int,
    val restaurant_id: Int,
    val created_at: String
)

data class User(
    val user_id: Int,
    val profile_image: String,
    val email: String,
    val token: String,
    val type_user: String,
    val username: String,
    val created_at: String
)