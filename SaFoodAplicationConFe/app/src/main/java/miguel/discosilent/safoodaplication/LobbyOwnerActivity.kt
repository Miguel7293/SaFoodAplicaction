package miguel.discosilent.safoodaplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import miguel.discosilent.safoodaplication.lobyOwnerFragments.LobbyListOwnerFragment
import miguel.discosilent.safoodaplication.lobyOwnerFragments.LobbyPerfilOwnerFragment

class LobbyOwnerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lobby_owner)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_owner, LobbyListOwnerFragment.newInstance("param1", "param2"))
                .commit()
        }
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_owner, LobbyListOwnerFragment.newInstance("param1", "param2"))
                        .commit()
                    true
                }
                R.id.nav_profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_owner, LobbyPerfilOwnerFragment.newInstance("param1", "param2"))
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}