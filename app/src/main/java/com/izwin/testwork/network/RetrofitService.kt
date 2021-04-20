package com.izwin.testwork.network

import com.izwin.testwork.model.PaymentsResponseModel
import com.izwin.testwork.model.ResponseModel
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {
    @Headers("app-key: 12345" , "v: 1" )
    @POST("login")
    fun getToken(@Body post : UserPost): Call<ResponseModel>

    @Headers("app-key: 12345" , "v: 1" )
    @GET("payments")
    fun getPayments(@Query("token") token:String) : Call<PaymentsResponseModel>

}