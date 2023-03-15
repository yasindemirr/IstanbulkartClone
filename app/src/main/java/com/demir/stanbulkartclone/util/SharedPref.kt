package com.demir.stanbulkartclone.util

import android.content.Context
import android.content.SharedPreferences


class SharedPref(context: Context) {
    internal var sharedPreferences: SharedPreferences
    init {
        sharedPreferences=context.getSharedPreferences("fillname", Context.MODE_PRIVATE)

    }
    fun saveTime(time:Long?){
        val editor=sharedPreferences.edit()
        editor.putLong("time",time!!)
        editor.apply()

    }
    fun getTime():Long?{
        return sharedPreferences.getLong("time",0)

    }

}