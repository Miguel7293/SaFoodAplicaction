package miguel.discosilent.safoodaplication.DataProviders

import miguel.discosilent.safoodaplication.Restaurant

class RestaurantProvider {
    companion object{
        val restaurants = mutableListOf(
            Restaurant(
                name = "Mayta Restorant",
                image_of_rest = "https://elcomercio.pe/resizer/mrauq-1m2NOGbEMiCAlQGF42IT0=/1200x900/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/LIME7AFJ7BGSDINO4PPO4T4QGQ.jpg",
                category = "Italiana",
                horario = "08:00 - 22:00"
            ),
            Restaurant(
                name = "Mantela Restorant",
                image_of_rest = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/2d/29/28/66/bienvenido-a-mantela.jpg",
                category = "Mexicana",
                horario = "10:00 - 20:00"
            ),
            Restaurant(
                name = "Sessions Restorant",
                image_of_rest = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/16/e2/dc/48/sessions-restaurant-acceso.jpg",
                category = "Francesa",
                horario = "10:00 - 20:00"
            ),
            Restaurant(
                name = "Mantela Restorant",
                image_of_rest = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/2d/da/f1/f0/panela-ajonjoli.jpg",
                category = "Marisqueria",
                horario = "10:00 - 20:00"
            )
        )
    }
}