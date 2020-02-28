package com.smlnskgmail.jaman.androidin_apppurchases.view.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.smlnskgmail.jaman.androidin_apppurchases.R
import com.smlnskgmail.jaman.androidin_apppurchases.model.profile.api.Profile
import com.smlnskgmail.jaman.androidin_apppurchases.presenter.profile.ProfilePresenter
import com.smlnskgmail.jaman.androidin_apppurchases.presenter.profile.ProfilePresenterImpl
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(), ProfileView {

    private lateinit var profilePresenter: ProfilePresenter

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        profilePresenter = ProfilePresenterImpl()
//        profilePresenter.initialize()

        user_donate_coffee.setOnClickListener {
            profilePresenter.buyCoffee()
        }
        user_donate_beer.setOnClickListener {
            profilePresenter.buyBeer()
        }
        user_donate_hotdog.setOnClickListener {
            profilePresenter.buyHotdog()
        }
    }

    override fun profileLoaded(
        profile: Profile
    ) {
        user_name.text = profile.name()
        user_image.setImageDrawable(
            profile.image()
        )
    }

    override fun buyCoffee() {

    }

    override fun buyBeer() {

    }

    override fun buyHotdog() {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_profile,
            container,
            false
        )
    }

}