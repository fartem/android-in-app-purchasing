package com.smlnskgmail.jaman.androidin_apppurchases.model.profile.api

import android.graphics.drawable.Drawable

interface Profile {

    fun name(): String
    fun email(): String
    fun phone(): String
    fun address(): String

    fun image(): Drawable

}