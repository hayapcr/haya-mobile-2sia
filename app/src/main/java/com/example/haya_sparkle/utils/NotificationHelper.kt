package com.example.haya_sparkle.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.haya_sparkle.R

object NotificationHelper {

    private const val CHANNEL_ID = "default_channel"

    fun showNotification(
        context: Context,
        title: String,
        message: String,
        intent: Intent
    ) {

        val manager =
            context.getSystemService(
                Context.NOTIFICATION_SERVICE
            ) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel =
                NotificationChannel(
                    CHANNEL_ID,
                    "General",
                    NotificationManager.IMPORTANCE_HIGH
                )

            manager.createNotificationChannel(channel)
        }

        val pendingIntent =
            PendingIntent.getActivity(
                context,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or
                        PendingIntent.FLAG_IMMUTABLE
            )

        val bitmap = BitmapFactory.decodeResource(
            context.resources,
            R.mipmap.ic_launcher
        )

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setLargeIcon(bitmap)
            .setContentTitle(title)
            .setContentText(message)
            .setColor(ContextCompat.getColor(context, R.color.primaryGreen))
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .build()

        manager.notify(
            System.currentTimeMillis().toInt(),
            notification
        )
    }
}