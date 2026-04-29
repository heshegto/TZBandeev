package com.bandeev.tz

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.bandeev.account_management.AccountFragment
import com.google.android.material.navigation.NavigationBarView
import com.bandeev.all_courses.presentation.AllCoursesFragment
import com.bandeev.domain.models.Course
import com.bandeev.domain.repository.CourseDetailsNavigator
import com.bandeev.favourite_courses.FavouritesFragment
import com.bandeev.tz.navigation.CourseDetailsNavigatorImpl
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), CourseDetailsNavigator {

    private val navigator: CourseDetailsNavigatorImpl by inject()

    override fun onCreate(savedInstancesBundle: Bundle?) {
        super.onCreate(savedInstancesBundle)
        setContentView(R.layout.main_layout)

        navigator.bind { course -> navigateToCourseDetails(course) }

        val bottomNavMenu = findViewById<NavigationBarView>(R.id.bottomNavMenu)
        bottomNavMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.BM_main -> {
                    setNewFragment(AllCoursesFragment())
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
    override fun onDestroy() {
        // Обязательно отвязываем, чтобы не было утечек памяти
        navigator.unbind()
        super.onDestroy()
    }
    override fun navigateToCourseDetails(course: Course) {
        Toast.makeText(this, "Navigate to course details", Toast.LENGTH_SHORT).show()
    }
}
