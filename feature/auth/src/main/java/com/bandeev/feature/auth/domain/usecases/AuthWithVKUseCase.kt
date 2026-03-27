package com.bandeev.feature.auth.domain.usecases

import com.bandeev.feature.auth.domain.repositories.AuthNavigator


class AuthWithVKUseCase {
    fun execute(navigator: AuthNavigator) {
        navigator.openUrl("https://vk.com")
    }
}