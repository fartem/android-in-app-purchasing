package com.smlnskgmail.jaman.androidin_apppurchases.view.profile

import com.smlnskgmail.jaman.androidin_apppurchases.model.profile.api.Profile

interface ProfileView {

    fun profileLoaded(
        profile: Profile
    )

    fun startLoading()
    fun stopLoading()

    fun showLoadError()

    fun buyCoffee()
    fun buyBeer()
    fun buyHotdog()

}