package com.bandeev.feature.auth.di

import org.koin.core.module.Module

val authModule = arrayOf<Module>(
    dataModule,
    domainModule,
    presentationModule
)