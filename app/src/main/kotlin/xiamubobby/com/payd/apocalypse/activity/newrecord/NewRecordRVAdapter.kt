package xiamubobby.com.payd.apocalypse.activity.newrecord

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

/**
 * Created by natsuki on 16/6/8.
 */
class NewRecordRVAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        enum class ViewType {
            NUMPAD
        }
    }
    private val renderers = mutableListOf<NewRecordRVRenderer>()
    override fun getItemCount(): Int {
        return renderers.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        return when (viewType) {
            ViewType.NUMPAD.ordinal -> null
            else -> null
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {

    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> ViewType.NUMPAD.ordinal
            else -> -1
        }
    }
}

class NewRecordRVViewHolder(v: View?): RecyclerView.ViewHolder(v) {

}

interface NewRecordRVRenderer {
    fun onBindViewHolder(holder: NewRecordRVViewHolder?, position: Int)
}

interface NumpadRenderer: NewRecordRVRenderer {
    fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder?
}

