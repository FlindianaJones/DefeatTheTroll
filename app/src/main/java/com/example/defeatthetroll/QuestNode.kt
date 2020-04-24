package com.example.defeatthetroll

import android.os.Parcel
import android.os.Parcelable


class QuestNode(val Id: Int, val Prompt:String, val Choices:HashMap<String, Choice>): Parcelable {
    /* everything below here is for implementing Parcelable */

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<QuestNode> {
            override fun createFromParcel(parcel: Parcel) = QuestNode(parcel)
            override fun newArray(size: Int) = arrayOfNulls<QuestNode>(size)
        }
    }

    private constructor(parcel: Parcel) : this(
        Id = parcel.readInt(),
        Prompt = parcel.readString() ?: "",
        Choices = hashMapOf()
//        Choices = (parcel.readHashMap(Choice::class.java.classLoader) ?: hashMapOf<String, Choice>()) as HashMap<String, Choice>
    ) {
        val choiceCount = parcel.readInt()
        for(i in 0..choiceCount){
            val choiceKey = parcel.readString() ?: ""
            if (choiceKey == "")
                continue//don't anticipate this happening, but if it does...
            val currentChoice = parcel.readParcelable<Choice>(Choice::class.java.classLoader) as Choice
            Choices[choiceKey] = currentChoice
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(Id)
        parcel.writeString(Prompt)
        parcel.writeInt(Choices.size)
        for(currentKey in Choices.keys){
            parcel.writeString(currentKey)
            parcel.writeParcelable(Choices[currentKey], 0)
        }
    }

    //This can be ignored 99.9% of the time
    override fun describeContents() = 0
}

class Choice(val Label: String, val Keyword: String, val Result: String, val Next: Int): Parcelable {
    /* everything below here is for implementing Parcelable */

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<Choice> {
            override fun createFromParcel(parcel: Parcel) = Choice(parcel)
            override fun newArray(size: Int) = arrayOfNulls<Choice>(size)
        }
    }

    private constructor(parcel: Parcel) : this(
        Label = parcel.readString() ?: "",
        Keyword = parcel.readString() ?: "",
        Result = parcel.readString() ?: "",
        Next = parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Label)
        parcel.writeString(Keyword)
        parcel.writeString(Result)
        parcel.writeInt(Next)
    }

    //This can be ignored 99.9% of the time
    override fun describeContents() = 0
}