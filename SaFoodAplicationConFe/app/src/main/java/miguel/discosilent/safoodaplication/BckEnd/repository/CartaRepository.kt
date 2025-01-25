package miguel.discosilent.safoodaplication.BckEnd.repository

import miguel.discosilent.safoodaplication.BckEnd.data.models.Carta
import miguel.discosilent.safoodaplication.BckEnd.data.modelsRequest.CartaRequest
import miguel.discosilent.safoodaplication.BckEnd.data.remote.ApiClient
import miguel.discosilent.safoodaplication.BckEnd.data.remote.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartaRepository {
    private val apiService: ApiService = ApiClient.retrofit.create(ApiService::class.java)

    fun fetchCartaByRestaurant(
        restCart: String,
        onSuccess: (List<Carta>) -> Unit,
        onError: (String) -> Unit
    ) {
        // Se agrega el operador 'eq.' al rest_cart
        val formattedRestCart = "eq.$restCart"
        apiService.getCartaByRestCart(formattedRestCart, "*").enqueue(object :
            Callback<List<Carta>> {
            override fun onResponse(call: Call<List<Carta>>, response: Response<List<Carta>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        onSuccess(it)
                    } ?: onError("Respuesta vacía del servidor")
                } else {
                    onError("Error: ${response.code()} - ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<Carta>>, t: Throwable) {
                onError("Excepción: ${t.message}")
            }
        })
    }

    fun createCarta(
        cartaRequest: CartaRequest,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        apiService.createCarta(cartaRequest).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    onSuccess() // Llama al callback de éxito
                } else {
                    onError("Error al crear carta: ${response.code()} - ${response.message()}")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                onError("Excepción al realizar la solicitud: ${t.message}")
            }
        })
    }
}
