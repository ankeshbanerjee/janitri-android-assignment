package com.example.janintriassignment.di.modules

import androidx.room.Room
import com.example.janintriassignment.data.db.database.HealthDatabase
import com.example.janintriassignment.data.db.repository.HealthDataRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(androidContext(), HealthDatabase::class.java, "health_db").build()
    }
    single {
        get<HealthDatabase>().healthDataDao()
    }
    single {
        HealthDataRepository(get())
    }
}