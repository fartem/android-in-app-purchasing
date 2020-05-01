package com.smlnskgmail.jaman.androidinapppurchases.model.profile.impl.randomuser.retrofit.deserializers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.smlnskgmail.jaman.androidinapppurchases.model.profile.impl.randomuser.RandomUserProfile
import com.smlnskgmail.jaman.androidinapppurchases.model.profile.impl.randomuser.retrofit.responses.RandomUserResponse
import java.lang.reflect.Type

class RandomUserResponseDeserializer : JsonDeserializer<RandomUserResponse> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): RandomUserResponse {
        var randomUserProfile: RandomUserProfile? = null
        var imageLink: String? = null
        if (json != null) {
            json as JsonObject
            val data = json.getAsJsonArray("results")[0] as JsonObject

            val dataName = data.get("name") as JsonObject
            val name = "${dataName.get("first").asString} " + dataName.get("last").asString

            val email = data.get("email").asString
            val phone = data.get("phone").asString

            val dataLocation = data.get("location") as JsonObject
            val dataStreet = dataLocation.get("street") as JsonObject

            val address = "${dataLocation.get("country").asString}, " +
                    "${dataLocation.get("city").asString}, " +
                    "${dataStreet.get("name").asString}, " +
                    dataStreet.get("number").asString

            randomUserProfile = RandomUserProfile(
                name,
                email,
                phone,
                address
            )

            imageLink = (data.get("picture") as JsonObject).get("large").asString
        }
        return RandomUserResponse(
            randomUserProfile,
            imageLink
        )
    }

}
