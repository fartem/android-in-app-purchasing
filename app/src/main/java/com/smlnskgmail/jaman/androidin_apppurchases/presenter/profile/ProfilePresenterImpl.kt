package com.smlnskgmail.jaman.androidin_apppurchases.presenter.profile

import com.smlnskgmail.jaman.androidin_apppurchases.model.profile.api.Profile
import com.smlnskgmail.jaman.androidin_apppurchases.model.profile.api.ProfileApi
import com.smlnskgmail.jaman.androidin_apppurchases.view.profile.ProfileView

class ProfilePresenterImpl : ProfilePresenter {

    private lateinit var profileView: ProfileView
    private lateinit var profileApi: ProfileApi

    override fun initialize(
        profileView: ProfileView,
        profileApi: ProfileApi
    ) {
        this.profileView = profileView
        this.profileApi = profileApi

        refresh()
    }

    override fun refresh() {
        this.profileView.startLoading()
        profileApi.loadProfile(object : ProfileApi.ProfileLoadTarget {
            override fun profileLoaded(
                profile: Profile?
            ) {
                if (profile != null) {
                    profileView.stopLoading()
                    profileView.profileLoaded(
                        profile
                    )
                } else {
                    profileView.stopLoading()
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