package com.bandeev.feature.auth.domain.usecases

import android.content.Context
import android.content.Intent
import android.net.Uri

class AuthWithOKUseCase {
    fun execute(context: Context){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://ok.ru"))
        context.startActivity(intent)
    }
}