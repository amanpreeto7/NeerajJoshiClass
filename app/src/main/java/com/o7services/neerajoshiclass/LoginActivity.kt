package com.o7services.neerajoshiclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.o7services.neerajoshiclass.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvLogin.setText("123")

        //watcher
        binding.etEmail.doOnTextChanged { text, start, before, count ->
            if(text?.isNotEmpty() == true){
                binding.tilEmail.error = null
            }else{
                binding.tilEmail.error = "Enter email"
            }
        }

        binding.btnLogin.setOnClickListener {
            if(binding.etEmail.text.toString().trim().isNullOrEmpty()){
                binding.tilEmail.error = "Enter your email"
            }else{
                binding.tilEmail.error = null
                println("In else")
                Toast.makeText(this, "Enter email", Toast.LENGTH_SHORT).show()
            }
        }

    }
}