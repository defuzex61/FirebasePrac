package com.example.firebaseprac.registration

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firebaseprac.user.UserFirebase
import com.example.firebaseprac.user.UserManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class RegistrationViewModel(private val userManager: UserManager) : ViewModel() {
    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    var checkUser = MutableLiveData<String>()
    private var db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private var usersRef: CollectionReference = db.collection("users")
    fun regUserFireBase(login: String, pass: String){
        userManager.saveUser(login,pass)
        firebaseAuth.createUserWithEmailAndPassword(login, pass)
            .addOnSuccessListener {
                val firebaseUser: FirebaseUser? = firebaseAuth.currentUser
    //            var currentUserEmail: String? = firebaseUser?.email


                val newUser: UserFirebase = UserFirebase(firebaseUser?.email, firebaseUser?.uid)
                usersRef.id
                usersRef.add(newUser)
                    .addOnSuccessListener {
                        checkUser.value = "Успех"
                    }
                    .addOnFailureListener {
                        checkUser.value = "Не успех"
                    }
            }
            .addOnFailureListener {
                checkUser.value = "Не успех"
            }


    }
}