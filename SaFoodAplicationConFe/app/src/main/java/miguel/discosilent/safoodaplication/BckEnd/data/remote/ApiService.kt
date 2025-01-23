package miguel.discosilent.safoodaplication.BckEnd.data.remote

import miguel.discosilent.safoodaplication.BckEnd.data.models.Carta
import miguel.discosilent.safoodaplication.BckEnd.data.models.Plate
import miguel.discosilent.safoodaplication.BckEnd.data.models.Rate
import miguel.discosilent.safoodaplication.BckEnd.data.models.Restaurant
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

    @GET("restaurants")
    fun getRestaurantsByOwner(
        @Query("id_dueno") ownerId: String,
        @Query("select") select: String = "*"
    ): Call<List<Restaurant>>

    @GET("restaurants")
    fun getRestaurantById(
        @Query("restaurant_id") restaurantId: String,
        @Query("select") select: String = "*"
    ): Call<List<Restaurant>>

    @GET("carta")
    fun getCartaByRestCart(
        @Query("rest_cart") restCart: String,
        @Query("select") select: String = "*"
    ): Call<List<Carta>>

    @GET("plates")
    fun getPlatesByCartId(
        @Query("cart_id") cartId: String,
        @Query("select") select: String = "*"
    ): Call<List<Plate>>

    @GET("plates")
    fun getPlateById(
        @Query("plate_id") plateId: String, // El ID del plato a buscar
        @Query("select") select: String = "*"
    ): Call<List<Plate>>

    @GET("rates")
    fun getRatesByUser(
        @Query("user_restaurant") userId: String, // ID del usuario para filtrar
        @Query("select") select: String = "*"
    ): Call<List<Rate>>

    @GET("rates")
    fun getRatesByRestaurantId(
        @Query("restaurant_id") restaurantId: String, // Filtra por el ID del restaurante
        @Query("select") select: String // Seleccionamos todos los campos
    ): Call<List<Rate>>
}
