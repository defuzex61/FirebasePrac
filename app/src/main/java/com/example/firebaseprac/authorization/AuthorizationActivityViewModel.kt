package com.example.firebaseprac.authorization

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firebaseprac.user.UserFirebase
import com.example.firebaseprac.user.UserManager
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class AuthorizationActivityViewModel(val userManager: UserManager) : ViewModel() {
    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()


    var checkUser = MutableLiveData<String>()

    fun authorizationUserFireBase(login: String, pass: String){

        firebaseAuth.signInWithEmailAndPassword(login,pass)
            .addOnSuccessListener {
                userManager.saveUser(login,pass)
                checkUser.value = "Успех успешный"

            }
            .addOnFailureListener {
                checkUser.value = "Нет успеха"
            }
    }
}