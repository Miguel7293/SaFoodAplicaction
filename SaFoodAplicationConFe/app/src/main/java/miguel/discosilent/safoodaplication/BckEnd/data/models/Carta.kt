package miguel.discosilent.safoodaplication.BckEnd.data.models

data class Carta(
    val carta_id: Int,
    val type: String,
    val description: String,
    val rest_cart: Int,
    val updated_at: String
)