package com.example.testapplication.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Data(
        var number:Int,
        var text:String
) {
    @PrimaryKey(autoGenerate = true) var key:Int = 0

    override fun equals(other: Any?): Boolean {
        val o:Data = other as Data
        return key == o.key && number == o.number && text == o.text
    }
}