package com.smlnskgmail.jaman.androidinapppurchases.iab

interface IabGatewayTarget {

    fun iabProgress(begin: Boolean)
    fun iabError()

    fun iabPurchaseComplete(
        success: Boolean
    )
    fun iabPurchaseInfo(sku: String)
    fun iabProductInfo(sku: String)

}
