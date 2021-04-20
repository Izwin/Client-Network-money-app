package com.izwin.testwork.viewmodel

import androidx.lifecycle.ViewModel
import com.izwin.testwork.repo.Repo

class PaymentsViewModel : ViewModel() {
    fun getCurrentToken() : String{
        return Repo.user.token
    }
}