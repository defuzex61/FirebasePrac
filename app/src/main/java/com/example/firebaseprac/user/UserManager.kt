package com.example.firebaseprac.user

import com.example.firebaseprac.storage.Storage
import com.google.firebase.auth.FirebaseAuth

class UserManager(private val storage: Storage) {



    fun isRegisteredIn(): Boolean{
        return storage.getString("login").isNotEmpty()
    }
    val username: String
        get() = storage.getString("login")

    fun saveUser(login: String, pass: String){
        storage.setString("login", login)
        storage.setString("pass", pass)
    }



}