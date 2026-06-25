package com.example.haya_sparkle.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.haya_sparkle.Pertemuan10.TenthActivity

class ReminderReceiver : BroadcastReceiver() {

    override fun onReceive(
        context: Context,
        intent: Intent
    ) {

        val title =
            intent.getStringExtra("title")
                ?: "Pengingat"

        val message =
            intent.getStringExtra("message")
                ?: "Reminder"

        val targetIntent =
            Intent(
                context,
                TenthActivity::class.java
            )

        NotificationHelper.showNotification(
            context,
            title,
            message,
            targetIntent
        )
    }
}