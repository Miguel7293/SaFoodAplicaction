package miguel.discosilent.safoodaplication.DataProviders

import miguel.discosilent.safoodaplication.DataProviders.Dish

class DishProvider {
    companion object {
        val dishes = mutableListOf(
            Dish(
                name = "Ceviche",
                image = "https://www.lima2019.pe/sites/default/files/inline-images/preview-gallery-006_0.jpg",
                category = "Mariscos",
                description = "Plato a base de pescado crudo marinado en jugo de limón con ají y cebolla."
            ),
            Dish(
                name = "Lomo Saltado",
                image = "https://www.lima2019.pe/sites/default/files/inline-images/preview-gallery-004_0.jpg",
                category = "Carne",
                description = "Salteado de lomo de res con cebolla, tomate y papas fritas, acompañado de arroz."
            ),
            Dish(
                name = "Ají de Gallina",
                image = "https://www.lima2019.pe/sites/default/files/inline-images/preview-gallery-005_0.jpg",
                category = "Pollo",
                description = "Guiso cremoso de gallina deshilachada con ají amarillo y especias."
            ),
            Dish(
                name = "Causa Limeña",
                image = "https://www.lima2019.pe/sites/default/files/inline-images/preview-gallery-008.jpg",
                category = "Entrada",
                description = "Pastel frío de papa amarilla relleno con pollo, atún o mariscos."
            ),
            Dish(
                name = "Pachamanca",
                image = "https://www.lima2019.pe/sites/default/files/inline-images/preview-gallery-010.jpg",
                category = "Tradicional",
                description = "Cocción de carnes y tubérculos en piedras calientes bajo tierra."
            ),
            Dish(
                name = "Arroz con Pollo",
                image = "https://www.lima2019.pe/sites/default/files/inline-images/preview-gallery-001.jpg",
                category = "Arroz",
                description = "Plato de arroz cocido con culantro, acompañado con pollo y salsa criolla."
            ),
            Dish(
                name = "Tallarines a la Huancaína",
                image = "https://www.lima2019.pe/sites/default/files/inline-images/preview-gallery-009.jpg",
                category = "Pasta",
                description = "Tallarines servidos con salsa huancaína a base de ají amarillo y queso fresco."
            ),
            Dish(
                name = "Aguadito de Pollo",
                image = "https://www.lima2019.pe/sites/default/files/inline-images/preview-gallery-007.jpg",
                category = "Sopa",
                description = "Sopa espesa de pollo con arroz y culantro, ideal para el invierno."
            ),
            Dish(
                name = "Tacu Tacu",
                image = "https://www.lima2019.pe/sites/default/files/inline-images/preview-gallery-002.jpg",
                category = "Criollo",
                description = "Mezcla de arroz y menestras sofrita en sartén, usualmente acompañado de carne."
            ),
            Dish(
                name = "Pollo a la Brasa",
                image = "https://www.lima2019.pe/sites/default/files/inline-images/preview-gallery-003.jpg",
                category = "Parrilla",
                description = "Pollo asado al carbón con papas fritas y ensalada."
            )
        )
    }
}
