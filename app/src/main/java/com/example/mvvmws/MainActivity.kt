package com.example.mvvmws

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.mvvmws.Model.Api
import com.example.mvvmws.Model.Sexo
import com.example.mvvmws.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            mostrarsex()
        }
        binding.mosrarid.setOnClickListener {
            mostrarsexid()
        }
        binding.btn3.setOnClickListener {
            eliminarsex()
        }
        binding.insertbtn.setOnClickListener {
            insertsex()
        }
        binding.btnactu.setOnClickListener {
            Actualizsex()
        }

    }

    fun mostrarsex() {
        Api.servicio.getsexo().enqueue(object : Callback<List<Sexo>> {
            override fun onResponse(call: Call<List<Sexo>>, response: Response<List<Sexo>>) {
                var jj = response.body()
                jj?.forEach {
                    binding.txtnam.append("${it.Nombre}\n")
                }
            }

            override fun onFailure(call: Call<List<Sexo>>, t: Throwable) {
                t.message?.let { Log.e("jaja", it) }
            }

        })
    }

    fun mostrarsexid() {
        binding.txtnam.setText("")
        var Id = binding.txtid.text.toString()
        Api.servicio.getsexo(Id).enqueue(object : Callback<List<Sexo>> {
            override fun onResponse(call: Call<List<Sexo>>, response: Response<List<Sexo>>) {
                var resp = response.body()
                resp?.forEach {
                    binding.txtnam.setText(it.Nombre)
                }
            }

            override fun onFailure(call: Call<List<Sexo>>, t: Throwable) {
                t.message?.let { Log.e("jajax2", it) }
            }

        })
    }

    fun insertsex() {
        var Sexnew = Sexo(5, "otros")
        Api.servicio.insertsex(Sexnew).enqueue(object : Callback<Sexo> {
            override fun onResponse(call: Call<Sexo>, response: Response<Sexo>) {
                Toast.makeText(
                    this@MainActivity,
                    "sexo ingresado correctamente",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onFailure(call: Call<Sexo>, t: Throwable) {
                t.message?.let { Log.e("error", it) }
            }

        })
    }

    fun eliminarsex() {
        binding.txtnam.setText("")
        var Id = binding.txtid.text .toString()
        Api.servicio.delsex(Id).enqueue(object : Callback<Sexo> {
            override fun onResponse(call: Call<Sexo>, response: Response<Sexo>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@MainActivity, "eliminado", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, response.code().toString(),Toast.LENGTH_SHORT ).show()
                    Log.e("error", response.message())
                }
            }
            override fun onFailure(call: Call<Sexo>, t: Throwable) {
                t.message?.let { Log.e("error", it) }
            }

        })
    }

    fun Actualizsex() {
        binding.txtnam.setText("")
        if (binding.txtid.text.toString().isNotEmpty()) {
            var id = binding.txtid.text.toString()
            var actsex = Sexo(id.toLong(),"jjjj")

            Api.servicio.actusex(id,actsex).enqueue(object :Callback<Sexo>{
                override fun onResponse(call: Call<Sexo>, response: Response<Sexo>) {
                    Toast.makeText(this@MainActivity, "c actualizo", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<Sexo>, t: Throwable) {
                    t.message?.let { Log.e("kk", it) }
                }

            })

        }
    }

}