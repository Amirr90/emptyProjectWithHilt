package com.firebasemultiplelogins.utils.extensionFunctions

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.media.RingtoneManager
import android.net.Uri
import android.util.Log
import com.firebasemultiplelogins.utils.appLevel.App
import java.text.SimpleDateFormat
import java.util.Date

class ConstantFunctions {
    companion object {

        @SuppressLint("SimpleDateFormat")
        fun getDate(
            timestamp: Long = System.currentTimeMillis(),
            format: String = "EEE, MMM dd yyyy",
        ): String {
            val sdf = SimpleDateFormat(format)
            val netDate = Date(timestamp)
            return sdf.format(netDate)
        }

        @SuppressLint("SimpleDateFormat")
        fun getTime(
            timestamp: Long = System.currentTimeMillis(),
            format: String = "h:mm a",
        ): String {
            val sdf = SimpleDateFormat(format)
            val netDate = Date(timestamp)
            return sdf.format(netDate)
        }


        fun playNotificationSound() {
            try {
                val alarmSound = Uri.parse(
                    ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + App.instance.applicationContext
                        .packageName + "/raw/alert"
                )
                val ringtone =
                    RingtoneManager.getRingtone(App.instance.applicationContext, alarmSound)
                ringtone.play()
            } catch (ex: Exception) {
                Log.d("TAG", "playNotificationSoundException: " + ex.localizedMessage)
            }
        }
    }

}