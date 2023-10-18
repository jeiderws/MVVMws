package com.example.mvvmws.Model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {
var retrofit = Retrofit.Builder()
    .baseUrl("http://192.168.43.17:6060/api/")
    .addConverterFactory(GsonConverterFactory.create()).build()
    var servicio = retrofit.create(Metodos::class.java)
}