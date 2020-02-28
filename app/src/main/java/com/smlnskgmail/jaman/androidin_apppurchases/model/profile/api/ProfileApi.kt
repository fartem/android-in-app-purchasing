package com.smlnskgmail.jaman.androidin_apppurchases.model.profile.api

interface ProfileApi {

    fun loadProfile(
        profileLoadTarget: ProfileLoadTarget
    )

    interface ProfileLoadTarget {

        fun profileLoaded(
            profile: Profile?
        )

    }

}