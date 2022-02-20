package com.example.retrofit_muamarzidantriantoro_21.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_muamarzidantriantoro_21.Model.ProvinceResponse
import com.example.retrofit_muamarzidantriantoro_21.R
import com.example.retrofit_muamarzidantriantoro_21.adapter.ProvinceAdapter
import com.example.retrofit_muamarzidantriantoro_21.api.RetrovitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProvinceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_province)
        showProvince()
    }

    private fun showProvince() {
        val rvProvince : RecyclerView = findViewById(R.id.rvProvince)

        rvProvince.setHasFixedSize(true)
        rvProvince.layoutManager = LinearLayoutManager(this)

        RetrovitClient.instance.getProvince().enqueue(object :
            Callback<ArrayList<ProvinceResponse>> {
            override fun onResponse(
                call: Call<ArrayList<ProvinceResponse>>,
                response: Response<ArrayList<ProvinceResponse>>
            ) {
                val list = response.body()
                val adapter = list?.let { ProvinceAdapter(it) }
                rvProvince.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<ProvinceResponse>>, t: Throwable) {
                Toast.makeText(this@ProvinceActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })

    }
}