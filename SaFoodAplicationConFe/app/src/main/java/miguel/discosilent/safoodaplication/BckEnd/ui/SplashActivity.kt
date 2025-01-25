package miguel.discosilent.safoodaplication.BckEnd.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import miguel.discosilent.safoodaplication.BckEnd.ui.ui.theme.SaFoodAplicationTheme
import android.content.Context
import miguel.discosilent.safoodaplication.LobbyOwnerActivity

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Si lo necesitas para que sea un diseño full screen

        setContent {
            SaFoodAplicationTheme {
                SplashScreen() // Llamamos a la pantalla de bienvenida
            }
        }

        Handler(Looper.getMainLooper()).postDelayed({
            // Llamamos a LobbyOwnerActivity después de 2 segundos
            val intent = Intent(this, LobbyOwnerActivity::class.java)
            startActivity(intent)
            finish() // Finalizamos SplashActivity para evitar que el usuario regrese
        }, 2000) // Retraso de 2 segundos
    }
}

@Composable
fun SplashScreen() {
    // Usamos Scaffold para el diseño
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Text(
            text = "Cargando...",  // Puedes cambiar esto por un logo o algún mensaje
            modifier = Modifier.padding(innerPadding)
        )

        // Muestra un CircularProgressIndicator o algo que indique que está cargando
        CircularProgressIndicator(modifier = Modifier.padding(innerPadding))
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SaFoodAplicationTheme {
        SplashScreen()
    }
}
