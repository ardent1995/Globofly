package se.indpro.globofly.services

import retrofit2.Call
import retrofit2.http.*
import se.indpro.globofly.models.Destination

interface DestinationService {

    @GET("destination")
    fun getDestinationList(@QueryMap filter: HashMap<String, String>): Call<List<Destination>>

    @GET("destination/{id}")
    fun getDestination(@Path("id") id: Int): Call<Destination>

    @POST("destination")
    fun addDestination(@Body destination: Destination) : Call<Destination>
}