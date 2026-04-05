package com.bandeev.feature.auth.di

import com.bandeev.feature.auth.domain.usecases.AuthWithOKUseCase
import com.bandeev.feature.auth.domain.usecases.AuthWithVKUseCase
import com.bandeev.feature.auth.domain.usecases.ForgotPasswordUseCase
import com.bandeev.feature.auth.domain.usecases.LogInUseCase
import com.bandeev.feature.auth.domain.usecases.SignUpUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<AuthWithOKUseCase> { AuthWithOKUseCase(navigator = get()) }
    factory<AuthWithVKUseCase> { AuthWithVKUseCase(navigator = get()) }
    factory<ForgotPasswordUseCase> { ForgotPasswordUseCase(myToast = get()) }
    factory<LogInUseCase> { LogInUseCase(logInClass = get()) }
    factory<SignUpUseCase> { SignUpUseCase(myToast = get()) }
}