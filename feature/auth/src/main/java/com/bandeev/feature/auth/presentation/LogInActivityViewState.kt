package com.bandeev.feature.auth.presentation

import com.bandeev.feature.auth.domain.models.LogInViaEmailData

data class LogInActivityViewState(
    val logInDataState: LogInViaEmailData,
    val btnLogInIsEnabledState: Boolean
)
