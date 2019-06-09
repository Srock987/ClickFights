package com.srock.clickfights.Activities

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import com.srock.clickfights.ViewModels.GameViewModel

class GameView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : View(context, attrs, defStyleAttr) {

    var viewModel: GameViewModel? = null
    val dotPaint = Paint().apply {
        color = Color.BLUE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.WHITE)
        viewModel?.let {
            for (dot in it.game.dots){
                canvas?.drawCircle(dot.position.x,dot.position.y,dot.radius(System.currentTimeMillis()),dotPaint)
            }
        }
        invalidate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        viewModel?.initLocator(heightMeasureSpec,widthMeasureSpec)
    }
}