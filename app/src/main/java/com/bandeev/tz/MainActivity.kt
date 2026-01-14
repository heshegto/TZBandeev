package com.bandeev.tz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.bandeev.tz.account.AccountFragment
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstancesBundle: Bundle?) {
        super.onCreate(savedInstancesBundle)
        setContentView(R.layout.main_layout)

        val bottomNavMenu = findViewById<NavigationBarView>(R.id.bottomNavMenu)
        bottomNavMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.BM_main -> {
                    setNewFragment(MainFragment())
                    true
                }
                R.id.BM_favourites -> {
                    setNewFragment(FavouritesFragment())
                    true
                }
                R.id.BM_account -> {
                    setNewFragment(AccountFragment())
                    true
                }
                else -> false
            }
        }
        if (savedInstancesBundle == null) {
            bottomNavMenu.selectedItemId = R.id.BM_main
        }
    }

    private fun setNewFragment(fragment: Fragment) {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.mainFrame, fragment)
        ft.commit()
    }
}
