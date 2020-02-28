package com.smlnskgmail.jaman.androidin_apppurchases.model.profile.impl.debug

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.smlnskgmail.jaman.androidin_apppurchases.R
import com.smlnskgmail.jaman.androidin_apppurchases.model.profile.api.Profile
import com.smlnskgmail.jaman.androidin_apppurchases.model.profile.api.ProfileApi

class DebugUserApi(
    private val context: Context
) : ProfileApi {

    override fun loadProfile(
        profileLoadTarget: ProfileApi.ProfileLoadTarget
    ) {
        profileLoadTarget.profileLoaded(object : Profile {
            override fun name(): String {
                return "John Doe"
            }

            override fun email(): String {
                return "john_doe@doe.com"
            }

            override fun phone(): String {
                return "8-192-324-23-33"
            }

            override fun address(): String {
                return "Unknown"
            }

            override fun image(): Drawable {
                return ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_person
                )!!
            }
        })
    }

}