package com.bandeev.feature.auth.di

import com.bandeev.feature.auth.data.repository.AuthNavigatorImpl
import com.bandeev.feature.auth.data.repository.LogInViaEmailImpl
import com.bandeev.feature.auth.data.repository.MyToastImpl
import com.bandeev.feature.auth.domain.repositories.AuthNavigator
import com.bandeev.feature.auth.domain.repositories.LogInViaEmail
import com.bandeev.feature.auth.domain.repositories.MyToast
import org.koin.dsl.module

internal val dataModule = module {
    single<LogInViaEmail> { LogInViaEmailImpl(context = get()) }
    single<AuthNavigator> { AuthNavigatorImpl(context = get()) }
    single<MyToast> { MyToastImpl(context = get()) }
}