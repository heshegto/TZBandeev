package com.bandeev.feature.auth.data.repository

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.bandeev.feature.auth.domain.repositories.AuthNavigator
import androidx.core.net.toUri

class AuthNavigatorImpl(val context: Context): AuthNavigator {
    override fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, url.toUri()).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }

        try {
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Не удалось открыть браузер", Toast.LENGTH_SHORT).show()
        }
    }
}