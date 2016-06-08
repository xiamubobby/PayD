package xiamubobby.com.payd.widget

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.AnkoLogger
import xiamubobby.com.and.kotlinextension.tick
import xiamubobby.com.and.kotlinextension.tock

/**
 * Created by natsuki on 16/6/8.
 */
class NumPad @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int = 0) : ViewGroup(context, attrs, defStyleAttr, defStyleRes), AnkoLogger {

    companion object {
        enum class Button {
            ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, ZERO, PERIOD, INCOME, OUTCOME
        }
        val ButtonsMap: MutableMap<Button, String> = mutableMapOf(
                Button.ONE to "1",
                Button.TWO to "2",
                Button.THREE to "3",
                Button.FOUR to "4",
                Button.FIVE to "5",
                Button.SIX to "6",
                Button.SEVEN to "7",
                Button.EIGHT to "8",
                Button.NINE to "9",
                Button.ZERO to "0",
                Button.PERIOD to ".",
                Button.INCOME to "+",
                Button.OUTCOME to "-"
        )
    }

    val buttonTextViews: MutableMap<Button, TextView>
    init {
        tick()
        background = RoundRectDrawable(Color.WHITE, RoundRectDrawable.DEFAULT_RADIUS)
        val mother = this
        buttonTextViews = hashMapOf()
        ButtonsMap.entries.forEach {
            buttonTextViews.put(it.key, TextView(context).apply { text = it.value; mother.addView(this) })
        }
        tock()
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var i = 0
        ButtonsMap.entries.forEach {
            val offset = (i++) * 30
            buttonTextViews[it.key]?.layout(0 + offset, 0 + offset, 30 + offset, 60 + offset)
        }
    }

}