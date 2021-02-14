package com.example.kmmapp.shared

import com.example.kmmapp.shared.cache.Database
import com.example.kmmapp.shared.cache.DatabaseDriverFactory
import com.example.kmmapp.shared.entities.RocketLaunch
import com.example.kmmapp.shared.network.SpaceXApi

/*
    Created by Konstantinos Tsiounis on 2/14/21.
*/

class SpaceXSDK(databaseDriverFactory: DatabaseDriverFactory) {

    private val database = Database(databaseDriverFactory)
    private val api = SpaceXApi()

    @Throws(Exception::class) suspend fun getLaunches(forceReload: Boolean): List<RocketLaunch> {
        val cachedLaunches = database.getAllLaunches()
        return if (cachedLaunches.isNotEmpty() && !forceReload) {
            cachedLaunches
        } else {
            api.getAllLaunches().also {
                database.clearDatabase()
                database.createLaunches(it)
            }
        }
    }

}