package com.example.kmmapp.shared.cache

import com.squareup.sqldelight.db.SqlDriver

/*
    Created by Konstantinos Tsiounis on 2/14/21.
*/

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}