package com.bandeev.feature.auth.domain.usecases

import com.bandeev.feature.auth.domain.models.LogInViaEmailData
import com.bandeev.feature.auth.domain.repositories.LogInViaEmail

class LogInUseCase(val logInClass: LogInViaEmail) {
    fun execute(data: LogInViaEmailData){
        if (data.isValid()) {
            if (logInClass.logIn(data)) {
                logInClass.ifLogInSucceed()
            } else {
                logInClass.ifLogInFailed()
            }
        } else {
            logInClass.ifDataIsInvalid()
        }
    }
}