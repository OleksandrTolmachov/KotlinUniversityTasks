package com.example.finalproject.viewmodels

import android.os.Parcel
import android.os.Parcelable

@Suppress("DEPRECATION")
data class MessageViewModel (val message: String, val role: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(message)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MessageViewModel> {
        override fun createFromParcel(parcel: Parcel): MessageViewModel {
            return MessageViewModel(parcel)
        }

        override fun newArray(size: Int): Array<MessageViewModel?> {
            return arrayOfNulls(size)
        }
    }
}