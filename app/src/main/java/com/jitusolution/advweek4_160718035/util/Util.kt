package com.jitusolution.advweek4_160718035.Util

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ClipDescription
import android.content.Context
import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.jitusolution.advweek4_160718035.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

fun createNotificationChannel(context:Context , importance:Int,showBadge:Boolean,name:String,description: String){
    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
        val channelId = "${context.packageName}-$name"
        val channel = NotificationChannel(channelId,name,importance)
        channel.description = description
        channel.setShowBadge(showBadge)
        val notificationManager = context.getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)

    }
}

fun ImageView.loadImage(url:String? ,progressBar: ProgressBar?)
{
    Picasso.get()
            .load(url)
            .resize(400, 400)
            .centerCrop()
            .error(R.drawable.ic_baseline_error_24)
            .into(this,object:Callback{
                    override fun onSuccess() {
                            progressBar?.visibility = View.GONE
                    }

                    override fun onError(e: Exception?) {
                            TODO("Not yet implemented")
                    }

            })

}
@BindingAdapter("android:imageUrl","android:progressBar")
fun loadPhotoURL(view: ImageView,url:String?,pb:ProgressBar){
    view.loadImage(url,pb)
}
@BindingAdapter("android:imageUrl")
fun loadPhotoURL2(view: ImageView,url:String?){
    view.loadImage(url,null)
}