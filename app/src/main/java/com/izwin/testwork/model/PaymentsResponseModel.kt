package com.izwin.testwork.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName



class PaymentsResponseModel {
    @SerializedName("success")
    @Expose
    var success: String? = null

    @SerializedName("response")
    @Expose
    var response: List<PaymentModel>? = null
}

class PaymentModel {
    @SerializedName("desc")
    @Expose
    var desc: String? = null

    @SerializedName("amount")
    @Expose
    var amount: String? = null

    @SerializedName("currency")
    @Expose
    var currency: String? = null

    @SerializedName("created")
    @Expose
    var created = 0
}