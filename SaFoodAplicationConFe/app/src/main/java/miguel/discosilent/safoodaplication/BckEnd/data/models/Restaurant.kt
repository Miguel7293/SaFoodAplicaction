package miguel.discosilent.safoodaplication.BckEnd.data.models

data class Restaurant(
    val restaurant_id: String,
    val name: String,
    val location: String,
    val image_of_local: String,
    val contact_number: String,
    val horario: String,
    val category: String,
    val description: String,
    val state: String,
    val id_dueno: String,
    val created_at: String,
    val coordinates: String
)