package com.bandeev.feature.auth.domain.usecases

import android.util.Log
import com.bandeev.feature.auth.domain.repositories.MyToast

class ForgotPasswordUseCase(val myToast: MyToast) {
    fun execute(){
        Log.d("login", "Кнопка Забыл пароль нажата")
        myToast.doToast("Кнопка Забыл пароль нажата")
    }
}