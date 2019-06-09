package com.srock.clickfights.ViewModels

import android.os.Handler
import androidx.lifecycle.ViewModel
import com.srock.clickfights.Models.Dot
import com.srock.clickfights.Models.DotPosition
import com.srock.clickfights.Models.Game
import com.srock.clickfights.Utils.DotLocator

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
}