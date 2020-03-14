package com.smlnskgmail.jaman.androidinapppurchases.model.profile.impl.randomuser

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import com.google.gson.GsonBuilder
import com.smlnskgmail.jaman.androidinapppurchases.model.profile.api.ProfileApi
import com.smlnskgmail.jaman.androidinapppurchases.model.profile.impl.randomuser.retrofit.RandomUserService
import com.smlnskgmail.jaman.androidinapppurchases.model.profile.impl.randomuser.retrofit.deserializers.RandomUserResponseDeserializer
import com.smlnskgmail.jaman.androidinapppurchases.model.profile.impl.randomuser.retrofit.responses.RandomUserResponse
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RandomUserProfileApi : ProfileApi {

    private var retrofit: Retrofit
    private var randomUserService: RandomUserService

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
                val randomUserResponse = response.body()
                if (randomUserResponse != null) {
                    val profile = randomUserResponse.randomUserProfile
                    Picasso.get()
                        .load(randomUserResponse.imageLink)
                        .into(object : Target {
                            override fun onPrepareLoad(
                                placeHolderDrawable: Drawable?
                            ) {

                            }

                            override fun onBitmapFailed(
                                e: Exception?,
                                errorDrawable: Drawable?
                            ) {
                                profile!!.setImage(
                                    null
                                )
                                profileLoadTarget.profileLoaded(
                                    profile
                                )
                            }

                            override fun onBitmapLoaded(
                                bitmap: Bitmap?,
                                from: Picasso.LoadedFrom?
                            ) {
                                profile!!.setImage(
                                    BitmapDrawable(bitmap!!)
                                )
                                profileLoadTarget.profileLoaded(
                                    profile
                                )
                            }
                        })
                } else {
                    resultForError()
                }
            }
        })
    }

}
