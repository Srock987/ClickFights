package com.srock.clickfights.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.srock.clickfights.R
import com.srock.clickfights.viewModels.GameViewModel
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    lateinit var gameViewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

    }

    override fun onStart() {
        super.onStart()
        gameViewModel = GameViewModel()
        game_view.viewModel = gameViewModel
    }
}