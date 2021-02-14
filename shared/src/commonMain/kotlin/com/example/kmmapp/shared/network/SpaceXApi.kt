package com.example.kmmapp.shared.network

import com.example.kmmapp.shared.entities.RocketLaunch
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*

/*
    Created by Konstantinos Tsiounis on 2/14/21.
*/

class SpaceXApi {

    companion object {
        private const val LAUNCHES_ENDPOINT = "https://api.spacexdata.com/v3/launches"
    }

    private val httpClient = HttpClient {
        install(JsonFeature) {
            kotlinx.serialization.json.Json { ignoreUnknownKeys = true }.also {
                serializer = KotlinxSerializer(it)
            }
        }
    }

    suspend fun getAllLaunches(): List<RocketLaunch> {
        return httpClient.get(LAUNCHES_ENDPOINT)
    }

}