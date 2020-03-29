package com.smlnskgmail.jaman.androidinapppurchases.iab

import android.app.Activity
import com.android.billingclient.api.*

class IabGateway(
    private val iabGatewayTarget: IabGatewayTarget,
    private val activity: Activity
) : PurchasesUpdatedListener {

    private val billingClient = BillingClient.newBuilder(activity)
        .setListener(this)
        .enablePendingPurchases()
        .build()

    fun purchase(sku: String) {
        billingClient.startConnection(object : BillingClientStateListener {
            override fun onBillingServiceDisconnected() {
                iabGatewayTarget.iabPurchaseComplete(false)
            }

            override fun onBillingSetupFinished(
                billingResult: BillingResult?
            ) {
                if (billingResult?.responseCode == BillingClient.BillingResponseCode.OK) {
                    val parameters = SkuDetailsParams.newBuilder()
                    parameters.setSkusList(
                        listOf(sku)
                    )
                    parameters.setType(
                        BillingClient.SkuType.INAPP
                    )
                    billingClient.querySkuDetailsAsync(
                        parameters.build()
                    ) { billing, skus ->
                        if (billing?.responseCode
                            == BillingClient.BillingResponseCode.OK) {
                            val billingFlowParams = BillingFlowParams.newBuilder()
                            billingFlowParams.setSkuDetails(skus[0])
                            billingClient.launchBillingFlow(
                                activity,
                                billingFlowParams.build()
                            )
                        } else {
                            iabGatewayTarget.iabPurchaseComplete(false)
                        }
                    }
                }
                else {
                    iabGatewayTarget.iabPurchaseComplete(false)
                }
            }
        })
    }

    override fun onPurchasesUpdated(
        billingResult: BillingResult?,
        purchases: MutableList<Purchase>?
    ) {
        if (billingResult?.responseCode == BillingClient.BillingResponseCode.OK
            && purchases != null) {
            purchases.forEach {
                handlePurchase(it)
            }
        }
    }

    private fun handlePurchase(purchase: Purchase) {
        val consumeParams = ConsumeParams.newBuilder()
        consumeParams.setPurchaseToken(
            purchase.purchaseToken
        )
        billingClient.consumeAsync(
            consumeParams.build()
        ) { _, _ ->  }
    }

}
