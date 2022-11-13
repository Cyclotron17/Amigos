package com.example.amigos


import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUp : AppCompatActivity() {

    lateinit var etEmail: EditText
    lateinit var usrnm: EditText
    private lateinit var etPass: EditText
    private lateinit var btnSignUp: Button
    lateinit var tvrdrct: TextView

    // create Firebase authentication object
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        usrnm=findViewById(R.id.username)
        etEmail = findViewById(R.id.emailadress)
        etPass = findViewById(R.id.pswrd)
        btnSignUp = findViewById(R.id.btnSSigned)

        tvrdrct = findViewById(R.id.tvRedirectLogin)

        auth = Firebase.auth

        btnSignUp.setOnClickListener {
            try{
                signUpUser()
//code that may throw exception
            }catch(e: Exception){
                Log.e(TAG,"error idhar")
//code that handles exception
            }

        }

        // switching from signUp Activity to Login Activity
        tvrdrct.setOnClickListener {
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
        }
    }
    private fun signUpUser() {
        val email = etEmail.text.toString()
        val pass = etPass.text.toString()
        val user= usrnm.text.toString()
        //val confirmPassword = etConfPass.text.toString()

        // check pass
        if (email.isBlank() || pass.isBlank() || user.isBlank()) {
            Toast.makeText(this, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
            return
        }

        /*       if (pass != confirmPassword) {
                   Toast.makeText(this, "Password and Confirm Password do not match", Toast.LENGTH_SHORT)
                       .show()
                   return
               } */
        // If all credential are correct
        // We call createUserWithEmailAndPassword
        // using auth object and pass the
        // email and pass in it.
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully Singed Up", Toast.LENGTH_SHORT).show()
                val intent = Intent(this,HomePage::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Singed Up Failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}