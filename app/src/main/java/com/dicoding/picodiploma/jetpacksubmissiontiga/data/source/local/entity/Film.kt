package com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


//data class Film(
//    var filmImage: String,
//    var filmName: String,
//    var filmDescription: String,
//    var filmType: String
//)

@Entity(tableName = "filmentities")
data class Film(
    @ColumnInfo(name = "filmImage")
    var filmImage: String,

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "filmName")
    var filmName: String,

    @ColumnInfo(name = "filmDescription")
    var filmDescription: String,

    @ColumnInfo(name = "filmType")
    var filmType: String,

    @ColumnInfo(name = "favorite")
    var favorited: Boolean = false
)