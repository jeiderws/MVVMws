package com.example.mvvmws.Model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface Metodos {
    //Metodos de la tabla Sexo
    @GET("Sexo")
    fun getsexo(): Call<List<Sexo>>
    @GET("Sexo/{id}")
    fun getsexo(@Path("id") Id : String): Call<List<Sexo>>
    @DELETE("Sexo/{id}")
    fun delsex(@Path("id") Id : String): Call<Sexo>
    @POST("Sexo")
    fun insertsex(@Body insert : Sexo):Call<Sexo>
    @PUT("Sexo/{id}")
    fun actusex(@Path("id") Id: String, @Body Actuali : Sexo): Call<Sexo>
// Metodos de Usuario
    @GET("Usuario")
    fun getuser():Call<List<Usuarios>>
}
