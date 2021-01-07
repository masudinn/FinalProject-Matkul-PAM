package com.masudinn.fp_pam_2087.Server

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Client {
    companion object {
        private var baseurl = "https://www.thesportsdb.com"
        var key = 1
        fun getClient(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(baseurl +"api/v1/json/${key}")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
    }
}