package com.example.kotlinaccount.database

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "item_record")
data class ItemRecord(
    @PrimaryKey(autoGenerate = true) var id: Int?,
    var typeId: Int?,
    var amount: Double?,
    var typeName: String?,
    var createTime: Long,
    var isDel:Int? = 0
) : Parcelable {


    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readLong()
    ) {
    }

    constructor() : this(null, null, null, null,System.currentTimeMillis())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeValue(typeId)
        parcel.writeValue(amount)
        parcel.writeString(typeName)
        parcel.writeLong(createTime)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemRecord> {
        override fun createFromParcel(parcel: Parcel): ItemRecord {
            return ItemRecord(parcel)
        }

        override fun newArray(size: Int): Array<ItemRecord?> {
            return arrayOfNulls(size)
        }
    }


}