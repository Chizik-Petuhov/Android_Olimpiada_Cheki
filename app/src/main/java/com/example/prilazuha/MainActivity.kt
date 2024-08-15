package com.example.prilazuha

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prilazuha.Adapters.FoodUnRedactableAdapter
import com.example.prilazuha.databinding.ActivityMainBinding
import com.example.prilazuha.databinding.PrintFoodBinding
import com.example.prilazuha.model.FoodItem
import com.example.prilazuha.model.FoodList


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val data = FoodList()
    private lateinit var unredadapter: FoodUnRedactableAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupList()
        binding.addButton.setOnClickListener {onAddPressed()}
        binding.editbutton.setOnClickListener {onEditPressed()}
    }

    private fun setupList() {
        unredadapter = FoodUnRedactableAdapter(data)
        binding.FoodListView.adapter = unredadapter
    }

    private fun onAddPressed() {
        val dialogBinding: PrintFoodBinding = PrintFoodBinding.inflate(layoutInflater)
        val dialog:AlertDialog = AlertDialog.Builder(this)
            .setTitle("Create")
            .setView(dialogBinding.root)
            .setPositiveButton("Add") { d, which ->
                val name = dialogBinding.editTextTextFoodName.text.toString()
                val num = dialogBinding.editTextTextFoodNum.text.toString()
                if (name.isNotBlank()) {
                    if (num.isNotBlank()) createFood(name,num)
                    else createFood(name)
                }
            }.create()
        dialog.show()
    }

    private fun onEditPressed() {

    }

    private fun createFood(name: String) {
        data.add(name)
        unredadapter.notifyDataSetChanged()
    }

    private fun createFood(name: String, num: String) {
        data.add(name, num)
        unredadapter.notifyDataSetChanged()
    }

    private fun decripPosition(name: String) {
        data.decFood(name)
    }

    private fun setupReadableList(){




    }

    companion object{
        @JvmStatic val KEY_TITLE = "title"
        @JvmStatic val KEY_NUMBER = "number"
    }
}