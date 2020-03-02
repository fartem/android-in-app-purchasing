package com.smlnskgmail.jaman.androidin_apppurchases.presenter.profile

import com.smlnskgmail.jaman.androidin_apppurchases.model.profile.api.ProfileApi
import com.smlnskgmail.jaman.androidin_apppurchases.view.profile.ProfileView

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