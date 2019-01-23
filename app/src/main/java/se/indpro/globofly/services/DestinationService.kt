package se.indpro.globofly.services

import retrofit2.Call
import retrofit2.http.GET
import se.indpro.globofly.models.Destination

interface DestinationService {

    @GET("destination")
    fun getDestinationList(): Call<List<Destination>>
}