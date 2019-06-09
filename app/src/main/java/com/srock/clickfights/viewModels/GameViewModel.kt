package com.srock.clickfights.viewModels

import android.os.Handler
import androidx.lifecycle.ViewModel
import com.srock.clickfights.models.Dot
import com.srock.clickfights.models.DotPosition
import com.srock.clickfights.models.Game
import com.srock.clickfights.utils.DotLocator

class GameViewModel : ViewModel() {
    val game = Game()
    var locator : DotLocator? = null
    var viewHeight: Int = 0
    var viewWidth: Int = 0
    var spawning: Boolean = false

    fun initLocator(measuredHeight: Int, measuredWidth: Int){
        viewHeight = measuredHeight
        viewWidth = measuredWidth
        locator = DotLocator(measuredHeight,measuredWidth)
        if (!spawning){
            spawn()
        }
    }

    fun spawn(){
        locator?.let {
            Handler().postDelayed({
                game.dots.add(Dot(it.findNewSpot(game.dots.map { it.position }.toList()),
                    System.currentTimeMillis(),0))
                spawn()
            },2000)
            spawning = true
        }
    }

    fun dotNaturalDeath(dyingDot: Dot){
        game.dots.remove(dyingDot)
    }

    fun killTry(killPosition: DotPosition){
        val clickedDots = game.dots.filter { dot -> dot.isPositionInRadius(killPosition) }
        if (clickedDots.isNotEmpty()) {
            for (clicked in clickedDots) {
                game.dots.remove(clicked)
            }
        }
    }
}