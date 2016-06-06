package xiamubobby.com.payd

import android.app.Activity
import android.os.Bundle
import android.view.View

/**
 * Created by natsuki on 16/6/6.
 */
class TransparentActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val v = View(this)
        setContentView(v)
    }

    override fun onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}