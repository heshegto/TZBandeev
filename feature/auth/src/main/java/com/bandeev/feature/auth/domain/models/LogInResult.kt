package com.bandeev.feature.auth.domain.models

import java.net.HttpCookie

data class LogInResult(val cookie: HttpCookie?, val isLoggedIn: Boolean)
