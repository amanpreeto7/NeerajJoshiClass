package com.o7services.neerajoshiclass.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.o7services.neerajoshiclass.R
import com.o7services.neerajoshiclass.databinding.ActivityBottomMainBinding

class BottomMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityBottomMainBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.fragment)

        navController.addOnDestinationChangedListener{ controller, destination, argument->
            when(destination.id){
              R.id.bottomFirstFragment -> binding.bottomNav.menu[0].isChecked = true
              R.id.bottomSecondFragment -> binding.bottomNav.menu[1].isChecked = true
            }
        }
        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.bottomFirst-> {
                    navController.navigate(R.id.bottomFirstFragment)
                }
                R.id.bottomSecond->{
                    navController.navigate(R.id.bottomSecondFragment)
                }
            }
            return@setOnItemSelectedListener true
        }

    }
}