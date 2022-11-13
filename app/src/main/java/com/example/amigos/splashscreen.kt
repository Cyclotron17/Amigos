package com.example.amigos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Splash_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
/*
        Handler().postDelayed(Runnable {
            startActivity(Intent(this,SignUp::class.java))},2000)  */
        val user = Firebase.auth.currentUser

        if (user != null) {
            // User is signed in
            Handler().postDelayed(Runnable {
                startActivity(Intent(this,MainActivity::class.java))},2000)
        }

        else {
            // No user is signed in

            Handler().postDelayed(Runnable {
                startActivity(Intent(this,SignUp::class.java))},2000)
        }
    }
}
