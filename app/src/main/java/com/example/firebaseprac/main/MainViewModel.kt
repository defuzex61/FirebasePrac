package com.example.firebaseprac.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firebaseprac.user.UserManager
import com.google.firebase.auth.FirebaseAuth

class MainViewModel(val userManager: UserManager) : ViewModel(){
    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    val userEmail = MutableLiveData<String>()
    val userNote = MutableLiveData<String>()
    fun logOut(){
        firebaseAuth.signOut()
    }
    fun setEmailView(){
        userEmail.value = userManager.username
    }
}