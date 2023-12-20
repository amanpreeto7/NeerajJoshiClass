package com.o7services.neerajoshiclass.activityinteraction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import com.o7services.neerajoshiclass.R

class FragmentContainerActivity : AppCompatActivity() {
    lateinit var clMain: LinearLayout
    lateinit var activityInterface: ActivityInterface
    lateinit var btnFragmentFunction :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_container)
        clMain = findViewById(R.id.clMain)
        btnFragmentFunction = findViewById(R.id.btnFragmentFunction)

        btnFragmentFunction.setOnClickListener {
            activityInterface.fragmentFunction(1,1f,1.0)
        }
    }

    fun showToast(){
        clMain.setBackgroundColor(resources.getColor(R.color.red))
            Toast.makeText(this, "Showing toast from fragment", Toast.LENGTH_SHORT).show()
    }
}