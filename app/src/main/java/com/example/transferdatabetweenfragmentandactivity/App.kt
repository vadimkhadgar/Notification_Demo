package com.example.transferdatabetweenfragmentandactivity

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel1 = NotificationChannel(
                CHANNEL_1_ID,
                "Channel 1",
                NotificationManager.IMPORTANCE_LOW
            )
            channel1.description = "This is Channel 1"

            val manager = getSystemService(
                NotificationManager::class.java
            )
            manager?.createNotificationChannel(channel1)

        }
    }

    companion object {
        const val CHANNEL_1_ID = "channel1"
        const val CHANNEL_2_ID = "channel2"
    }
}

//            val channel2 = NotificationChannel(
//                CHANNEL_2_ID,
//                "Channel 2",
//                NotificationManager.IMPORTANCE_LOW
//            )
//            channel2.description = "This is Channel 2"
//            manager?.createNotificationChannel(channel2)