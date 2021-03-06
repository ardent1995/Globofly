package se.indpro.globofly.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_destiny_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import se.indpro.globofly.R
import se.indpro.globofly.helpers.DestinationAdapter
import se.indpro.globofly.models.Destination
import se.indpro.globofly.services.DestinationService
import se.indpro.globofly.services.ServiceBuilder

class DestinationListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destiny_list)

        setSupportActionBar(toolbar)
        toolbar.title = title

        fab.setOnClickListener {
            val intent = Intent(this@DestinationListActivity, DestinationCreateActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        loadDestinations()
    }

    private fun loadDestinations() {

        // To be replaced by retrofit code
        val destinationService = ServiceBuilder.buildService(DestinationService::class.java)
        val filter = HashMap<String,String>()
//        filter["country"] = "India"
//        filter["count"] = "1"
        val requestCall = destinationService.getDestinationList(filter)

        //to cancel a retrofit call
//        requestCall.cancel()
        //to check a retrofit call is canceled or not
//        requestCall.isCanceled

        requestCall.enqueue(object : Callback<List<Destination>> {
            override fun onFailure(call: Call<List<Destination>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Destination>>, response: Response<List<Destination>>) {
                if (response.isSuccessful) {
                    val destinationList = response.body()!!
                    destiny_recycler_view.adapter = DestinationAdapter(destinationList)
                }
            }

        })
    }
}
