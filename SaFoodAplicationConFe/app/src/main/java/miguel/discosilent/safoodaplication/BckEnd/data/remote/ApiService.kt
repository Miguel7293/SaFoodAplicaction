package miguel.discosilent.safoodaplication.BckEnd.data.remote

import miguel.discosilent.safoodaplication.BckEnd.data.models.User
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("users")
    fun getUsers(): Call<List<User>>

    @POST("users")
    fun createUser(
        @Body user: Map<String, String>
    ): Call<Void>
}
