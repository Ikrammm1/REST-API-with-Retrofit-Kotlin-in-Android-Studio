package com.example.uts_5190411092

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val api by lazy { APIretrofit().endpoint }
    private lateinit var Adapter: Adapter
    private lateinit var listitem: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupList()


    }

    override fun onStart() {
        super.onStart()
        getdata()
    }

    private fun setupList(){
        listitem = findViewById(R.id.list_item)
        Adapter = Adapter(arrayListOf())
        listitem.adapter = Adapter
    }

    private fun getdata(){
        api.data().enqueue(object : Callback<Model> {
            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                if (response.isSuccessful) {
                    val listdata = response.body()!! .mahasiswa
                    Adapter.setData(listdata)

//                    listdata.forEach{
//                        Log.e("MainActivity","NIM ${it.NIM}")
//                        Log.e("MainActivity","Nama ${it.Nama}")
//                        Log.e("MainActivity","PRODI ${it.PRODI}")
//                    }

                    Log.e("MainActivity", response.toString())
                }
            }

            override fun onFailure(call: Call<Model>, t: Throwable) {
                Log.e("MainActivity", t.toString())
            }

        })
    }
}