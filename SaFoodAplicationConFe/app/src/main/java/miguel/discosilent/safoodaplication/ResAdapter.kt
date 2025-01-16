package miguel.discosilent.safoodaplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RestAdapter(var restaurants: List<Restaurant>) :
    RecyclerView.Adapter<RestAdapter.RestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RestViewHolder(layoutInflater.inflate(R.layout.item_search, parent, false))
    }

    override fun getItemCount(): Int = restaurants.size

    override fun onBindViewHolder(holder: RestViewHolder, position: Int) {
        holder.render(restaurants[position])
    }

    fun restUpdater(restaurants: List<Restaurant>) {
        this.restaurants = restaurants
        notifyDataSetChanged()
    }


    class RestViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun render(restaurant: Restaurant) {
            val horaryTextView = view.findViewById<TextView>(R.id.horary_res)
            val nameTextView = view.findViewById<TextView>(R.id.name_rest)
            val imageView = view.findViewById<ImageView>(R.id.image_rest)
            val CategoryResTextView = view.findViewById<TextView>(R.id.category_res)

            Picasso.get().load(restaurant.image_of_rest).resize(500, 500).centerCrop()
                .into(imageView)
            horaryTextView.text = restaurant.horario
            nameTextView.text = restaurant.name
            CategoryResTextView.text = restaurant.category

        }
    }


}

