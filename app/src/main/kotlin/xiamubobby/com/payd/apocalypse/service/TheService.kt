package xiamubobby.com.payd.apocalypse.service

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.support.v4.app.NotificationCompat
import android.widget.TextView
import xiamubobby.com.payd.apocalypse.activity.newrecord.NewRecordActivity

/**
 * Created by natsuki on 16/6/7.
 */
class TheService: Service() {
    //statics
    companion object {
        const val START_ID = 999;
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val startTheActivityIntent = Intent(this, NewRecordActivity::class.java)
        startTheActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val pendingIntent = PendingIntent.getActivity(this, 0, startTheActivityIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        val builder = NotificationCompat.Builder(this)
            .setSmallIcon(android.R.drawable.btn_star)
            .setContentIntent(pendingIntent)
            .setTicker("And here we go.")
            .setContentTitle("PayD NOW!!!")
            .setContentText("PayD NOW!!!")
            .setPriority(Notification.PRIORITY_MIN)
        val notification = builder.build()
        startForeground(startId, notification)
        return START_STICKY
//        return super.onStartCommand(intent, flags, startId);
    }
}