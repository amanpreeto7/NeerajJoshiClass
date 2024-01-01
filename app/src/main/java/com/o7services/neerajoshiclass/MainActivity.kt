package com.o7services.neerajoshiclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.o7services.neerajoshiclass.activityinteraction.FragmentContainerActivity
import com.o7services.neerajoshiclass.jetpackpackage.JetpackNavigationActivity
import com.o7services.neerajoshiclass.bottomnavigation.BottomMainActivity
import com.o7services.neerajoshiclass.listviews.ArrayListActivity

class MainActivity : AppCompatActivity() {
    //Step 1 - declaration of variables
    var btnSave : Button?= null
    var btnView : Button ?= null
    var btnFragmentActivity : Button ?= null
    var tvJetpackNavigation : Button ?= null
    var tvBottomNavigation : Button ?= null
    var tvShowList : Button ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Step 2 - initialization of variables
        btnSave = findViewById(R.id.btnSave)
        btnView = findViewById(R.id.btnHelloWorld)
        btnFragmentActivity = findViewById(R.id.btnFragmentActivity)
        tvJetpackNavigation = findViewById(R.id.tvJetpackNavigation)
        tvBottomNavigation = findViewById(R.id.tvBottomNavigation)
        tvShowList = findViewById(R.id.tvShowList)

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

        tvJetpackNavigation?.setOnClickListener{
            var intent = Intent(this, JetpackNavigationActivity::class.java)
            startActivity(intent)
        }

        tvBottomNavigation?.setOnClickListener{
            var intent = Intent(this, BottomMainActivity::class.java)
            startActivity(intent)
        }

        tvShowList?.setOnClickListener{
            var intent = Intent(this, ArrayListActivity::class.java)
            startActivity(intent)
        }
    }

    //function overriding
    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "On Start method called", Toast.LENGTH_SHORT).show()
    }


}