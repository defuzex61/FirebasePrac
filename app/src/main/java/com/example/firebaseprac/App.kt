package com.example.firebaseprac

import android.app.Application
import com.example.firebaseprac.storage.SharedPreferencesStorage
import com.example.firebaseprac.user.UserManager

open class App : Application() {
    open val userManager by lazy {
        UserManager(SharedPreferencesStorage(this))
    }
}