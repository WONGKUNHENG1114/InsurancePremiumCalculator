package com.example.insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProviders


import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var  viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        val adapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_item, resources.getStringArray(R.array.aging))
        dropDownList.adapter=adapter


       display()
       btnCal.setOnClickListener {
           viewModel.premium=getPremium()
           display()
       }
        btn_reset.setOnClickListener {
            Reset()
        }



    }
    fun display()
    {
        result_ttlPremium.text=viewModel.premium.toString()
    }
    fun getPremium():Double {
        return when (dropDownList.selectedItemPosition) {
            0 -> 60.00
            1 -> 70.00 +
                    (if (radMale.isChecked) 50.00 else 0.00) + (if (checkBox.isChecked) 100.00 else 0.0)
            2 -> 90.00 +
                    (if (radMale.isChecked) 100.00 else 0.00) + (if (checkBox.isChecked) 150.00 else 0.00)
            3 -> 120.00 +
                    (if (radMale.isChecked) 150.00 else 0.00) + (if (checkBox.isChecked) 200.00 else 0.00)
            4 -> 150.00 +
                    (if (radMale.isChecked) 200.00 else 0.00) + (if (checkBox.isChecked) 250.00 else 0.00)
            5 -> 150.00 +
                    (if (radMale.isChecked) 200.00 else 0.00) + (if (checkBox.isChecked) 300.00 else 0.00)
            else -> 0.00
        }
    }

    fun calculation()
    {
        var PremiumPrice:Double
        val extraPaymentMale:Double
        val extraSmoker:Double
        val ttlPrice:Double
        val selectedIndex=dropDownList.selectedItemPosition


    }
    fun Reset()
    {

    }
}
