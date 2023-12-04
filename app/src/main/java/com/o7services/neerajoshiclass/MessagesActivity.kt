package com.o7services.neerajoshiclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MessagesActivity : AppCompatActivity() {
    var btnShowToast : Button?= null
    var btnShowSnackbar : Button?= null
    var btnAlertDialog : Button ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)

        btnShowToast = findViewById(R.id.btnShowToast)
        btnShowSnackbar = findViewById(R.id.btnShowSnackbar)
        btnAlertDialog = findViewById(R.id.btnAlertDialog)

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

        btnAlertDialog?.setOnClickListener{
            //Alert dialog class in-build
            //Features, attributes
            //Title, message
            //List, single choice, mutli choice
            //List we cannot show message
            //3 buttons - Positive, negative, neutral
            //activity context this
            var alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("This is title")
            alertDialog.setMessage("This is message")
            alertDialog.setCancelable(false)
            alertDialog.setPositiveButton("Positive", {alertDialog,buttonPressed->
                Toast.makeText(this, "Positve button clicked", Toast.LENGTH_SHORT).show()
            })
            alertDialog.setNegativeButton("Negative", {_,_->
                Toast.makeText(this, "Negative button clicked", Toast.LENGTH_SHORT).show()
            })
            alertDialog.setNeutralButton("Neutral", {_,_->
                Toast.makeText(this, "Neutral button clicked", Toast.LENGTH_SHORT).show()
            })
            alertDialog.show()
        }

    }
}