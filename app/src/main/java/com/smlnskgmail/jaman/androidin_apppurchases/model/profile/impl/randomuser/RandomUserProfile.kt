package com.smlnskgmail.jaman.androidin_apppurchases.model.profile.impl.randomuser

import android.graphics.drawable.Drawable
import com.smlnskgmail.jaman.androidin_apppurchases.model.profile.api.Profile

class RandomUserProfile(
    private val name: String,
    private val email: String,
    private val phone: String,
    private val address: String,
    private val image: Drawable
) : Profile {

    override fun name(): String {
        return name
    }

    override fun email(): String {
        return email
    }

    override fun phone(): String {
        return phone
    }

    override fun address(): String {
        return address
    }

    override fun image(): Drawable {
        return image
    }

}