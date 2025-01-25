package miguel.discosilent.safoodaplication.BckEnd.repository

import miguel.discosilent.safoodaplication.BckEnd.data.models.Rate
import miguel.discosilent.safoodaplication.BckEnd.data.modelsRequest.RateRequest
import miguel.discosilent.safoodaplication.BckEnd.data.remote.ApiClient
import miguel.discosilent.safoodaplication.BckEnd.data.remote.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RateRepository {
    private val apiService: ApiService = ApiClient.retrofit.create(ApiService::class.java)

    fun fetchRatesByUserId(
        userId: String,
        onSuccess: (List<Rate>) -> Unit,
        onError: (String) -> Unit
    ) {
        // Se agrega el operador 'eq.' al user_restaurant (ID del usuario)
        val formattedUserId = "eq.$userId"

        apiService.getRatesByUser(formattedUserId, "*").enqueue(object : Callback<List<Rate>> {
            override fun onResponse(call: Call<List<Rate>>, response: Response<List<Rate>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        onSuccess(it)
                    } ?: run {
                        onError("Respuesta vacía del servidor")
                    }
                } else {
                    onError("Error: ${response.code()} - ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<Rate>>, t: Throwable) {
                onError("Excepción: ${t.message}")
            }
        })
    }


    fun fetchRatesByRestaurantId(
        restaurantId: String,
        onSuccess: (List<Rate>) -> Unit,
        onError: (String) -> Unit
    ) {
        // Se agrega el operador 'eq.' al restaurant_id
        val formattedRestaurantId = "eq.$restaurantId"

        apiService.getRatesByRestaurantId(formattedRestaurantId, "*").enqueue(object :
            Callback<List<Rate>> {
            override fun onResponse(call: Call<List<Rate>>, response: Response<List<Rate>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        onSuccess(it)
                    } ?: run {
                        onError("Respuesta vacía del servidor")
                    }
                } else {
                    onError("Error: ${response.code()} - ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<Rate>>, t: Throwable) {
                onError("Excepción: ${t.message}")
            }
        })
    }

    fun createRate(
        rateRequest: RateRequest,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        apiService.createRate(rateRequest).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    onSuccess() // Llama al callback de éxito
                } else {
                    onError("Error al crear rate: ${response.code()} - ${response.message()}")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                onError("Excepción al realizar la solicitud: ${t.message}")
            }
        })
    }
}