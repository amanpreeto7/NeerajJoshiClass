package com.o7services.neerajoshiclass

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

import android.widget.LinearLayout.LayoutParams
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MessagesActivity : AppCompatActivity() {
    var btnShowToast : Button?= null
    var btnShowSnackbar : Button?= null
    var btnAlertDialog : Button ?= null
    var btnDialog: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)

        btnShowToast = findViewById(R.id.btnShowToast)
        btnShowSnackbar = findViewById(R.id.btnShowSnackbar)
        btnAlertDialog = findViewById(R.id.btnAlertDialog)
        btnDialog=findViewById(R.id.btnDialog)


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

        // custom Dialog
        btnDialog?.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.custom_dialog)
            dialog.show()
            dialog.window?.setLayout(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT)
            var name = dialog.findViewById<EditText>(R.id.etName)
            var rollNo = dialog.findViewById<EditText>(R.id.etRollNo)
            var submit = dialog.findViewById<Button>(R.id.btnSubmit)

            submit.setOnClickListener {
                if(name.text.toString().isEmpty()){
                    name.error="Enter your name"
                }else if(rollNo.text.toString().isEmpty()){
                    rollNo.error="Enter your rollno."
                }else{
                    Toast.makeText(this,"Submit",Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }
        }

    }
}