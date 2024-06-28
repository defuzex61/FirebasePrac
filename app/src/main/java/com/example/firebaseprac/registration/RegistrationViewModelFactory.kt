package com.example.firebaseprac.registration

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.firebaseprac.App
import com.example.firebaseprac.user.UserManager

class RegistrationViewModelFactory(val userManager: UserManager) : ViewModelProvider.Factory {



    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RegistrationViewModel(userManager) as T
    }
}