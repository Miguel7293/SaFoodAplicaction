package miguel.discosilent.safoodaplication.BckEnd.repository

import miguel.discosilent.safoodaplication.BckEnd.data.models.Restaurant
import miguel.discosilent.safoodaplication.BckEnd.data.modelsRequest.RestaurantRequest
import miguel.discosilent.safoodaplication.BckEnd.data.remote.ApiClient
import miguel.discosilent.safoodaplication.BckEnd.data.remote.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestaurantRepository {
    private val apiService: ApiService = ApiClient.retrofit.create(ApiService::class.java)

    fun fetchRestaurantsByOwner(
        ownerId: String, // Cambiado a String
        onSuccess: (List<Restaurant>) -> Unit,
        onError: (String) -> Unit
    ) {
        // Se agrega el operador 'eq.' al id_dueno
        val formattedOwnerId = "eq.$ownerId"
        apiService.getRestaurantsByOwner(formattedOwnerId, "*").enqueue(object :
            Callback<List<Restaurant>> {
            override fun onResponse(call: Call<List<Restaurant>>, response: Response<List<Restaurant>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        onSuccess(it)
                    } ?: onError("Respuesta vacía del servidor")
                } else {
                    onError("Error: ${response.code()} - ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<Restaurant>>, t: Throwable) {
                onError("Excepción: ${t.message}")
            }
        })
    }

    fun fetchRestaurantById(
        restaurantId: String,
        onSuccess: (Restaurant) -> Unit,
        onError: (String) -> Unit
    ) {
        val formattedRestaurantId = "eq.$restaurantId" // Se agrega el operador 'eq.' al restaurant_id
        apiService.getRestaurantById(formattedRestaurantId, "*").enqueue(object :
            Callback<List<Restaurant>> {
            override fun onResponse(call: Call<List<Restaurant>>, response: Response<List<Restaurant>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        if (it.isNotEmpty()) {
                            onSuccess(it[0])
                        } else {
                            onError("Restaurante no encontrado")
                        }
                    } ?: run {
                        onError("Respuesta vacía del servidor")
                    }
                } else {
                    onError("Error: ${response.code()} - ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<Restaurant>>, t: Throwable) {
                onError("Excepción: ${t.message}")
            }
        })
    }

    fun createRestaurant(
        restaurantRequest: RestaurantRequest,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        apiService.createRestaurant(restaurantRequest).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    onSuccess() // Llama al callback de éxito
                } else {
                    onError("Error al crear restaurante: ${response.code()} - ${response.message()}")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                onError("Excepción al realizar la solicitud: ${t.message}")
            }
        })
    }


}

