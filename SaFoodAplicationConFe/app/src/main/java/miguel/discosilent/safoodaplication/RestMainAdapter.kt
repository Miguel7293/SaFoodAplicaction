package miguel.discosilent.safoodaplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import miguel.discosilent.safoodaplication.DataProviders.Dish

class MainGridAdapter(
    private val dishes: List<Dish>,
    private val onItemClick: (Dish) -> Unit
) : RecyclerView.Adapter<MainGridAdapter.GridViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_search_alternate, parent, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int = dishes.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.render(dishes[position], onItemClick)
    }

    class GridViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun render(dish: Dish, onItemClick: (Dish) -> Unit) {
            val imageView = view.findViewById<ImageView>(R.id.image_rest) // Cambia R.id.image_dish por el ID correcto
            val nameTextView = view.findViewById<TextView>(R.id.name_rest) // Cambia R.id.name_dish por el ID correcto

            Picasso.get().load(dish.image).resize(500, 500).centerCrop().into(imageView)
            nameTextView.text = dish.name

            view.setOnClickListener {
                onItemClick(dish)
            }
        }
    }
}
