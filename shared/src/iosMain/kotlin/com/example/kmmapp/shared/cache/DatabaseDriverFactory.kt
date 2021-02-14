package com.example.kmmapp.shared.cache

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import com.example.kmmapp.shared.cache.AppDatabase

/*
    Created by Konstantinos Tsiounis on 2/14/21.
*/

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(AppDatabase.Schema, "test.db")
    }
}