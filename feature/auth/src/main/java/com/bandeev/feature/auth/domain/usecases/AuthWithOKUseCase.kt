package com.bandeev.feature.auth.domain.usecases

import com.bandeev.feature.auth.domain.repositories.AuthNavigator

class AuthWithOKUseCase(val navigator: AuthNavigator) {
    fun execute(){
        navigator.openUrl("https://ok.ru")
    }
}