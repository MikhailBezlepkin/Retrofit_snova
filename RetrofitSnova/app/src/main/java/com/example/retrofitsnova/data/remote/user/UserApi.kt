package com.example.retrofitsnova.data.remote.user

import com.example.retrofitsnova.model.UserListResponse
import io.reactivex.Single
import retrofit2.http.GET

interface UserApi {
    @GET("api/users/2")
    fun getUserList():Single<UserListResponse>
}