// server.js
const express = require('express');
const cors = require('cors');
const app = express();

// Configuración
app.use(express.json());
app.use(cors());

// Ruta de ejemplo para autenticación (login)
app.post('/login', (req, res) => {
  // Validar usuario, generar JWT y enviarlo de vuelta
});

// Inicializar servidor
const PORT = process.env.PORT || 5000;
app.listen(PORT, () => console.log(`Servidor corriendo en el puerto ${PORT}`));