package com.smlnskgmail.jaman.androidinapppurchases.model.profile.impl.randomuser

import android.graphics.drawable.Drawable
import com.smlnskgmail.jaman.androidinapppurchases.model.profile.api.Profile

class RandomUserProfile(
    private val name: String,
    private val email: String,
    private val phone: String,
    private val address: String
) : Profile {

    private var image: Drawable? = null

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

    fun setImage(
        image: Drawable?
    ) {
        this.image = image
    }

    override fun image(): Drawable? {
        return image
    }

}