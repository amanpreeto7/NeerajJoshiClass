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
            arrayList.removeAt(position)
            adapter.notifyDataSetChanged()
        }

        binding.lv.setOnItemLongClickListener { adapterView, view, position, l ->
            //position
//            arrayList.set(position, "qwerty")
            if(binding.etAddItem.text.toString().isEmpty()){
                binding.etAddItem.error = "Enter item to update"
            }else {
                arrayList.set(position, binding.etAddItem.text.toString())
                binding.etAddItem.text.clear()
                adapter.notifyDataSetChanged()
            }
            return@setOnItemLongClickListener true
        }

        binding.btnAdd.setOnClickListener{
            if(binding.etAddItem.text.toString().isEmpty()){
                binding.etAddItem.error = "Enter item to add"
            }else{
                arrayList.add(binding.etAddItem.text.toString())
                binding.etAddItem.text.clear()
                adapter.notifyDataSetChanged()
            }
        }
    }
}