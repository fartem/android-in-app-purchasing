package com.smlnskgmail.jaman.androidinapppurchases.view.profile

import com.smlnskgmail.jaman.androidinapppurchases.model.profile.api.Profile

interface ProfileView {

    fun profileLoaded(
        profile: Profile
    )

    fun startLoading()
    fun stopLoading()

    fun showLoadError()

    fun sendEmail(
        email: String
    )
    fun callToPhoneNumber(
        number: String
    )
    fun showAddress(
        address: String
    )

    fun buyCoffee()
    fun buyBeer()
    fun buyHotdog()

}