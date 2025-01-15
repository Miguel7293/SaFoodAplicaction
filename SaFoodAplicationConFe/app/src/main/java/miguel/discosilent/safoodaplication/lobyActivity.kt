package miguel.discosilent.safoodaplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import miguel.discosilent.safoodaplication.lobyDashboarFragments.LobbyListFragment
import miguel.discosilent.safoodaplication.lobyDashboarFragments.LobbyMapFragment
import miguel.discosilent.safoodaplication.lobyDashboarFragments.LobbyPerfilFragment

class lobyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loby)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LobbyListFragment.newInstance("param1", "param2"))
                .commit()
        }

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, LobbyListFragment.newInstance("param1", "param2"))
                        .commit()
                    true
                }
                R.id.nav_map -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, LobbyMapFragment.newInstance("param1", "param2"))
                        .commit()
                    true
                }
                R.id.nav_profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, LobbyPerfilFragment.newInstance("param1", "param2"))
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}
