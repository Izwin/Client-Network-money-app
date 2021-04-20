package com.izwin.testwork.model



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class ResponseModel {

    @SerializedName("success")
    @Expose
    var success:String? = null
    @SerializedName("response")
    @Expose
    var response: Response? = null

}

class Response {

    @SerializedName("token")
    @Expose
    var token:String? = null

}