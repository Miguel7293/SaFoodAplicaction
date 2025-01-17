package miguel.discosilent.safoodaplication.lobyDashboarFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import miguel.discosilent.safoodaplication.R

class DescriptionOfPlateFragmentComensal : Fragment() {

    companion object {
        fun newInstance(name: String, image: String, category: String, description: String): DescriptionOfPlateFragmentComensal {
            val fragment = DescriptionOfPlateFragmentComensal()
            val args = Bundle().apply {
                putString("NAME", name)
                putString("IMAGE", image)
                putString("CATEGORY", category)
                putString("DESCRIPTION", description)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla la vista para el fragmento
        return inflater.inflate(R.layout.fragment_description_dish_comensal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recuperar los parámetros pasados
        val name = arguments?.getString("NAME")
        val image = arguments?.getString("IMAGE")
        val category = arguments?.getString("CATEGORY")
        val description = arguments?.getString("DESCRIPTION")

        // Asignar los valores a las vistas
        view.findViewById<TextView>(R.id.text_name).text = name
        view.findViewById<TextView>(R.id.text_category).text = category
        view.findViewById<TextView>(R.id.text_description).text = description

        // Cargar la imagen usando Picasso
        val imageView = view.findViewById<ImageView>(R.id.image_dish)
        Picasso.get().load(image).into(imageView)
    }
}
