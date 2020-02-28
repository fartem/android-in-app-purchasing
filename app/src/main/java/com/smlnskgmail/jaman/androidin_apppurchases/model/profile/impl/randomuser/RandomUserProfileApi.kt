package com.smlnskgmail.jaman.androidin_apppurchases.model.profile.impl.randomuser

import com.google.gson.GsonBuilder
import com.smlnskgmail.jaman.androidin_apppurchases.model.profile.api.ProfileApi
import com.smlnskgmail.jaman.androidin_apppurchases.model.profile.impl.randomuser.retrofit.RandomUserService
import com.smlnskgmail.jaman.androidin_apppurchases.model.profile.impl.randomuser.retrofit.deserializers.RandomUserResponseDeserializer
import com.smlnskgmail.jaman.androidin_apppurchases.model.profile.impl.randomuser.retrofit.responses.RandomUserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RandomUserProfileApi : ProfileApi {

    private lateinit var retrofit: Retrofit
    private lateinit var randomUserService: RandomUserService

    private val gson = GsonBuilder()
        .registerTypeAdapter(
            RandomUserResponse::class.java,
            RandomUserResponseDeserializer()
        )
        .setLenient()
        .create()

    init {
        retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(
                GsonConverterFactory.create(
                    gson
                )
            )
            .build()
        randomUserService = retrofit.create(
            RandomUserService::class.java
        )
    }

    override fun loadProfile(
        profileLoadTarget: ProfileApi.ProfileLoadTarget
    ) {
        randomUserService.randomProfile().enqueue(object : Callback<RandomUserResponse> {
            override fun onFailure(
                call: Call<RandomUserResponse>,
                t: Throwable
            ) {
                resultForError()
            }

            private fun resultForError() {
                profileLoadTarget.profileLoaded(null)
            }

            override fun onResponse(
                call: Call<RandomUserResponse>,
                response: Response<RandomUserResponse>
            ) {
                if (response.body() != null) {
                    profileLoadTarget.profileLoaded(
                        response.body()!!.randomUserProfile
                    )
                } else {
                    resultForError()
                }
            }
        })
    }

}