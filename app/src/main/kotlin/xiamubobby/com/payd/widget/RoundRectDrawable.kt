package xiamubobby.com.payd.widget

import android.graphics.*
import android.graphics.drawable.Drawable

/**
 * Created by natsuki on 16/6/8.
 */
class RoundRectDrawable(backgroundColor: Int, radius: Float) : Drawable() {
    companion object {
        const val DEFAULT_RADIUS = 5.0f
    }
    var mRadius: Float = 0.toFloat()
    private val mPaint: Paint
    private val mBoundsF: RectF
    private val mBoundsI: Rect
    var mPadding: Float = 0.toFloat()
    private var mInsetForPadding = false
    private var mInsetForRadius = true

    init {
        this.mRadius = radius
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG)
        mPaint.color = backgroundColor
        mBoundsF = RectF()
        mBoundsI = Rect()
    }

    fun setPadding(padding: Float, insetForPadding: Boolean, insetForRadius: Boolean) {
        if (padding == this.mPadding && mInsetForPadding == insetForPadding &&
                mInsetForRadius == insetForRadius) {
            return
        }
        this.mPadding = padding
        mInsetForPadding = insetForPadding
        mInsetForRadius = insetForRadius
        updateBounds(null)
        invalidateSelf()
    }

    override fun draw(canvas: Canvas) {
        canvas.drawRoundRect(mBoundsF, mRadius, mRadius, mPaint)
    }

    private fun updateBounds(bounds: Rect?) {
        var bounds = bounds
        if (bounds == null) {
            bounds = getBounds()
        }
        mBoundsF.set(bounds!!.left.toFloat(), bounds.top.toFloat(), bounds.right.toFloat(), bounds.bottom.toFloat())
        mBoundsI.set(bounds)
        if (mInsetForPadding) {
            val vInset = 0//calculateVerticalPadding(padding, radius, mInsetForRadius)
            val hInset = 0//calculateHorizontalPadding(padding, radius, mInsetForRadius)
            mBoundsI.inset(Math.ceil(hInset.toDouble()).toInt(), Math.ceil(vInset.toDouble()).toInt())
            // to make sure they have same bounds.
            mBoundsF.set(mBoundsI)
        }
    }

    fun setRadius(radius: Float) {
        if (radius == mRadius) {
            return
        }
        mRadius = radius
        updateBounds(null)
        invalidateSelf()
    }

    override fun onBoundsChange(bounds: Rect) {
        super.onBoundsChange(bounds)
        updateBounds(bounds)
    }

    override fun getOutline(outline: Outline) {
        outline.setRoundRect(mBoundsI, mRadius)
    }

    override fun setAlpha(alpha: Int) {
        // not supported because older versions do not support
    }

    override fun setColorFilter(cf: ColorFilter?) {
        // not supported because older versions do not support
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

    fun setColor(color: Int) {
        mPaint.color = color
        invalidateSelf()
    }
}