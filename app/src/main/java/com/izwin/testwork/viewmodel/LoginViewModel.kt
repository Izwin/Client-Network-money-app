package com.izwin.testwork.viewmodel

import androidx.lifecycle.ViewModel
import com.izwin.testwork.network.UserPost
import com.izwin.testwork.model.ResponseModel
import com.izwin.testwork.model.UserModel
import com.izwin.testwork.network.RetrofitInstance
import com.izwin.testwork.network.RetrofitService
import com.izwin.testwork.repo.Repo
import retrofit2.Call

class LoginViewModel : ViewModel(){
    suspend fun getResponse(login:String , pass:String): Call<ResponseModel> {
        val service = RetrofitInstance.client.create(RetrofitService::class.java)
        return service.getToken(UserPost(login,pass))
    }
    fun setCurrentUser(token:String){
        Repo.user = UserModel(token)
    }
}