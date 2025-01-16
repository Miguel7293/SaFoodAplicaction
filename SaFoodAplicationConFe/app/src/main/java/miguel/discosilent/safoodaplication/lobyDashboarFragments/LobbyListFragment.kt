package miguel.discosilent.safoodaplication.lobyDashboarFragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import miguel.discosilent.safoodaplication.MainGridAdapter
import miguel.discosilent.safoodaplication.R
import miguel.discosilent.safoodaplication.Restaurant
import miguel.discosilent.safoodaplication.RestaurantProvider
import miguel.discosilent.safoodaplication.SearchActivity
import miguel.discosilent.safoodaplication.lobyOwnerFragments.DescriptionOfPlateFragment


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private val restaurant = RestaurantProvider.restaurants


class LobbyListFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configura el RecyclerView para Hot Deals
        val hotDealsRecyclerView = view.findViewById<RecyclerView>(R.id.hot_deals_recycler_view)
        val hotDealsAdapter = MainGridAdapter(restaurant) { selectedRestaurant ->
            navigateToDescription(selectedRestaurant)
        }
        hotDealsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        hotDealsRecyclerView.adapter = hotDealsAdapter

        // Configura el RecyclerView para Recommendations
        val recommendationsRecyclerView = view.findViewById<RecyclerView>(R.id.recommendations_recycler_view)
        val recommendationsAdapter = MainGridAdapter(restaurant) { selectedRestaurant ->
            navigateToDescription(selectedRestaurant)
        }
        recommendationsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recommendationsRecyclerView.adapter = recommendationsAdapter

        // Configura el campo de búsqueda
        val searchEditText: TextInputEditText = view.findViewById(R.id.editTextSearch)
        searchEditText.setOnTouchListener { _, _ ->
            val intent = Intent(requireContext(), SearchActivity::class.java)
            startActivity(intent)
            requireActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            true
        }
    }

    private fun navigateToDescription(restaurant: Restaurant) {
        // Navega al fragmento DescriptionOfPlateFragment
        val fragment = DescriptionOfPlateFragment.newInstance(restaurant.name, restaurant.image_of_rest)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla la vista para el fragmento
        return inflater.inflate(R.layout.fragment_lobby_list, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LobbyListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
