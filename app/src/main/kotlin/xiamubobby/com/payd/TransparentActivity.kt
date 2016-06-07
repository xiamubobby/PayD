package xiamubobby.com.payd

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import xiamubobby.com.payd.apocolyps.service.TheService

/**
 * Created by natsuki on 16/6/6.
 */
class TransparentActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val v = View(this)
        setContentView(v)
    }

    override fun onResume() {
        super.onResume()
        startService(Intent(this, TheService::class.java))
    }

    override fun onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}