package com.smlnskgmail.jaman.androidin_apppurchases.presenter.profile

import com.smlnskgmail.jaman.androidin_apppurchases.model.profile.api.Profile
import com.smlnskgmail.jaman.androidin_apppurchases.model.profile.api.ProfileApi
import com.smlnskgmail.jaman.androidin_apppurchases.view.profile.ProfileView

class ProfilePresenterImpl : ProfilePresenter {

    private lateinit var profileView: ProfileView

    override fun initialize(
        profileView: ProfileView,
        profileApi: ProfileApi
    ) {
        this.profileView = profileView
        profileApi.loadProfile(object : ProfileApi.ProfileLoadTarget {
            override fun profileLoaded(
                profile: Profile?
            ) {
                if (profile != null) {
                    profileView.profileLoaded(
                        profile
                    )
                } else {
                    profileView.showLoadError()
                }
            }
        })

    }

    override fun buyCoffee() {
        profileView.buyCoffee()
    }

    override fun buyBeer() {
        profileView.buyBeer()
    }

    override fun buyHotdog() {
        profileView.buyHotdog()
    }

}