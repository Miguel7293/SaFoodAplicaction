package miguel.discosilent.safoodaplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MainGridAdapter(
    private val restaurants: List<Restaurant>,
    private val onItemClick: (Restaurant) -> Unit
) : RecyclerView.Adapter<MainGridAdapter.GridViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_search_alternate, parent, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int = restaurants.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.render(restaurants[position], onItemClick)
    }

    class GridViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun render(restaurant: Restaurant, onItemClick: (Restaurant) -> Unit) {
            val imageView = view.findViewById<ImageView>(R.id.image_rest)
            val nameTextView = view.findViewById<TextView>(R.id.name_rest)

            Picasso.get().load(restaurant.image_of_rest).resize(500, 500).centerCrop()
                .into(imageView)
            nameTextView.text = restaurant.name

            view.setOnClickListener {
                onItemClick(restaurant)
            }
        }
    }
}
