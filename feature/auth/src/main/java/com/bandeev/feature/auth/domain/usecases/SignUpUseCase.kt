package com.bandeev.feature.auth.domain.usecases

import android.util.Log
import com.bandeev.feature.auth.domain.repositories.MyToast

class SignUpUseCase {
    fun execute(myToast: MyToast){
        Log.d("login","Кнопка регистрации нажата")
        myToast.doToast("Кнопка регистрации нажата")
    }
}