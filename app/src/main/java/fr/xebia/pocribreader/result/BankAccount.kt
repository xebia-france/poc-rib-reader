package fr.xebia.pocribreader.result

import android.os.Parcel
import android.os.Parcelable

data class BankAccount(var iban: String, var bic: String, var address: String, var name: String) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(iban)
        parcel.writeString(bic)
        parcel.writeString(address)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BankAccount> {
        override fun createFromParcel(parcel: Parcel): BankAccount {
            return BankAccount(parcel)
        }

        override fun newArray(size: Int): Array<BankAccount?> {
            return arrayOfNulls(size)
        }
    }

}