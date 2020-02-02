package com.example.testapplication.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Data(
        var text:String
) {
    @PrimaryKey(autoGenerate = true) var key:Int = 0
}