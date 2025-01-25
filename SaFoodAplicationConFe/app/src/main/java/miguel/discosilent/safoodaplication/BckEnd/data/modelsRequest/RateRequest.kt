package miguel.discosilent.safoodaplication.BckEnd.data.modelsRequest

data class RateRequest(
    val points: Int,
    val description: String,
    val restaurant_id: String
)