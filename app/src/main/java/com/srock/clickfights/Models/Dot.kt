package com.srock.clickfights.Models

import android.R.attr.x
import com.srock.clickfights.Models.DotStats.Companion.mapSpanToRadius
import kotlin.math.pow


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


}