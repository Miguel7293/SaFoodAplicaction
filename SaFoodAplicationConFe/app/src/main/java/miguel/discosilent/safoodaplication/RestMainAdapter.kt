package miguel.discosilent.safoodaplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MainGridAdapter(private val restaurants: List<Restaurant>) :
    RecyclerView.Adapter<MainGridAdapter.GridViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return GridViewHolder(layoutInflater.inflate(R.layout.item_search_alternate, parent, false))
    }

    override fun getItemCount(): Int = restaurants.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.render(restaurants[position])
    }

    class GridViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun render(restaurant: Restaurant) {
            val imageView = view.findViewById<ImageView>(R.id.image_rest)
            val nameTextView = view.findViewById<TextView>(R.id.name_rest)

            Picasso.get().load(restaurant.image_of_rest).into(imageView)
            nameTextView.text = restaurant.name
        }
    }
}
