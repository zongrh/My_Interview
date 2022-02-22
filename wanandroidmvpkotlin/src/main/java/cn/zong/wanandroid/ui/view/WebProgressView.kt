package cn.zong.wanandroid.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import cn.zong.wanandroid.R

/**
 *
 * FileName: WebProgressView
 * Author: nanzong
 * Date: 2022/2/22 9:47 下午
 * Description:
 * History:
 *
 */
class WebProgressView : View {

    private var mPaint: Paint
    private var mCurrentX: Int = 0

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs, 0){
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint.color = resources.getColor(R.color.progress_color)
        mPaint.strokeWidth = 30f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawLine(0f, 0f, mCurrentX.toFloat(), 0f, mPaint)
    }

    fun setCurrentX(currentX: Int) {
        mCurrentX = currentX * (width / 100)
        invalidate()
    }
}