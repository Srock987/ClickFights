package com.srock.clickfights

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.srock.clickfights.activities.GameActivity
import com.srock.clickfights.activities.MenuActivity
import org.junit.Rule
import org.junit.Test

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MenuInstrumentTest {

    @Rule
    @JvmField
    val rule: ActivityTestRule<MenuActivity> = ActivityTestRule(MenuActivity::class.java)

    @Test
    fun user_can_start_new_game(){
        Intents.init()
        onView(withId(R.id.new_game_button)).perform(click())
        intended(hasComponent(GameActivity::class.java.name))
        Intents.release()
    }

    @Test
    fun user_can_see_ranking(){
        onView(withId(R.id.records_button)).perform(click())
    }

    @Test
    fun user_can_exit(){
        onView(withId(R.id.exit_button)).perform(click())
    }


}