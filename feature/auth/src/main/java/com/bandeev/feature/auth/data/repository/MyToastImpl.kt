package com.bandeev.feature.auth.data.repository

import android.content.Context
import android.widget.Toast
import com.bandeev.feature.auth.domain.repositories.MyToast

class MyToastImpl(val context: Context): MyToast {
    override fun doToast(text: String) {
        Toast.makeText(
            context,
            text,
            Toast.LENGTH_SHORT
        ).show()
    }
}