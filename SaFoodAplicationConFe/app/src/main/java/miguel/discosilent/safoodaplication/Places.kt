package miguel.discosilent.safoodaplication

data class Place(val latitude: Double, val longitude: Double, val title: String)

val places = listOf(
    Place(-15.825394, -70.018826, "Casa de la mascapita"),
    Place(-15.823851, -70.016626, "University de Miguel"),
    Place(-15.822765, -70.044385, "Posible cueva de Paola")
)