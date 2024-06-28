package com.example.firebaseprac.authorization

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.firebaseprac.App
import com.example.firebaseprac.user.UserManager

class AuthorizationViewModelFactory(val userManager: UserManager) : ViewModelProvider.Factory {



    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthorizationActivityViewModel(userManager) as T
    }
}