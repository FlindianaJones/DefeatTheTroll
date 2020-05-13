package com.example.defeatthetroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        ArrayAdapter.createFromResource(
            this,
            R.array.beast_types,
            R.layout.support_simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            beast_type_spn.adapter = adapter
        }

        beast_type_spn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.d("troll_beast", parent?.getItemAtPosition(position) as String)
                MainActivity.AppSettings.setSelectedBeast(parent?.getItemAtPosition(position) as String)
            }

        }

        return_btn.setOnClickListener {
            finish()
        }
    }
}
