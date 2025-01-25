package miguel.discosilent.safoodaplication.BckEnd.data.modelsRequest

data class RestaurantRequest(
    val name: String,
    val location: String,
    val image_of_local: String,
    val contact_number: String,
    val horario: String,
    val category: String,
    val description: String,
    val state: String,
    val coordinates: String
)