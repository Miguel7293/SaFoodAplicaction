package miguel.discosilent.safoodaplication

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class SearchActivity : AppCompatActivity() {

    private var restaurant = RestaurantProvider.restaurants
    private lateinit var textSearch: TextInputEditText
    private lateinit var adapter: RestAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)

        textSearch = findViewById(R.id.SearchText)

        textSearch.requestFocus()


        textSearch.addTextChangedListener { reference ->
            var restaurantFiltered = restaurant.filter { it.name.lowercase().contains(reference.toString().lowercase()) }
            adapter.restUpdater(restaurantFiltered)
        }

        initRecycler()
    }

    private fun initRecycler() {
        val recyclerView = findViewById<RecyclerView>(R.id.list_searched)
        adapter = RestAdapter(restaurant)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
