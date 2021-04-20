package com.izwin.testwork.viewmodel

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.ViewModel
import com.izwin.testwork.repo.Repo
import kotlin.math.log

class ProfileViewModel : ViewModel() , Observable{
    val callbacks = PropertyChangeRegistry()
    fun getCurrentToken() : String{
        return Repo.user.token
    }
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.remove(callback)
    }
}