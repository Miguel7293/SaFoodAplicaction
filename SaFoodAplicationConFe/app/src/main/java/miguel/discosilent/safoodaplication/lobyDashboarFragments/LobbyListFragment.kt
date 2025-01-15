package miguel.discosilent.safoodaplication.lobyDashboarFragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import miguel.discosilent.safoodaplication.MainGridAdapter
import miguel.discosilent.safoodaplication.R
import miguel.discosilent.safoodaplication.RestaurantProvider
import miguel.discosilent.safoodaplication.SearchActivity


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private val restaurant = RestaurantProvider.restaurants

class LobbyListFragment : Fragment() {
    // TODO: Rename and change types of parameters
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


        // Configura el RecyclerView para Hot Deals
        val hotDealsRecyclerView = view.findViewById<RecyclerView>(R.id.hot_deals_recycler_view)
        val hotDealsAdapter = MainGridAdapter(restaurant) // Lista de Hot Deals
        hotDealsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        hotDealsRecyclerView.adapter = hotDealsAdapter

        // Configura el RecyclerView para Recommendations
        val recommendationsRecyclerView = view.findViewById<RecyclerView>(R.id.recommendations_recycler_view)
        val recommendationsAdapter = MainGridAdapter(restaurant) // Lista de Recommendations
        recommendationsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recommendationsRecyclerView.adapter = recommendationsAdapter



        // Encuentra el Edit Text por ID
        val searchText: EditText = view.findViewById(R.id.editTextSearch)


        // Configura el click listener para abrir SearchActivity
        searchText.setOnClickListener {
            val intent = Intent(requireContext(), SearchActivity::class.java)
            startActivity(intent)
            // Aplica la transición suave
            requireActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lobby_list, container, false)
    }

    companion object {
        // TODO: Rename and change types and number of parameters
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