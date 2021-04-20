package com.izwin.testwork.adapters

import com.izwin.testwork.model.PaymentModel

interface OnPaymentClickListener {
    fun onItemClick(model : PaymentModel)
}