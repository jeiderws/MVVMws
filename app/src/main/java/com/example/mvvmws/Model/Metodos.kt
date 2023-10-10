package com.example.mvvmws.Model

import retrofit2.Call
import retrofit2.http.GET

interface Metodos {
@GET("Sexo")
fun getsexo(): Call<List<Sexo>>
@GET("Usuario")
fun getuser():Call<List<Usuarios>>
}