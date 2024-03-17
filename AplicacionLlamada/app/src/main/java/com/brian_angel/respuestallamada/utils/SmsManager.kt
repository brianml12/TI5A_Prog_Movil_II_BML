package com.brian_angel.respuestallamada.utils

import android.content.Context
import android.telephony.SmsManager

class SmsManager {
    fun sendMessage(ctx: Context, phoneNumber: String, message: String) {
        try {
            val smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(phoneNumber, null, message, null, null)
            ToastUtils().showToastLong(ctx,"Mensaje enviado correctamente")
        } catch (ex: Exception) {
            ToastUtils().showToastLong(ctx,"Error al enviar el mensaje")
        }
    }
}