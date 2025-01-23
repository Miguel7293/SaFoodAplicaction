package miguel.discosilent.safoodaplication.BckEnd.data.models

data class Plate(
    val plate_id: String,
    val name: String,
    val description: String,
    val price: Double,
    val available: Boolean,
    val image: String,
    val cart_id: String
)