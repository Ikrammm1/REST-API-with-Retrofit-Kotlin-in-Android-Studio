package com.example.uts_5190411092

data class Model (
    val mahasiswa: List<Data>
    ) {
    data class Data (val NIM:String?, val Nama: String?, val PRODI: String?)
}