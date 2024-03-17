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
    private var phoneNumberApp by mutableStateOf("")
    private var messageApp by mutableStateOf("")

    fun asignaPhoneNumberApp(phoneNumer:String){
        phoneNumberApp=phoneNumer
    }

    fun obtenerPhoneNumerApp():String{
        return phoneNumberApp
    }

    fun asignaMessageApp(message:String){
        messageApp=message
    }

    fun obtieneMessageApp():String{
        return messageApp
    }

    //Funciones para invocacion

    fun saveNumberMessage(){
        if(!this.messageApp.isNullOrEmpty() && !this.phoneNumberApp.isNullOrEmpty()){
            PreferencesUtils().saveString(ctx,"phoneNumber","+"+phoneNumberApp)
            PreferencesUtils().saveString(ctx,"message",messageApp)
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