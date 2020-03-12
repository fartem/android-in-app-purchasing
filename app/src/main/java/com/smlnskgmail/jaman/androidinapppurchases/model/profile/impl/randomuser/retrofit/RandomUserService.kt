package com.smlnskgmail.jaman.androidinapppurchases.model.profile.impl.randomuser.retrofit

import com.smlnskgmail.jaman.androidinapppurchases.model.profile.impl.randomuser.retrofit.responses.RandomUserResponse
import retrofit2.Call
import retrofit2.http.GET

interface RandomUserService {

    @GET(
        "api"
    )
    fun randomProfile(): Call<RandomUserResponse>

}