package com.example.aplicacaoteste.Activity

import VehiclesQuery
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.toDeferred
import com.example.aplicacaoteste.R
import okhttp3.OkHttpClient
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url : String = "https://swapi.graph.cool/"

        val cliente : OkHttpClient = OkHttpClient()



        val okHttpClient = OkHttpClient().newBuilder().build()
        val client : ApolloClient = ApolloClient.builder()
                                                .serverUrl(url)
                                                .okHttpClient(okHttpClient)
                                                .build()
        val vehiclesQuery = VehiclesQuery.builder()
            .build()

        CoroutineScope(Dispatchers.IO).launch {
            val res = client.query(vehiclesQuery).toDeferred().await()

            Log.wtf("oi", "oi")
        }
    }
}
