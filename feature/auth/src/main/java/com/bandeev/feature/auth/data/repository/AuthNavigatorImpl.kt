package com.bandeev.feature.auth.data.repository

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.net.toUri
import com.bandeev.feature.auth.R
import com.bandeev.feature.auth.domain.repositories.AuthNavigator

class AuthNavigatorImpl(val context: Context) : AuthNavigator {
    override fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, url.toUri()).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }

        try {
            context.startActivity(intent)
        } catch (e: Exception) {
            MyToastImpl(context).doToast(context.getString(R.string.browser_error))
            Log.d("login", "${context.getString(R.string.browser_error)}. Error: ${e.message}")
        }
    }
}