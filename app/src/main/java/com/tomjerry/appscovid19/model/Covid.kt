package com.tomjerry.appscovid19.model

import androidx.room.Entity
import androidx.room.PrimaryKey

    @Entity
    data class Indonesia(var status: String , var total: String , @PrimaryKey var id: String)
    @Entity
    data class Makassar(var status: String , var total: String , @PrimaryKey var id: String)
    @Entity
    data class Kasus(var bulan: String , var jumlah: String , @PrimaryKey var id: String)
    @Entity
    data class Sembuh(var bulan: String , var jumlah: String , @PrimaryKey var id: String)
    @Entity
    data class Meninggal(var bulan: String , var jumlah: String , @PrimaryKey var id: String)

