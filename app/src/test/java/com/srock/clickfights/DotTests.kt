package com.srock.clickfights

import com.srock.clickfights.models.Dot
import com.srock.clickfights.models.DotPosition
import com.srock.clickfights.models.DotStats
import org.junit.Test

class DotTests {

    @Test
    fun dot_creation(){
        val x = 23f
        val y = 45f
        val position = DotPosition(x,y)
        val birthTime = System.currentTimeMillis()
        val diffLevel = 0
        val dot = Dot(position,birthTime,diffLevel)
        assert(dot.birthDate.equals(birthTime))
        assert(dot.deathDate.equals(birthTime.plus(DotStats.BASE_MILLIS)))
        assert(dot.position.equals(position))
        assert(dot.difficultyLevel.equals(diffLevel))
    }

    @Test
    fun check_lifespan_ratio_calculation(){
        val x = 23f
        val y = 45f
        val position = DotPosition(x,y)
        val birthTime = System.currentTimeMillis()
        val diffLevel = 0

        val dot = Dot(position,birthTime,diffLevel)
        assert(dot.currentLifeSpanToTotalRatio(birthTime).equals(1f))
        assert(dot.currentLifeSpanToTotalRatio(birthTime.plus(DotStats.BASE_MILLIS/2)).equals(0.5f))
        assert(dot.currentLifeSpanToTotalRatio(birthTime.plus(DotStats.BASE_MILLIS)).equals(0f))
    }


    @Test
    fun check_lifespan_mapping_calculation(){
        val x = 23f
        val y = 45f
        val position = DotPosition(x,y)
        val birthTime = System.currentTimeMillis()
        val diffLevel = 0

        val dot = Dot(position,birthTime,diffLevel)
        assert(dot.radius(birthTime).times(DotStats.BASE_RADIUS).equals(0f))
        assert(dot.radius(birthTime.plus(DotStats.BASE_MILLIS/2)).div(DotStats.BASE_RADIUS).equals(1f))
        assert(dot.radius(birthTime.plus(DotStats.BASE_MILLIS)).times(DotStats.BASE_RADIUS).equals(0f))
    }




}