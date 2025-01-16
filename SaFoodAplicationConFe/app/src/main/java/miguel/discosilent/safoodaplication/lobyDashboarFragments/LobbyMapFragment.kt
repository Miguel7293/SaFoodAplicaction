package miguel.discosilent.safoodaplication.lobyDashboarFragments

import android.Manifest
import android.content.pm.PackageManager
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import miguel.discosilent.safoodaplication.Place
import miguel.discosilent.safoodaplication.R
import miguel.discosilent.safoodaplication.places

class LobbyMapFragment : Fragment(), OnMapReadyCallback {
    private lateinit var map: GoogleMap

    companion object {
        const val REQUEST_CODE_LOCATION = 0
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        // Método para crear una nueva instancia del fragmento con parámetros
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LobbyMapFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onCreateView(
        inflater: android.view.LayoutInflater, container: android.view.ViewGroup?,
        savedInstanceState: Bundle?
    ): android.view.View? {
        val param1 = arguments?.getString(ARG_PARAM1)
        val param2 = arguments?.getString(ARG_PARAM2)

        // Aquí puedes usar los parámetros param1 y param2 si los necesitas
        val view = inflater.inflate(R.layout.fragment_lobby_map, container, false)
        createFragment()
        return view
    }

    // Método para crear el fragmento de mapa
    private fun createFragment() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
            ?: SupportMapFragment.newInstance().also {
                childFragmentManager.beginTransaction()
                    .replace(R.id.map, it)
                    .commit()
            }
        mapFragment.getMapAsync(this)
    }

    // Callback cuando el mapa está listo
    override fun onMapReady(googleMap: GoogleMap) {
        this.map = googleMap
        createMarkers(places)
        enableLocation()
        setCustomMapStyle()
    }

    // Crear los marcadores en el mapa
    private fun createMarkers(places: List<Place>) {
        for (place in places) {
            val location = LatLng(place.latitude, place.longitude)
            map.addMarker(MarkerOptions().position(location).title(place.title))
        }
    }

    // Comprobar si se tiene permiso de ubicación
    private fun isLocationPermissionGranted(): Boolean = ContextCompat.checkSelfPermission(
        requireContext(),
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    // Habilitar la ubicación en el mapa si el permiso es concedido
    private fun enableLocation() {
        if (!::map.isInitialized) return
        if (isLocationPermissionGranted()) {
            map.isMyLocationEnabled = true
        } else {
            requestLocationPermission()
        }
    }

    // Solicitar permiso de ubicación si no está concedido
    private fun requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        ) {
            Toast.makeText(requireContext(), "Ve y activa los permisos de ubicación", Toast.LENGTH_SHORT).show()
        } else {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_CODE_LOCATION
            )
        }
    }

    // Resultado de la solicitud de permisos
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            REQUEST_CODE_LOCATION -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                map.isMyLocationEnabled = true
            } else {
                Toast.makeText(
                    requireContext(),
                    "Para activar los permisos ve a ajustes y acéptalos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }


    private fun setCustomMapStyle() {
        try {
            // Carga el estilo desde el archivo JSON
            val success = map.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                    requireContext(),
                    R.raw.map_style
                )
            )
            if (!success) {
                Log.e("MapStyle", "Error al aplicar el estilo del mapa.")
            }
        } catch (e: Resources.NotFoundException) {
            Log.e("MapStyle", "No se encontró el estilo del mapa. Error: ", e)
        }
    }
}
