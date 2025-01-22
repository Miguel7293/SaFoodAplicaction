package miguel.discosilent.safoodaplication.BckEnd.repository

import miguel.discosilent.safoodaplication.BckEnd.data.models.User
import miguel.discosilent.safoodaplication.BckEnd.data.remote.ApiClient
import miguel.discosilent.safoodaplication.BckEnd.data.remote.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    private val apiService: ApiService = ApiClient.retrofit.create(ApiService::class.java)

    fun fetchUsers(
        onSuccess: (List<User>) -> Unit,
        onError: (String) -> Unit
    ) {
        apiService.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        onSuccess(it)
                    } ?: onError("Respuesta vacía del servidor")
                } else {
                    onError("Error: ${response.code()} - ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                onError("Excepción: ${t.message}")
            }
        })
    }

    fun createUser(
        profileImage: String,
        typeUser: String,
        username: String,
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit
    ) {
        val jsonBody = mapOf(
            "profile_image" to profileImage,
            "type_user" to typeUser,
            "username" to username
        )

        apiService.createUser(jsonBody).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    onSuccess("Usuario creado exitosamente")
                } else {
                    onError("Error: ${response.code()} - ${response.message()}")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                onError("Excepción: ${t.message}")
            }
        })
    }
}
