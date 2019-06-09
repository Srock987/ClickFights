package com.srock.clickfights.activities

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.srock.clickfights.models.Dot
import com.srock.clickfights.models.DotPosition
import com.srock.clickfights.viewModels.GameViewModel

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
            var dotToDrop: Dot? = null
            for (dot in it.game.dots){
                canvas?.drawCircle(dot.position.x,dot.position.y,dot.radius(System.currentTimeMillis()),dotPaint)
                if (dot.radius(System.currentTimeMillis())<0f){
                    it.dotNaturalDeath(dot)
                }
            }
        }
        invalidate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val newHeight= MeasureSpec.getSize(heightMeasureSpec);
        val newWidth= MeasureSpec.getSize(widthMeasureSpec);
        viewModel?.initLocator(newHeight,newWidth)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.actionMasked == MotionEvent.ACTION_DOWN){
            viewModel?.killTry(DotPosition(event.x,event.y))

        }
        return super.onTouchEvent(event)
    }
}