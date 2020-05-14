package com.example.defeatthetroll

import android.content.Context
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
                val selection = parent?.getItemAtPosition(position) as String
                MainActivity.AppSettings.setSelectedBeast(selection)
                val sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)

                with (sharedPref.edit()) {
                    putString(getString(R.string.saved_beast_key), selection)
                    commit()
                }
            }

        }

        return_btn.setOnClickListener {
            finish()
        }
    }
}
