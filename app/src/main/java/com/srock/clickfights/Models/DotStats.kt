package com.srock.clickfights.Models

import kotlin.math.pow

class DotStats {
    companion object {
        val BASE_MILLIS = 2000
        val DECREMENT_MILLIS_SPEED = 0.95f

        val BASE_RADIUS = 100f


        fun lifespanInMillis(level: Int) : Int {
            return BASE_MILLIS.times((DECREMENT_MILLIS_SPEED).pow(level)).toInt()
        }

        fun mapSpanToRadius(spanRatio: Float) : Float{
            return spanRatio.minus(0.5f).pow(2).times(-4f).plus(1f)
        }
    }


}