package com.srock.clickfights

import com.srock.clickfights.Models.Dot
import com.srock.clickfights.Models.DotPosition
import com.srock.clickfights.Models.DotStats
import com.srock.clickfights.Utils.DotLocator
import org.junit.Test

class DotLocatorTests {

    @Test
    fun check_dots_collision(){
        val x1 = 50f
        val y1 = 50f
        val position1 = DotPosition(x1,y1)

        val x2 = 100f
        val y2 = 100f
        val position2 = DotPosition(x2,y2)

        assert(position1.isCollidingWith(position2))
        assert(position2.isCollidingWith(position1))

        val x3 = 500f
        val y3 = 500f
        val position3 = DotPosition(x3,y3)

        assert(!position1.isCollidingWith(position3))
        assert(!position3.isCollidingWith(position1))
    }

    @Test
    fun check_new_spot_finder(){
        val dots = listOf(DotPosition(50f,50f), DotPosition(350f,350f))
        val locator =  DotLocator(1000,1000)

        val newDot = locator.findNewSpot(dots)

        for (dot in dots){
            assert(!dot.isCollidingWith(newDot))
        }

        assert(newDot.y >= DotStats.BASE_RADIUS && newDot.y <= 1000 - DotStats.BASE_RADIUS.toInt())
        assert(newDot.x >= DotStats.BASE_RADIUS && newDot.x <= 1000 - DotStats.BASE_RADIUS.toInt())

    }
}