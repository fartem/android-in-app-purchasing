package com.smlnskgmail.jaman.androidinapppurchases.presenter.profile

import com.smlnskgmail.jaman.androidinapppurchases.model.profile.api.ProfileApi
import com.smlnskgmail.jaman.androidinapppurchases.view.profile.ProfileView

interface ProfilePresenter {

    fun initialize(
        profileView: ProfileView,
        profileApi: ProfileApi
    )

    fun refresh()

    fun emailContactSelect()
    fun phoneContactSelect()
    fun addressContactSelect()

    fun buyCoffee()
    fun buyBeer()
    fun buyHotdog()

}