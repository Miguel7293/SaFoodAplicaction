-- Insertar usuarios
INSERT INTO users (profile_image, email, token, type_user, username, created_at)
VALUES
    ('https://example.com/profiles/user1.jpg', 'owner1@example.com', 'abc123', 'dueño', 'Juan Perez', NOW()),
    ('https://example.com/profiles/user2.jpg', 'owner2@example.com', 'def456', 'dueño', 'Maria Garcia', NOW()),
    ('https://example.com/profiles/client1.jpg', 'client1@example.com', 'ghi789', 'cliente', 'Carlos Lopez', NOW()),
    ('https://example.com/profiles/client2.jpg', 'client2@example.com', 'jkl012', 'cliente', 'Ana Ruiz', NOW());

-- Insertar restaurantes
INSERT INTO restaurants (name, location, image_of_local, contact_number, horario, category, description, state, id_dueno, created_at)
VALUES
    ('La Parrilla Feliz', 'Av. Principal 123, Ciudad', 'https://example.com/restaurants/parrilla.jpg', '555-1234', 'Lunes-Domingo: 12:00-22:00', 'Parrilla', 'Especialidad en carnes a la parrilla', 'Abierto', 1, NOW()),
    ('Café Delicias', 'Calle Secundaria 456, Ciudad', 'https://example.com/restaurants/cafe.jpg', '555-5678', 'Lunes-Viernes: 8:00-20:00', 'Cafetería', 'Café y postres caseros', 'Abierto', 2, NOW());

-- Insertar cartas
INSERT INTO carta (type, description, rest_cart, updated_at)
VALUES
    ('Bebidas', 'Bebidas frías y calientes', 1, NOW()),
    ('Comida', 'Platos principales y entradas', 1, NOW()),
    ('Postres', 'Postres caseros y helados', 2, NOW());

-- Insertar platos
INSERT INTO plates (name, description, price, available, image, cart_id)
VALUES
    ('Lomo a la parrilla', 'Carne de res jugosa a la parrilla con guarnición', 12.50, TRUE, 'https://example.com/plates/lomo.jpg', 2),
    ('Ensalada César', 'Lechuga fresca, crutones, pollo y aderezo César', 8.00, TRUE, 'https://example.com/plates/cesar.jpg', 2),
    ('Café Americano', 'Café negro caliente', 2.00, TRUE, 'https://example.com/plates/cafe.jpg', 1),
    ('Cheesecake de fresa', 'Pastel cremoso con fresas frescas', 4.50, TRUE, 'https://example.com/plates/cheesecake.jpg', 3);

-- Insertar calificaciones
INSERT INTO rates (points, description, user_restaurant, restaurant_id, created_at)
VALUES
    (5, 'Excelente atención y comida deliciosa.', 3, 1, NOW()),
    (4, 'Muy buen café, pero algo caro.', 4, 2, NOW());
