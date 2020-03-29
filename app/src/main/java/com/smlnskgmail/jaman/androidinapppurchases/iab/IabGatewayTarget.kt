package com.smlnskgmail.jaman.androidinapppurchases.iab

interface IabGatewayTarget {

    fun iabPurchaseComplete(
        success: Boolean
    )

}
