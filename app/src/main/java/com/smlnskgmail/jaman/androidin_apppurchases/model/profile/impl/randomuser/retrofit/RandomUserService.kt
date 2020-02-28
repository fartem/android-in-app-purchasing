package com.smlnskgmail.jaman.androidin_apppurchases.model.profile.impl.randomuser.retrofit

import com.smlnskgmail.jaman.androidin_apppurchases.model.profile.impl.randomuser.retrofit.responses.RandomUserResponse
import retrofit2.Call
import retrofit2.http.GET

interface RandomUserService {

    @GET(
        "api"
    )
    fun randomProfile(): Call<RandomUserResponse>

}