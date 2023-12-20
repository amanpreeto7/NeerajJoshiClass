package com.o7services.neerajoshiclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //Step 1 - declaration of variables
    var btnSave : Button?= null
    var btnView : Button ?= null
    var btnFragmentActivity : Button ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Step 2 - initialization of variables
        btnSave = findViewById(R.id.btnSave)
        btnView = findViewById(R.id.btnHelloWorld)
        btnFragmentActivity = findViewById(R.id.btnFragmentActivity)

        //!! definite - double bang, bang bang
        //crash chances
        btnSave!!.setOnClickListener{
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        //? - this can be null, execute the next if it is not null
        btnView?.setOnClickListener{
            var intent = Intent(this, MessagesActivity::class.java)
            startActivity(intent)
        }

        btnFragmentActivity?.setOnClickListener{
            var intent = Intent(this, FragmentContainerActivity::class.java)
            startActivity(intent)
        }
    }

    //function overriding
    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "On Start method called", Toast.LENGTH_SHORT).show()
    }


}