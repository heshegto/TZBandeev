package com.bandeev.feature.auth.data.repository

import android.content.Context
import android.content.Intent
import com.bandeev.feature.auth.domain.models.LogInResult
import com.bandeev.feature.auth.domain.models.LogInViaEmailData
import com.bandeev.feature.auth.domain.repositories.LogInViaEmail
import java.net.HttpCookie

class LogInViaEmailImpl(val context: Context): LogInViaEmail {
    override fun logIn(data: LogInViaEmailData,): LogInResult {
        val intent = Intent("com.bandeev.ACTION_MAIN")
        context.startActivity(intent)
        return LogInResult(HttpCookie("logIn", "successful"), true)
    }
}