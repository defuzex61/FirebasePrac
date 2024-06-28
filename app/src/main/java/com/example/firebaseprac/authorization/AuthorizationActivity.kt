package com.example.firebaseprac.authorization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.firebaseprac.App
import com.example.firebaseprac.R
import com.example.firebaseprac.main.MainActivity
import com.example.firebaseprac.registration.RegistrationActivity
import com.example.firebaseprac.registration.RegistrationViewModel
import com.example.firebaseprac.registration.RegistrationViewModelFactory

class AuthorizationActivity : AppCompatActivity() {

    lateinit var regButton: Button
    lateinit var authButton: Button
    lateinit var loginEt: EditText
    lateinit var passEt: EditText
    lateinit var authViewModel: AuthorizationActivityViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)

        authButton = findViewById(R.id.auth_button)
        regButton = findViewById(R.id.reg_button)
        loginEt = findViewById(R.id.email_input)
        passEt = findViewById(R.id.password_input)
        val userManager = (application as App).userManager
        authViewModel = ViewModelProvider(this, AuthorizationViewModelFactory(userManager))
            .get(AuthorizationActivityViewModel::class.java)


        authButton.setOnClickListener {
            val login: String = loginEt.text.toString()
            val password: String = passEt.text.toString()
            authViewModel.authorizationUserFireBase(login, password)
            authViewModel.checkUser.observe(this) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        regButton.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
            finish()
        }
    }
}