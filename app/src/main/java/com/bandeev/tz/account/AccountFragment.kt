package com.bandeev.tz.account

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.bandeev.tz.R

class AccountFragment: Fragment(R.layout.account_layout) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val loginButton: Button = view.findViewById(R.id.button_loginTransition)
        loginButton.setOnClickListener {
            val intent = Intent(requireContext(), LogInActivity::class.java)
            startActivity(intent)
        }
    }

}