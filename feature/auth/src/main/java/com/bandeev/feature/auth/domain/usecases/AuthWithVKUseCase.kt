package com.bandeev.feature.auth.domain.usecases

import com.bandeev.feature.auth.domain.repositories.AuthNavigator


class AuthWithVKUseCase(val navigator: AuthNavigator) {
    fun execute() {
        navigator.openUrl("https://vk.com")
    }
}