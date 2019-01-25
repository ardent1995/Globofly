package se.indpro.globofly.services

import retrofit2.Call
import retrofit2.http.*
import se.indpro.globofly.models.Destination

interface DestinationService {

//    @Headers("x-device-type: Android","x-foo: bar")
    @GET("destination")
    fun getDestinationList(@QueryMap filter: HashMap<String, String>): Call<List<Destination>>

    @GET("destination/{id}")
    fun getDestination(@Path("id") id: Int): Call<Destination>

    @POST("destination")
    fun addDestination(@Body destination: Destination) : Call<Destination>

    @FormUrlEncoded
    @PUT("destination/{id}")
    fun updateDestination(@Path("id") id: Int,
                          @Field("city") city: String,
                          @Field("country") country:String,
                          @Field("description") descriptor: String): Call<Destination>

    @DELETE("destination/{id}")
    fun deleteDestination(@Path("id") id: Int):Call<Unit>
}