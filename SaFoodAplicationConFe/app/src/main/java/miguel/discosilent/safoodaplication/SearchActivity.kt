package miguel.discosilent.safoodaplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchActivity : AppCompatActivity() {

    val restaurant = RestaurantProvider.restaurants

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)
        initRecycler()
    }

    fun initRecycler(){
        val recyclerView = findViewById<RecyclerView>(R.id.list_searched)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = RestAdapter(restaurant)
        recyclerView.adapter = adapter
    }
}