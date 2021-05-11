package com.jitusolution.advweek4_160718035.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.jitusolution.advweek4_160718035.R
import com.jitusolution.advweek4_160718035.Util.createNotificationChannel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


import java.util.*

class MainActivity : AppCompatActivity() {
    init {
        //dipakek untuk mengeset instance =  this
        //init adalah blog program
        instance = this
    }
    companion object //static = object belum tercipta
    {
        private var instance:MainActivity ?=null
        fun showNotification(title:String , content:String , icon:Int){
            val channelID ="${instance?.packageName}-${instance?.getString(R.string.app_name)}"
            val builder = NotificationCompat.Builder(instance!!.applicationContext,channelID)
                    .apply {
                        setSmallIcon(icon)
                        setContentTitle(title)
                        setContentText(content)
                        setStyle(NotificationCompat.BigTextStyle())
                        priority = NotificationCompat.PRIORITY_DEFAULT
                        setAutoCancel(true)//kalau notifnya klik diluar maka auto tertutup
                    }
       val notif =  NotificationManagerCompat.from(instance!!.applicationContext)
        notif.notify(1001,builder.build())
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotificationChannel(this,NotificationManagerCompat.IMPORTANCE_DEFAULT,true,
                getString(R.string.app_name), "App Channel")
//        val observable = Observable.just("hellow","world","!!")
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                {Log.d("Message","data captured: $it")},//next
//                {Log.e("Messages", it.message.toString())},//error
//                {Log.d("Messages", "Completed") }//complete
//            )
        //23.22

    }
}