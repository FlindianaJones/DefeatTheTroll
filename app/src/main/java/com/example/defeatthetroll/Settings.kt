package com.example.defeatthetroll

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.defeatthetroll.data.QuestNode

class Settings : BaseObservable() {
    val data = App("Troll", arrayOf())

    @Bindable
    fun getSelectedBeast() : String {
        return data.SelectedBeast
    }

    fun setSelectedBeast(value: String) {
        if ( data.SelectedBeast != value) {
            data.SelectedBeast = value

            notifyPropertyChanged(BR.selectedBeast)
        }
    }
}

class App (var SelectedBeast: String, var QuestNodes: Array<QuestNode>)