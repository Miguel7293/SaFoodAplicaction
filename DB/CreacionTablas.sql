-- Crear tabla de usuarios
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    profile_image TEXT,
    email VARCHAR(100) UNIQUE NOT NULL,
    token TEXT,
    type_user VARCHAR(20) NOT NULL, -- Cliente o dueño
    username VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT NOW() -- Fecha de registro

);

-- Crear tabla de restaurantes
CREATE TABLE restaurants (
    restaurant_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    location TEXT NOT NULL,
    image_of_local TEXT,
    contact_number VARCHAR(20) NOT NULL,
    horario VARCHAR(255) NOT NULL,
    category VARCHAR(50),
    description TEXT,
    state VARCHAR(20), -- Abierto o cerrado
    id_dueno INT NOT NULL REFERENCES users(user_id), -- Relación con usuario dueño
    created_at TIMESTAMP DEFAULT NOW() -- Fecha de registro

);

-- Crear tabla de cartas
CREATE TABLE carta (
    carta_id SERIAL PRIMARY KEY,
    type VARCHAR(50) NOT NULL, -- Ejemplo: bebida, comida
    description TEXT,
    rest_cart INT NOT NULL REFERENCES restaurants(restaurant_id), -- Relación con restaurante
    updated_at TIMESTAMP DEFAULT NOW() -- Última actualización
);

-- Crear tabla de platos
CREATE TABLE plates (
    plate_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price NUMERIC(8, 2) NOT NULL,
    available BOOLEAN DEFAULT TRUE, -- Indica si el plato está disponible
    image TEXT,
    cart_id INT NOT NULL REFERENCES carta(carta_id) -- Relación con la carta
);

-- Crear tabla de calificaciones (rates)
CREATE TABLE rates (
    rate_id SERIAL PRIMARY KEY,
    points INT CHECK (points BETWEEN 1 AND 5), -- Puntuación entre 1 y 5
    description TEXT,
    user_restaurant INT NOT NULL REFERENCES users(user_id), -- Usuario que califica
    restaurant_id INT NOT NULL REFERENCES restaurants(restaurant_id), -- Restaurante calificado
    created_at TIMESTAMP DEFAULT NOW() -- Fecha de la calificación
);


ALTER TABLE rates ADD CONSTRAINT unique_user_restaurant_rate UNIQUE (user_restaurant, restaurant_id); --- un usuario pueda calificar un restaurante solo una vez
