package com.srock.clickfights.Models

import kotlin.math.absoluteValue

class DotPosition(val x: Float,val y: Float){
    fun isCollidingWith(collidingDot: DotPosition) : Boolean{
        if ((collidingDot.x-x).absoluteValue < DotStats.BASE_RADIUS.times(2)
            && (collidingDot.y-y).absoluteValue < DotStats.BASE_RADIUS.times(2)){
            return true
        }
        return false
    }
}