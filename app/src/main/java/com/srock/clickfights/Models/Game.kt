package com.srock.clickfights.Models

class Game(val startTime: Long,var killedDots: Int, var livesLeft: Int,var difficultyLevel: Int,var dots: MutableList<Dot>){
    constructor():this(System.currentTimeMillis(),0, 10,0, mutableListOf<Dot>())
}