package com.smlnskgmail.jaman.androidinapppurchases.presenter.profile

import com.smlnskgmail.jaman.androidinapppurchases.BuildConfig
import com.smlnskgmail.jaman.androidinapppurchases.iab.IabGateway
import com.smlnskgmail.jaman.androidinapppurchases.model.profile.api.Profile
import com.smlnskgmail.jaman.androidinapppurchases.model.profile.api.ProfileApi
import com.smlnskgmail.jaman.androidinapppurchases.view.profile.ProfileView

class ProfilePresenterImpl : ProfilePresenter {

    private lateinit var profileView: ProfileView
    private lateinit var profileApi: ProfileApi
    private lateinit var iabGateway: IabGateway

    private lateinit var profile: Profile

    override fun initialize(
        profileView: ProfileView,
        profileApi: ProfileApi,
        iabGateway: IabGateway
    ) {
        this.profileView = profileView
        this.profileApi = profileApi
        this.iabGateway = iabGateway

        refresh()
    }

    override fun refresh() {
        this.profileView.startLoading()
        profileApi.loadProfile(object : ProfileApi.ProfileLoadTarget {
            override fun profileLoaded(
                profile: Profile?
            ) {
                if (profile != null) {
                    this@ProfilePresenterImpl.profile = profile
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

    override fun emailContactSelect() {
        profileView.sendEmail(
            profile.email()
        )
    }

    override fun phoneContactSelect() {
        profileView.callToPhoneNumber(
            profile.phone()
        )
    }

    override fun addressContactSelect() {
        profileView.showAddress(
            profile.address()
        )
    }

    override fun buyCoffee() {
        iabGateway.purchase(
            BuildConfig.IAB_SKU_COFFEE
        )
    }

    override fun buyBeer() {
        iabGateway.purchase(
            BuildConfig.IAB_SKU_BEER
        )
    }

    override fun buyHotdog() {
        iabGateway.purchase(
            BuildConfig.IAB_SKU_HOTDOG
        )
    }

}
