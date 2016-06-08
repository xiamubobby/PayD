package xiamubobby.com.payd.apocalypse.activity.newrecord

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import xiamubobby.com.payd.R
import xiamubobby.com.payd.apocalypse.service.TheService

/**
 * Created by natsuki on 16/6/6.
 */
class NewRecordActivity : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_record_activity)

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