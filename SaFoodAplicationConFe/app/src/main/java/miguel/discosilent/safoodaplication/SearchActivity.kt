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

    private val restaurant = RestaurantProvider.restaurants
    private lateinit var textSearch: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)

        textSearch = findViewById(R.id.SearchText)

        textSearch.requestFocus()

        textSearch.addTextChangedListener { reference ->
            val restaurantFiltered = restaurant.filter { it.name.contains(reference.toString()) }
        }

        initRecycler()
    }

    private fun initRecycler() {
        val recyclerView = findViewById<RecyclerView>(R.id.list_searched)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = RestAdapter(restaurant)
        recyclerView.adapter = adapter
    }
}
