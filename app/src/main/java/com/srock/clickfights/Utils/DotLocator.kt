package com.srock.clickfights.Utils

import com.srock.clickfights.Models.Dot
import com.srock.clickfights.Models.DotPosition
import com.srock.clickfights.Models.DotStats
import kotlin.random.Random

class DotLocator(private val height: Int, private val width: Int) {
    fun findNewSpot(dots :List<DotPosition>) : DotPosition{
        val proposedHeight = Random.nextInt(DotStats.BASE_RADIUS.toInt(),height-DotStats.BASE_RADIUS.toInt())
        val proposedWidth = Random.nextInt(DotStats.BASE_RADIUS.toInt(),width-DotStats.BASE_RADIUS.toInt())
        var newDot = DotPosition(proposedWidth.toFloat(),proposedHeight.toFloat())
        val collidingDots = dots.filter { it.isCollidingWith(newDot) }
        if (collidingDots.isNotEmpty()){
            newDot = findNewSpot(dots)
        }
        return newDot
    }
}