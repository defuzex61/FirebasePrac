package com.example.firebaseprac.main

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.firebaseprac.App
import com.example.firebaseprac.user.UserManager

class MainViewModelFactory(val userManager: UserManager) : ViewModelProvider.Factory {



    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(userManager) as T
    }
}