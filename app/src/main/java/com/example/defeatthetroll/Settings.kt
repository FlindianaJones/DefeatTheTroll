package com.example.defeatthetroll

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class Settings : BaseObservable() {
    val data = App("Troll")

    @Bindable
    fun getSelectedBeast() : String {
        return data.SelectedBeast
    }

    fun setSelectedBeast(value: String) {
        if ( data.SelectedBeast != value) {
            data.SelectedBeast = value

            //saveData()

            notifyPropertyChanged(BR.selectedBeast)
        }
    }
}

class App (var SelectedBeast: String)