package com.brian_angel.respuestallamada.utils

import android.content.Context
import android.widget.Toast

class ToastUtils {
    fun showToastLong(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}