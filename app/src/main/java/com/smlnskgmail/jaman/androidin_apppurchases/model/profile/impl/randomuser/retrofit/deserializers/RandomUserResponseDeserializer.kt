package com.smlnskgmail.jaman.androidin_apppurchases.model.profile.impl.randomuser.retrofit.deserializers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.smlnskgmail.jaman.androidin_apppurchases.model.profile.impl.randomuser.RandomUserProfile
import com.smlnskgmail.jaman.androidin_apppurchases.model.profile.impl.randomuser.retrofit.responses.RandomUserResponse
import java.lang.reflect.Type

class RandomUserResponseDeserializer : JsonDeserializer<RandomUserResponse> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): RandomUserResponse {
        var randomUserProfile: RandomUserProfile? = null
        val data = json!!.asJsonArray
        if (data != null) {

        }
        return RandomUserResponse(
            randomUserProfile
        )
    }

}