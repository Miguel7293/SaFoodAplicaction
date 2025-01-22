package miguel.discosilent.safoodaplication.DataProviders

import java.text.SimpleDateFormat
import java.util.*

class RestaurantProvider {
    companion object {
        val restaurants = mutableListOf(
            Restaurant(
                restaurant_id = 1,
                name = "Mayta Restaurant",
                location = "Av. Pardo y Aliaga, Lima, Perú",
                image_of_local = "https://elcomercio.pe/resizer/mrauq-1m2NOGbEMiCAlQGF42IT0=/1200x900/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/LIME7AFJ7BGSDINO4PPO4T4QGQ.jpg",
                contact_number = "+51 123 456 789",
                horario = "08:00 - 22:00",
                category = "Italiana",
                description = "Un restaurante italiano con una gran variedad de pastas y pizzas.",
                state = "Abierto",
                id_dueno = 1,
                created_at = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
            ),
            Restaurant(
                restaurant_id = 2,
                name = "Mantela Restaurant",
                location = "Jirón de la Unión, Lima, Perú",
                image_of_local = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/2d/29/28/66/bienvenido-a-mantela.jpg",
                contact_number = "+51 987 654 321",
                horario = "10:00 - 20:00",
                category = "Mexicana",
                description = "Disfruta de los mejores tacos, burritos y guacamole en un ambiente vibrante.",
                state = "Abierto",
                id_dueno = 2,
                created_at = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
            ),
            Restaurant(
                restaurant_id = 3,
                name = "Sessions Restaurant",
                location = "Av. Pueyrredón, Buenos Aires, Argentina",
                image_of_local = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/16/e2/dc/48/sessions-restaurant-acceso.jpg",
                contact_number = "+54 11 2345 6789",
                horario = "10:00 - 20:00",
                category = "Francesa",
                description = "Comida francesa gourmet con platos tradicionales y modernos.",
                state = "Abierto",
                id_dueno = 3,
                created_at = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
            ),
            Restaurant(
                restaurant_id = 4,
                name = "Panela Ajonjolí Restaurant",
                location = "Calle Las Palmas, Bogotá, Colombia",
                image_of_local = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/2d/da/f1/f0/panela-ajonjoli.jpg",
                contact_number = "+57 1 987 654 321",
                horario = "10:00 - 20:00",
                category = "Marisquería",
                description = "Ofrecemos lo mejor del mar con mariscos frescos y platos de la costa.",
                state = "Cerrado",
                id_dueno = 4,
                created_at = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
            )
        )
    }
}
