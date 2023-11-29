package com.o7services.neerajoshiclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MessagesActivity : AppCompatActivity() {
    var btnShowToast : Button?= null
    var btnShowSnackbar : Button?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)

        btnShowToast = findViewById(R.id.btnShowToast)
        btnShowSnackbar = findViewById(R.id.btnShowSnackbar)
        btnShowToast?.setOnClickListener{
            Toast.makeText(this, "This is text message", Toast.LENGTH_SHORT).show()
        }

        btnShowSnackbar?.setOnClickListener{
            Snackbar.make(it, "Hello There!", Snackbar.LENGTH_LONG)
                .setAction("Ok"){
                    btnShowSnackbar?.setText("Updated After ok button Click")
                }
                .show()
        }

    }
}