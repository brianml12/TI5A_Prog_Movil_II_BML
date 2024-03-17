package com.brian_angel.respuestallamada.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HomeViewModel : ViewModel() {
    private var phoneNumber by mutableStateOf("")
    private var message by mutableStateOf("")

    fun setPhoneNumber(phoneNumer:String){
        this.phoneNumber=phoneNumer
    }

    fun getPhoneNumer():String{
        return this.phoneNumber
    }

    fun setMessage(message:String){
        this.message=message
    }

    fun getMessage():String{
        return this.message
    }


}
class HomeViewModelFactory(
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel() as T
    }
}