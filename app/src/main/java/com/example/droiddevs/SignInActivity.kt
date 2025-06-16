package com.example.droiddevs

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

class SignInActivity : AppCompatActivity() {
    private lateinit var btnSignIn: MaterialButton
    private lateinit var tvAppTitle: MaterialTextView
    private lateinit var tvSubtitle: MaterialTextView
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        sharedPreferences = getSharedPreferences("notion_prefs", MODE_PRIVATE)
        if (isUserSignedIn()) { navigateToMain(); return }
        initializeViews()
        setupClickListeners()
    }
    private fun initializeViews() {
        btnSignIn = findViewById(R.id.btnSignIn)
        tvAppTitle = findViewById(R.id.tvAppTitle)
        tvSubtitle = findViewById(R.id.tvSubtitle)
        tvAppTitle.text = getString(R.string.app_name) // Use string resource
        tvSubtitle.text = "Your connected workspace for wiki, docs & projects"
    }
    private fun setupClickListeners() { btnSignIn.setOnClickListener { performSignIn() } }
    private fun performSignIn() { simulateSuccessfulSignIn() }
    private fun simulateSuccessfulSignIn() {
        sharedPreferences.edit()
            .putBoolean("is_signed_in", true)
            .putString("user_email", "user@example.com")
            .putString("user_name", "Demo User")
            .putString("user_id", "demo_user_123")
            .apply()
        navigateToMain()
    }
    private fun isUserSignedIn(): Boolean = sharedPreferences.getBoolean("is_signed_in", false)
    private fun navigateToMain() { startActivity(Intent(this, MainActivity::class.java)); finish() }
}