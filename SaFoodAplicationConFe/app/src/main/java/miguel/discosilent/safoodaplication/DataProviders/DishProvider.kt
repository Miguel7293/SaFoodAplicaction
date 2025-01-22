package miguel.discosilent.safoodaplication.DataProviders

class PlateProvider {
    companion object {
        val plates = mutableListOf(
            Plate(
                plate_id = 1,
                name = "Ceviche",
                description = "Plato a base de pescado crudo marinado en jugo de limón con ají y cebolla.",
                price = 25.50,
                available = true,
                image = "https://www.lima2019.pe/sites/default/files/inline-images/preview-gallery-006_0.jpg",
                cart_id = 1,
                category = "Mariscos"
            ),
            Plate(
                plate_id = 2,
                name = "Lomo Saltado",
                description = "Salteado de lomo de res con cebolla, tomate y papas fritas, acompañado de arroz.",
                price = 28.75,
                available = true,
                image = "https://www.lima2019.pe/sites/default/files/inline-images/preview-gallery-004_0.jpg",
                cart_id = 2,
                category = "Carne"
            ),
            Plate(
                plate_id = 3,
                name = "Ají de Gallina",
                description = "Guiso cremoso de gallina deshilachada con ají amarillo y especias.",
                price = 22.00,
                available = true,
                image = "https://www.lima2019.pe/sites/default/files/inline-images/preview-gallery-005_0.jpg",
                cart_id = 3,
                category = "Pollo"
            ),
            Plate(
                plate_id = 4,
                name = "Causa Limeña",
                description = "Pastel frío de papa amarilla relleno con pollo, atún o mariscos.",
                price = 15.50,
                available = true,
                image = "https://www.lima2019.pe/sites/default/files/inline-images/preview-gallery-008.jpg",
                cart_id = 4,
                category = "Entrada"
            ),
            Plate(
                plate_id = 5,
                name = "Pachamanca",
                description = "Cocción de carnes y tubérculos en piedras calientes bajo tierra.",
                price = 35.00,
                available = false,
                image = "https://www.lima2019.pe/sites/default/files/inline-images/preview-gallery-010.jpg",
                cart_id = 5,
                category = "Tradicional"
            ),
            Plate(
                plate_id = 6,
                name = "Arroz con Pollo",
                description = "Plato de arroz cocido con culantro, acompañado con pollo y salsa criolla.",
                price = 18.50,
                available = true,
                image = "https://www.lima2019.pe/sites/default/files/inline-images/preview-gallery-001.jpg",
                cart_id = 6,
                category = "Arroz"
            ),
            Plate(
                plate_id = 7,
                name = "Tallarines a la Huancaína",
                description = "Tallarines servidos con salsa huancaína a base de ají amarillo y queso fresco.",
                price = 20.00,
                available = true,
                image = "https://www.lima2019.pe/sites/default/files/inline-images/preview-gallery-009.jpg",
                cart_id = 7,
                category = "Pasta"
            ),
            Plate(
                plate_id = 8,
                name = "Aguadito de Pollo",
                description = "Sopa espesa de pollo con arroz y culantro, ideal para el invierno.",
                price = 14.00,
                available = true,
                image = "https://www.lima2019.pe/sites/default/files/inline-images/preview-gallery-007.jpg",
                cart_id = 8,
                category = "Sopa"
            ),
            Plate(
                plate_id = 9,
                name = "Tacu Tacu",
                description = "Mezcla de arroz y menestras sofrita en sartén, usualmente acompañado de carne.",
                price = 18.00,
                available = true,
                image = "https://www.lima2019.pe/sites/default/files/inline-images/preview-gallery-002.jpg",
                cart_id = 9,
                category = "Criollo"
            ),
            Plate(
                plate_id = 10,
                name = "Pollo a la Brasa",
                description = "Pollo asado al carbón con papas fritas y ensalada.",
                price = 24.00,
                available = true,
                image = "https://www.lima2019.pe/sites/default/files/inline-images/preview-gallery-003.jpg",
                cart_id = 10,
                category = "Parrilla"
            )
        )
    }
}
