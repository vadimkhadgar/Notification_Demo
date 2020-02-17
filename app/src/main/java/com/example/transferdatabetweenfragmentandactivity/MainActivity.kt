package com.example.transferdatabetweenfragmentandactivity

import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v4.media.session.MediaSessionCompat
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.transferdatabetweenfragmentandactivity.App.Companion.CHANNEL_1_ID
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var notificationManager: NotificationManagerCompat? = null
    private var editTextTitle: EditText? = null
    private var editTextMessage: EditText? = null

    private var mediaSession: MediaSessionCompat? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = NotificationManagerCompat.from(this)

        editTextTitle = findViewById(R.id.edit_text_title)
        editTextMessage = findViewById(R.id.edit_text_message)

        mediaSession = MediaSessionCompat(this, "tag")

        button.setOnClickListener {
            sendOnChannel1()
        }

    }

    // For testing visual git in android studio

    private fun sendOnChannel1() {
        val title: String = editTextTitle!!.text.toString()
        val message: String = editTextMessage!!.text.toString()
        val activityIntent = Intent(this, MainActivity::class.java)
        val contentIntent = PendingIntent.getActivity(
            this,
            0, activityIntent, 0
        )
        val picture = BitmapFactory.decodeResource(resources, R.drawable.ic_music_note_black_24dp)
        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_1_ID)
            .setSmallIcon(R.drawable.ic_music_note_black_24dp)
            .setContentTitle(title)
            .setContentText(message)
            .setLargeIcon(picture)
            .setStyle(NotificationCompat.BigPictureStyle().bigPicture(picture).bigLargeIcon(null))
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setCategory(NotificationCompat.CATEGORY_EVENT)
            .setContentIntent(contentIntent)
            .setAutoCancel(true)
            .setOnlyAlertOnce(true)
            .build()
        notificationManager!!.notify(1, notification)
    }
}

