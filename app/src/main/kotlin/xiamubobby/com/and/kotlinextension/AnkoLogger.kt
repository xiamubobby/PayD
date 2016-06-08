package xiamubobby.com.and.kotlinextension

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.verbose

/**
 * Created by natsuki on 16/6/8.
 */

var stamp = System.currentTimeMillis()

fun AnkoLogger.tick() {
    stamp = System.currentTimeMillis()
}

fun AnkoLogger.tock(): Long {
    val ret = System.currentTimeMillis() - stamp
    verbose(ret)
    return ret
}