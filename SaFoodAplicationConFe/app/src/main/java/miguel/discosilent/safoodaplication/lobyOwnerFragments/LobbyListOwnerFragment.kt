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
import miguel.discosilent.safoodaplication.Restaurant
import miguel.discosilent.safoodaplication.DataProviders.RestaurantProvider

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private val restaurant = RestaurantProvider.restaurants

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
        val menuActiveAdapter = MainGridAdapter(restaurant) { selectedRestaurant ->
            navigateToDescription(selectedRestaurant)
        }
        menuActiveRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        menuActiveRecyclerView.adapter = menuActiveAdapter

        // Configura el RecyclerView para el menú deshabilitado 01
        val menu01DesactivedRecyclerView = view.findViewById<RecyclerView>(R.id.menu_01_deshabilitado)
        val menu01DesactivedAdapter = MainGridAdapter(restaurant) { selectedRestaurant ->
            navigateToDescription(selectedRestaurant)
        }
        menu01DesactivedRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        menu01DesactivedRecyclerView.adapter = menu01DesactivedAdapter

        // Configura el RecyclerView para el menú deshabilitado 02
        val menu02DesactivedRecyclerView = view.findViewById<RecyclerView>(R.id.menu_02_deshabilitado)
        val menu02DesactivedAdapter = MainGridAdapter(restaurant) { selectedRestaurant ->
            navigateToDescription(selectedRestaurant)
        }
        menu02DesactivedRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        menu02DesactivedRecyclerView.adapter = menu02DesactivedAdapter
    }

    private fun navigateToDescription(restaurant: Restaurant) {
        // Navega al fragmento DescriptionOfPlateFragment
        val fragment = DescriptionOfPlateFragment.newInstance(restaurant.name, restaurant.image_of_rest)
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
