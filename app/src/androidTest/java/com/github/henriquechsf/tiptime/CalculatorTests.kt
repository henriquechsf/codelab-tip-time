package com.github.henriquechsf.tiptime

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorTests {

    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_20_percent_tip() {
        Espresso.onView(ViewMatchers.withId(R.id.cost_of_service_edit_text))
            .perform(ViewActions.typeText("50.00"))
            .perform(ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.calculate_button))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.tip_result))
            .check(ViewAssertions.matches(ViewMatchers.withText("Tip Amount: $10.00")))
    }

    @Test
    fun calculate_20_percent_tip_not_round() {
        Espresso.onView(ViewMatchers.withId(R.id.cost_of_service_edit_text))
            .perform(ViewActions.typeText("50.90"))
            .perform(ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.round_up_switch))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.calculate_button))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.tip_result))
            .check(ViewAssertions.matches(ViewMatchers.withText("Tip Amount: $10.18")))
    }

    @Test
    fun calculate_18_percent_tip() {
        Espresso.onView(ViewMatchers.withId(R.id.cost_of_service_edit_text))
            .perform(ViewActions.typeText("50.00"))
            .perform(ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.option_eighteen_percent))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.calculate_button))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.tip_result))
            .check(ViewAssertions.matches(ViewMatchers.withText("Tip Amount: $9.00")))
    }

    @Test
    fun calculate_18_percent_tip_not_round() {
        Espresso.onView(ViewMatchers.withId(R.id.cost_of_service_edit_text))
            .perform(ViewActions.typeText("50.90"))
            .perform(ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.option_eighteen_percent))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.round_up_switch))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.calculate_button))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.tip_result))
            .check(ViewAssertions.matches(ViewMatchers.withText("Tip Amount: $9.16")))
    }

    @Test
    fun calculate_15_percent_tip() {
        Espresso.onView(ViewMatchers.withId(R.id.cost_of_service_edit_text))
            .perform(ViewActions.typeText("50.00"))
            .perform(ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.option_fifteen_percent))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.calculate_button))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.tip_result))
            .check(ViewAssertions.matches(ViewMatchers.withText("Tip Amount: $8.00")))
    }

    @Test
    fun calculate_15_percent_tip_not_round() {
        Espresso.onView(ViewMatchers.withId(R.id.cost_of_service_edit_text))
            .perform(ViewActions.typeText("50.90"))
            .perform(ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.option_fifteen_percent))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.round_up_switch))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.calculate_button))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.tip_result))
            .check(ViewAssertions.matches(ViewMatchers.withText("Tip Amount: $7.64")))
    }
}