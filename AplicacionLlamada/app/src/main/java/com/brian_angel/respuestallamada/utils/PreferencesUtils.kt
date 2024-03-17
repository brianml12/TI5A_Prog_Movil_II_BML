package com.brian_angel.respuestallamada.utils

import android.content.Context

class PreferencesUtils {
    fun saveString(ctx: Context, key: String, value: String) {
        val sharedPref = ctx.getSharedPreferences("llamadasApp", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getString(ctx: Context, key: String, defaultValue: String): String? {
        val sharedPref = ctx.getSharedPreferences("llamadasApp", Context.MODE_PRIVATE)
        return sharedPref.getString(key, defaultValue)
    }
}