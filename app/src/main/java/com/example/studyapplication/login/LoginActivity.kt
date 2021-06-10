package com.example.studyapplication.login

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.studyapplication.R
import com.example.studyapplication.databinding.ActivityLoginBinding
import kotlinx.coroutines.delay

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.btnLogin.setOnClickListener {
            binding.btnLogin.setLoading()
        }
    }
}