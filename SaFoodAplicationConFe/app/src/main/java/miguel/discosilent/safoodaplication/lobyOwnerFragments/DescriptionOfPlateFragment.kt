package miguel.discosilent.safoodaplication.lobyOwnerFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import miguel.discosilent.safoodaplication.R

class DescriptionOfPlateFragment : Fragment() {

    // Parámetros del fragmento
    private var name: String? = null
    private var image: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_NAME) // Obtiene el nombre
            image = it.getString(ARG_IMAGE) // Obtiene la URL de la imagen
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configura los elementos de la vista
        val titleTextView: TextView = view.findViewById(R.id.titleOfPlateSelected)
        val imageView: ImageView = view.findViewById(R.id.imageViewOfPlateSelected)

        // Establece los datos
        titleTextView.text = name ?: "No Name Provided" // Fallback para evitar texto nulo
        if (!image.isNullOrEmpty()) {
            Picasso.get().load(image).into(imageView)
        } else {
            imageView.setImageResource(R.drawable.ic_logo) // Imagen por defecto
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el diseño del fragmento
        return inflater.inflate(R.layout.fragment_description_of_plate, container, false)
    }

    companion object {
        private const val ARG_NAME = "name" // Clave para el nombre
        private const val ARG_IMAGE = "image" // Clave para la URL de la imagen

        /**
         * Método estático para crear una nueva instancia del fragmento con los datos necesarios.
         */
        @JvmStatic
        fun newInstance(name: String, image: String) =
            DescriptionOfPlateFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, name)
                    putString(ARG_IMAGE, image)
                }
            }
    }
}
