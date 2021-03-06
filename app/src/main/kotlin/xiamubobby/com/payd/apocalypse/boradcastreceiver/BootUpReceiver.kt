package xiamubobby.com.payd.apocalypse.boradcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import xiamubobby.com.payd.apocalypse.service.TheService

/**
 * Created by natsuki on 16/6/7.
 */
class BootUpReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        context?.startService(Intent(context, TheService::class.java))
    }
}