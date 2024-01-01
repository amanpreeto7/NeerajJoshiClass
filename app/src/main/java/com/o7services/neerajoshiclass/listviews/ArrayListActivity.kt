package com.o7services.neerajoshiclass.listviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.android.material.snackbar.Snackbar
import com.o7services.neerajoshiclass.R
import com.o7services.neerajoshiclass.databinding.ActivityArrayListBinding

class ArrayListActivity : AppCompatActivity() {
    //arraylist declare and initialize
    var arrayList = arrayListOf<String>("A", "B","C", "D")
    lateinit var adapter : ArrayAdapter<String>
    lateinit var binding: ActivityArrayListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArrayListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)
        binding.lv.adapter = adapter

        binding.lv.setOnItemClickListener { adapterView, view, position, l ->
            Snackbar.make(binding.lv, "Clicked item ${arrayList[position]}", Snackbar.LENGTH_LONG).show()
        }
    }
}