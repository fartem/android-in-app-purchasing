package com.smlnskgmail.jaman.androidinapppurchases.view.profile

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.smlnskgmail.jaman.androidinapppurchases.BuildConfig
import com.smlnskgmail.jaman.androidinapppurchases.R
import com.smlnskgmail.jaman.androidinapppurchases.model.profile.api.Profile
import com.smlnskgmail.jaman.androidinapppurchases.model.profile.api.ProfileApi
import com.smlnskgmail.jaman.androidinapppurchases.model.profile.impl.debug.DebugProfileApi
import com.smlnskgmail.jaman.androidinapppurchases.model.profile.impl.randomuser.RandomUserProfileApi
import com.smlnskgmail.jaman.androidinapppurchases.presenter.profile.ProfilePresenter
import com.smlnskgmail.jaman.androidinapppurchases.presenter.profile.ProfilePresenterImpl
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(), ProfileView {

    private lateinit var profilePresenter: ProfilePresenter

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        profilePresenter = ProfilePresenterImpl()
        profilePresenter.initialize(
            this,
            profileApi()
        )

        profile_contact_email.setOnClickListener {
            profilePresenter.emailContactSelect()
        }
        profile_contact_phone.setOnClickListener {
            profilePresenter.phoneContactSelect()
        }
        profile_contact_address.setOnClickListener {
            profilePresenter.addressContactSelect()
        }

        profile_donate_coffee.setOnClickListener {
            profilePresenter.buyCoffee()
        }
        profile_donate_beer.setOnClickListener {
            profilePresenter.buyBeer()
        }
        profile_donate_hotdog.setOnClickListener {
            profilePresenter.buyHotdog()
        }
    }

    private fun profileApi(): ProfileApi {
        return if (BuildConfig.API_IMPL == "DEBUG_IMPL") {
            DebugProfileApi(context!!)
        } else {
            RandomUserProfileApi()
        }
    }

    override fun profileLoaded(
        profile: Profile
    ) {
        if (profile_donate_page.visibility != View.VISIBLE) {
            profile_data_load_error_view.visibility = View.GONE
            profile_data_loader.visibility = View.GONE
            profile_donate_page.visibility = View.VISIBLE
        }
        profile_name.text = profile.name()
        profile_image.setImageDrawable(
            profile.image()
        )

        val bio = getString(R.string.profile_bio_template).format(
            profile.name()
        )
        profile_bio.text = bio
    }

    override fun startLoading() {
        profile_donate_page.visibility = View.GONE
        profile_data_loader.visibility = View.VISIBLE
    }

    override fun stopLoading() {
        profile_data_loader.visibility = View.GONE
    }

    override fun showLoadError() {
        profile_donate_page.visibility = View.GONE
        profile_data_load_error_view.visibility = View.VISIBLE
    }

    override fun sendEmail(
        email: String
    ) {
        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.type = "plain/text"
        emailIntent.putExtra(
            Intent.EXTRA_EMAIL,
            email
        )
        emailIntent.putExtra(
            Intent.EXTRA_SUBJECT,
            "DonateMe"
        )

        startActivity(
            Intent.createChooser(
                emailIntent,
                "Send email..."
            )
        )
    }

    override fun callToPhoneNumber(
        number: String
    ) {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:$number")
        startActivity(callIntent)
    }

    override fun showAddress(
        address: String
    ) {
        val snackbar = Snackbar.make(
            root_profile_view,
            address,
            Snackbar.LENGTH_LONG
        )
        snackbar.setAction(
            R.string.profile_address_action
        ) {
            val clipboardManager = context!!.getSystemService(
                Context.CLIPBOARD_SERVICE
            ) as ClipboardManager
            val clipData = ClipData.newPlainText(
                getString(R.string.app_name),
                address
            )
            clipboardManager.setPrimaryClip(clipData)
        }
        snackbar.show()
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