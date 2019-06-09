package com.srock.clickfights.models

import kotlin.math.absoluteValue
import kotlin.math.pow

class DotPosition(val x: Float,val y: Float){
    fun isCollidingWith(collidingDot: DotPosition) : Boolean{
        if ((collidingDot.x-x).absoluteValue < DotStats.BASE_RADIUS.times(2)
            && (collidingDot.y-y).absoluteValue < DotStats.BASE_RADIUS.times(2)){
            return true
        }
        return false
    }

    fun distanceToPosition(checkedPosition: DotPosition) : Float{
        return kotlin.math.sqrt((checkedPosition.x-x).absoluteValue.pow(2f) + (checkedPosition.y-y).absoluteValue.pow(2f))
    }

}