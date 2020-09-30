package com.example.stackoverflow.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.loadFragment(container: Int, fragment: Fragment, isReplace: Boolean = true) {
    if (isReplace)
        this.supportFragmentManager.beginTransaction().replace(container, fragment).commit()
    else
        this.supportFragmentManager.beginTransaction().addToBackStack(fragment.tag)
            .add(container, fragment).commit()
}