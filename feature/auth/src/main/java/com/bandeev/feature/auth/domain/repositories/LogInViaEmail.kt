package com.bandeev.feature.auth.domain.repositories

import com.bandeev.feature.auth.domain.models.LogInResult
import com.bandeev.feature.auth.domain.models.LogInViaEmailData

interface LogInViaEmail {
    fun logIn(data: LogInViaEmailData): LogInResult
}