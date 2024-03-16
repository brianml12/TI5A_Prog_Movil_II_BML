package com.brian_angel.respuestallamada.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.telephony.PhoneStateListener
import android.telephony.TelephonyCallback
import android.telephony.TelephonyManager
import android.util.Log

class ReceiverCallsPhone : BroadcastReceiver()
{
    override fun onReceive(ctx: Context, intent: Intent) {
        val telephonyManager: TelephonyManager = ctx.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            telephonyManager.registerTelephonyCallback(
                ctx.mainExecutor,
                object : TelephonyCallback(), TelephonyCallback.CallStateListener {
                    override fun onCallStateChanged(state: Int) {
                        if (state == TelephonyManager.CALL_STATE_RINGING) {
                            val phoneNumber: String? = intent!!.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)
                            Log.e("SI",phoneNumber!!)
                        }
                    }
                })
        } else {
            telephonyManager.listen(object : PhoneStateListener() {
                override fun onCallStateChanged(state: Int, phoneNumbern: String?) {
                    if (state == TelephonyManager.CALL_STATE_RINGING) {
                        var obtenerNumero = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)
                        if (obtenerNumero != null) {
                            Log.e("obtenerNumero ", obtenerNumero)
                        }
                    }
                }
            }, PhoneStateListener.LISTEN_CALL_STATE)
        }
    }
}