package com.example.janintriassignment.app

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.example.janintriassignment.di.modules.databaseModule
import com.example.janintriassignment.di.modules.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@BaseApplication)
            modules(listOf(databaseModule, viewModelsModule))
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // Create the NotificationChannel.
            val name = CHANNEL_NAME
            val descriptionText = "Daily Chronicles Reminder Notification"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel = NotificationChannel(CHANNEL_ID, name, importance)
            mChannel.description = descriptionText
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
        }
    }

    companion object{
        const val CHANNEL_ID = "channel_id"
        const val CHANNEL_NAME = "Log Vitals Reminder"
    }
}