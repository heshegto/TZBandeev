package com.bandeev.feature.auth.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.bandeev.feature.auth.domain.repositories.AuthNavigator

class AuthNavigatorRealisation(val context: Context): AuthNavigator {
    override fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }

        try {
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Не удалось открыть браузер", Toast.LENGTH_SHORT).show()
        }
    }
}