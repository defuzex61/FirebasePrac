package com.example.firebaseprac.registration

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.firebaseprac.App
import com.example.firebaseprac.R
import com.example.firebaseprac.authorization.AuthorizationActivity
import com.example.firebaseprac.main.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RegistrationActivity : AppCompatActivity() {
    lateinit var regButton: Button
    lateinit var authButton: Button
    lateinit var loginEt: EditText
    lateinit var passEt: EditText
    lateinit var regViewModel: RegistrationViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        authButton = findViewById(R.id.auth2_button)
        regButton = findViewById(R.id.reg_button)
        loginEt = findViewById(R.id.email_input)
        passEt = findViewById(R.id.password_input)

        val userManager = (application as App).userManager

        regViewModel = ViewModelProvider(this, RegistrationViewModelFactory(userManager))
            .get(RegistrationViewModel::class.java)

        authButton.setOnClickListener {
            startActivity(Intent(this, AuthorizationActivity::class.java))
            finish()
        }
        regButton.setOnClickListener{
            val login: String = loginEt.text.toString()
            val password: String = passEt.text.toString()
            regViewModel.regUserFireBase(login,password)
            regViewModel.checkUser.observe(this) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                if (it.equals("Успех")) {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }


        }
    }

}