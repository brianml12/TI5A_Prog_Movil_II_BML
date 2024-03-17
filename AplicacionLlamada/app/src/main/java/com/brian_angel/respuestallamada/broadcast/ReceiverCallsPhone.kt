package com.brian_angel.respuestallamada.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.telephony.PhoneStateListener
import android.telephony.TelephonyCallback
import android.telephony.TelephonyManager
import android.util.Log
import com.brian_angel.respuestallamada.utils.PreferencesUtils
import com.brian_angel.respuestallamada.utils.SmsManager

class ReceiverCallsPhone() : BroadcastReceiver()
{
    override fun onReceive(ctx: Context, intent: Intent) {
        var incoming_number = intent.extras!!.getString(TelephonyManager.EXTRA_INCOMING_NUMBER)
        val telephonyManager: TelephonyManager = ctx.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            telephonyManager.registerTelephonyCallback(
                ctx.mainExecutor,
                object : TelephonyCallback(), TelephonyCallback.CallStateListener {
                    override fun onCallStateChanged(state: Int) {
                        if (state == TelephonyManager.CALL_STATE_RINGING) {
                            if(incoming_number!=null){
                                val numberPrerences=PreferencesUtils().getString(ctx, "phoneNumber", "")
                                if(incoming_number.equals(numberPrerences)){
                                    val messagePrerences=PreferencesUtils().getString(ctx, "message", "")
                                    SmsManager().sendMessage(ctx,numberPrerences, messagePrerences!!)
                                }
                                //Log.e("numero_entrante", incoming_number)
                            }
                        }
                    }
                })
        } else {
            telephonyManager.listen(object : PhoneStateListener() {
                override fun onCallStateChanged(state: Int, phoneNumbern: String?) {
                    if (state == TelephonyManager.CALL_STATE_RINGING) {
                        if(incoming_number!=null){
                            val numberPrerences=PreferencesUtils().getString(ctx, "phoneNumber", "")
                            if(incoming_number.equals(numberPrerences)){
                                val messagePrerences=PreferencesUtils().getString(ctx, "message", "")
                                SmsManager().sendMessage(ctx,numberPrerences, messagePrerences!!)
                            }
                            //Log.e("numero_entrante", incoming_number)
                        }
                    }
                }
            }, PhoneStateListener.LISTEN_CALL_STATE)
        }
    }
}