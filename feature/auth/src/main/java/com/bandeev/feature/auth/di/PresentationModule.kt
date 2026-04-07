package com.bandeev.feature.auth.di

import com.bandeev.feature.auth.presentation.LogInViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val presentationModule = module {
    viewModel<LogInViewModel> {
        LogInViewModel(
            application = get(),
            logUseCase = get(),
            signUpUseCase = get(),
            forgotPasswordUseCase = get(),
            authWithOKUseCase = get(),
            authWithVKUseCase = get()
        )
    }
}