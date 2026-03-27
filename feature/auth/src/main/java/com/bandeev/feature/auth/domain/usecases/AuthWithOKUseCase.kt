package com.bandeev.feature.auth.domain.usecases

import com.bandeev.feature.auth.domain.repositories.AuthNavigator

class AuthWithOKUseCase {
    fun execute(navigator: AuthNavigator){
        navigator.openUrl("https://ok.ru")
    }
}