package miguel.discosilent.safoodaplication.BckEnd.data.modelsRequest

data class PlateRequest(
    val name: String,
    val description: String,
    val price: Double,
    val available: Boolean,
    val image: String,
    val cart_id: String
)