package com.brian_angel.respuestallamada.ui.viewmodels

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.brian_angel.respuestallamada.utils.PreferencesUtils
import com.brian_angel.respuestallamada.utils.ToastUtils

class HomeViewModel(private val ctx: Context) : ViewModel() {
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

    //Funciones para invocacion

    fun saveNumberMessage(){
        if(!this.message.isNullOrEmpty() && !this.phoneNumber.isNullOrEmpty()){
            PreferencesUtils().saveString(ctx,"phoneNumber","+"+phoneNumber)
            PreferencesUtils().saveString(ctx,"message",message)
            ToastUtils().showToastLong(ctx,"Numero y mensaje guadados con exito")
        }else{
            ToastUtils().showToastLong(ctx,"Campos vacios")
        }
    }


}
class HomeViewModelFactory(
    private val ctx: Context
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(ctx) as T
    }
}