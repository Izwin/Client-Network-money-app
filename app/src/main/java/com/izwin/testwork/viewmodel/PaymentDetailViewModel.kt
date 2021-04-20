package com.izwin.testwork.viewmodel

import androidx.lifecycle.ViewModel
import com.izwin.testwork.model.PaymentModel

class PaymentDetailViewModel : ViewModel(){
    lateinit var model : PaymentModel

    fun getDesc(): String? {
        return model.desc
    }

    fun getAmount() : String?{
        return model.amount
    }

    fun getCurrency() : String?{
        return if(model.currency!!.isEmpty()) "???" else model.currency
    }
    fun getCreated(): String?{
        return model.created.toString()
    }

}