package com.bandeev.feature.auth.domain.usecases

import com.bandeev.feature.auth.domain.models.LogInViaEmailData
import com.bandeev.feature.auth.domain.repositories.LogInViaEmail

class LogInUseCase {
    fun execute(logInClass: LogInViaEmail, data: LogInViaEmailData){
        logInClass.logIn(data)
    }
}