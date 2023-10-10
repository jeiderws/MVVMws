package com.example.mvvmws.Vistas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mvvmws.Model.Api
import com.example.mvvmws.Model.Sexo
import com.example.mvvmws.R
import com.example.mvvmws.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            Sexo()
        }
    }
    fun Sexo(){
        Api.servicio.getsexo().enqueue(object : Callback<List<Sexo>>{
            override fun onResponse(call: Call<List<Sexo>>, response: Response<List<Sexo>>)
            {
                var jj = response.body()
                jj?.forEach {
                    binding.txtnam.append("${it.Nombre}\n")
                }
            }
            override fun onFailure(call: Call<List<Sexo>>, t: Throwable)
            {
                t.message?.let { Log.e("jaja", it) }
            }

        })
    }

}