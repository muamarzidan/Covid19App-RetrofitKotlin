package com.example.retrofit_muamarzidantriantoro_21.api

import com.example.retrofit_muamarzidantriantoro_21.Model.IndonesiaResponse
import com.example.retrofit_muamarzidantriantoro_21.Model.ProvinceResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET ("casenumber.json")
    fun getIndonesia(): Call<ArrayList<IndonesiaResponse>>

    @GET ("casenumberprovince.json")
    fun getProvince(): Call<ArrayList<ProvinceResponse>>
}

