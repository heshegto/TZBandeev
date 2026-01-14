package com.bandeev.tz.account

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.bandeev.tz.MainActivity
import com.bandeev.tz.R

class LogInActivity: AppCompatActivity(R.layout.login_layout) {

    fun isValidEmail(email: String): Boolean {
        return Regex("^[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.[A-Za-z]{2,}$")
            .matches(email)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val etEmail = findViewById<EditText>(R.id.edit_email)
        val etPassword = findViewById<EditText>(R.id.edit_password)
        val btnLogin = findViewById<Button>(R.id.button_logIn)
        btnLogin.isClickable = false
        btnLogin.setBackgroundColor(R.color.light_grey)

        fun updateUIState() {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString()

            btnLogin.isClickable =
                email.isNotEmpty() &&
                        password.isNotEmpty() &&
                        isValidEmail(email)

            if (btnLogin.isClickable) {
                btnLogin.setBackgroundColor(R.color.green)
            }
            else {
                btnLogin.setBackgroundColor(R.color.light_grey)
            }
        }

        etEmail.doAfterTextChanged { updateUIState() }
        etPassword.doAfterTextChanged { updateUIState() }

        btnLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        fun openUrl(url: String) {
            Log.d("debug", "button $url is pressed")
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        val btnVK = findViewById<ImageButton>(R.id.imButton_vk)
        btnVK.setOnClickListener {openUrl("https://vk.com/")}

        val btnOK = findViewById<ImageButton>(R.id.imButton_ok)
        btnOK.setOnClickListener { openUrl("https://ok.ru/") }
    }

}