package com.example.firebaseprac.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserManager

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.firebaseprac.App
import com.example.firebaseprac.R
import com.example.firebaseprac.authorization.AuthorizationActivity
import com.example.firebaseprac.registration.RegistrationActivity

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var emailView: TextView
    lateinit var logOutButton: Button
    lateinit var recyclerView: RecyclerView
    lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val userManager = (application as App).userManager

        if (userManager.isRegisteredIn()){
            setContentView(R.layout.activity_main)
            //emailView = findViewById(R.id.email)
            logOutButton = findViewById(R.id.log_out_button)
            saveButton = findViewById(R.id.save_btn)
            recyclerView = findViewById(R.id.notesRV)
            mainViewModel = MainViewModel(userManager)
            //mainViewModel.setEmailView()
            mainViewModel.userEmail.observe(this){
                //emailView.text = it
            }

            logOutButton.setOnClickListener {
                startActivity(Intent(this, AuthorizationActivity::class.java))
                mainViewModel.logOut()
                finish()
            }
        }else{
            if (userManager.isRegisteredIn()){
                startActivity(Intent(this, AuthorizationActivity::class.java))
                finish()

            }else{
                startActivity(Intent(this, RegistrationActivity::class.java))
                finish()
            }
        }

    }


}