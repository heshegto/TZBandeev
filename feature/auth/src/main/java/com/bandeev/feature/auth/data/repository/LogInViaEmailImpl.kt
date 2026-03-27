package com.bandeev.feature.auth.data.repository

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.bandeev.feature.auth.R
import com.bandeev.feature.auth.domain.models.LogInResult
import com.bandeev.feature.auth.domain.models.LogInViaEmailData
import com.bandeev.feature.auth.domain.repositories.LogInViaEmail
import java.net.HttpCookie

class LogInViaEmailImpl(val context: Context) : LogInViaEmail {
    override fun logIn(data: LogInViaEmailData): Boolean {
        val result = LogInResult(HttpCookie("logIn", "successful"), true)
        return result.isLoggedIn
    }

    override fun ifLogInSucceed() {
        val intent = Intent("com.bandeev.ACTION_MAIN")
        context.startActivity(intent)
    }

    override fun ifLogInFailed() {
        Toast.makeText(
            context,
            context.getString(R.string.wrong_log_in_data),
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun ifDataIsInvalid() {
        Toast.makeText(
            context,
            context.getString(R.string.invalid_log_in_data),
            Toast.LENGTH_SHORT
        ).show()
    }
}