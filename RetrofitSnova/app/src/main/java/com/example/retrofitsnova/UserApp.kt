package com.example.retrofitsnova


import android.app.Application
import com.example.retrofitsnova.data.remote.user.UserApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class UserApp:Application() {
    lateinit var userApi:UserApi

    override fun onCreate() {
        super.onCreate()
        configureRetrofit()

    }


    private fun configureRetrofit(){
        val httpLoginInterceptor = HttpLoggingInterceptor()
        httpLoginInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoginInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        userApi = retrofit.create(UserApi::class.java)
    }
}