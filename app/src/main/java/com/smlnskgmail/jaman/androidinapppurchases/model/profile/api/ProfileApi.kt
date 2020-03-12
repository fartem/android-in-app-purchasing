package com.smlnskgmail.jaman.androidinapppurchases.model.profile.api

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