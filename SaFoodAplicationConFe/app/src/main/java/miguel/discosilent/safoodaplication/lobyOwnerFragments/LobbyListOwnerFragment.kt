package miguel.discosilent.safoodaplication.lobyOwnerFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import miguel.discosilent.safoodaplication.MainGridAdapter
import miguel.discosilent.safoodaplication.R
import miguel.discosilent.safoodaplication.DataProviders.Dish
import miguel.discosilent.safoodaplication.DataProviders.DishProvider
import miguel.discosilent.safoodaplication.lobyDashboarFragments.DescriptionOfPlateFragmentComensal

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

// Lista de platos cargada desde el proveedor
private val dishList: List<Dish> = DishProvider.dishes ?: emptyList()

class LobbyListOwnerFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configura el RecyclerView para el menú activo
        val menuActiveRecyclerView = view.findViewById<RecyclerView>(R.id.menu_now)
        val menuActiveAdapter = MainGridAdapter(dishList) { selectedDish ->
            navigateToDescription(selectedDish)
        }
        menuActiveRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        menuActiveRecyclerView.adapter = menuActiveAdapter

        // Configura el RecyclerView para el menú deshabilitado 01
        val menu01DesactivedRecyclerView = view.findViewById<RecyclerView>(R.id.menu_01_deshabilitado)
        val menu01DesactivedAdapter = MainGridAdapter(dishList) { selectedDish ->
            navigateToDescription(selectedDish)
        }
        menu01DesactivedRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        menu01DesactivedRecyclerView.adapter = menu01DesactivedAdapter

        // Configura el RecyclerView para el menú deshabilitado 02
        val menu02DesactivedRecyclerView = view.findViewById<RecyclerView>(R.id.menu_02_deshabilitado)
        val menu02DesactivedAdapter = MainGridAdapter(dishList) { selectedDish ->
            navigateToDescription(selectedDish)
        }
        menu02DesactivedRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        menu02DesactivedRecyclerView.adapter = menu02DesactivedAdapter

        // Configura el botón para agregar platos en el menú 01
        val buttonPlusOfMenu01 = view.findViewById<View>(R.id.buttonPlusOfMenu01)
        buttonPlusOfMenu01.setOnClickListener {
            navigateToAddPlate()
        }
        // Configura el botón para agregar platos en el menú 02
        val buttonPlusOfMenu02 = view.findViewById<View>(R.id.buttonPlusOfMenu02)
        buttonPlusOfMenu02.setOnClickListener {
            navigateToAddPlate()
        }
    }

    private fun navigateToDescription(dish: Dish) {
        val fragment =  DescriptionDishFragmentOwnerFragment.newInstance(
            dish.name,
            dish.image,
            dish.category,
            dish.description
        )

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_owner, fragment)
            .addToBackStack(null)
            .commit()
    }
    private fun navigateToAddPlate() {
        val fragment = AddPlateFragment()
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_owner, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lobby_list_owner, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LobbyListOwnerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
