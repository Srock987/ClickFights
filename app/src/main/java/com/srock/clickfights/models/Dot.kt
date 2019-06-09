package com.srock.clickfights.models

import com.srock.clickfights.models.DotStats.Companion.mapSpanToRadius


class Dot(val position: DotPosition,val birthDate: Long, val difficultyLevel: Int){

    var deathDate: Long = 0

   init {
        deathDate = birthDate.plus(DotStats.lifespanInMillis(difficultyLevel))
   }

    fun radius(currentTime: Long) : Float {
        return mapSpanToRadius(currentLifeSpanToTotalRatio(currentTime))*DotStats.BASE_RADIUS
    }

    fun currentLifeSpanToTotalRatio(currentTime: Long) : Float{
        val lifetime = deathDate-birthDate
        val timeElapsed = currentTime - birthDate
        return (lifetime-timeElapsed)/lifetime.toFloat()
    }

    fun isPositionInRadius(checkedPosition: DotPosition) : Boolean{
        return radius(System.currentTimeMillis()) >= checkedPosition.distanceToPosition(position)
    }


}