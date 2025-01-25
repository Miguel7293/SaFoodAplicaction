package miguel.discosilent.safoodaplication.BckEnd.repository

import miguel.discosilent.safoodaplication.BckEnd.data.models.Plate
import miguel.discosilent.safoodaplication.BckEnd.data.modelsRequest.PlateRequest
import miguel.discosilent.safoodaplication.BckEnd.data.remote.ApiClient
import miguel.discosilent.safoodaplication.BckEnd.data.remote.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlateRepository {
    private val apiService: ApiService = ApiClient.retrofit.create(ApiService::class.java)

    fun fetchPlatesByCart(
        cartId: String, // ID de la carta para filtrar
        onSuccess: (List<Plate>) -> Unit, // Callback para éxito
        onError: (String) -> Unit // Callback para error
    ) {
        // Se agrega el operador 'eq.' al cart_id
        val formattedCartId = "eq.$cartId"

        apiService.getPlatesByCartId(formattedCartId, "*").enqueue(object : Callback<List<Plate>> {
            override fun onResponse(call: Call<List<Plate>>, response: Response<List<Plate>>) {
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

            override fun onFailure(call: Call<List<Plate>>, t: Throwable) {
                onError("Excepción: ${t.message}")
            }
        })
    }

    fun fetchPlateById(
        plateId: String, // ID del plato para filtrar
        onSuccess: (Plate) -> Unit,
        onError: (String) -> Unit
    ) {
        val formattedPlateId = "eq.$plateId"

        apiService.getPlateById(formattedPlateId, "*").enqueue(object : Callback<List<Plate>> {
            override fun onResponse(call: Call<List<Plate>>, response: Response<List<Plate>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        if (it.isNotEmpty()) {
                            onSuccess(it[0])
                        } else {
                            onError("Respuesta vacía del servidor")
                        }
                    } ?: run {
                        onError("Respuesta vacía del servidor")
                    }
                } else {
                    onError("Error: ${response.code()} - ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<Plate>>, t: Throwable) {
                onError("Excepción: ${t.message}")
            }
        })
    }

    fun createPlate(
        plateRequest: PlateRequest,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        apiService.createPlate(plateRequest).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    onSuccess() // Llama al callback de éxito
                } else {
                    onError("Error al crear plato: ${response.code()} - ${response.message()}")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                onError("Excepción al realizar la solicitud: ${t.message}")
            }
        })
    }

}
