package com.dicoding.picodiploma.jetpacksubmissiondua

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyTvSeries = DataDummy.generateDummyTvSeries()

    @get: Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    //Movies Test
    @Test
    fun loadMovies(){
        onView(withId(R.id.recycle_view_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.recycle_view_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailFilmInMovies(){
        onView(withId(R.id.recycle_view_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.txt_film_title)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_film_title)).check(matches(withText(dummyMovie[0].filmName)))

        onView(withId(R.id.txt_film_type)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_film_type)).check(matches(withText(dummyMovie[0].filmType)))

        onView(withId(R.id.txt_film_description)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_film_description)).check(matches(withText(dummyMovie[0].filmDescription)))
    }


    //TV Series test
    @Test
    fun loadTvSeries(){
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.recycle_view_tv_series)).check(matches(isDisplayed()))
        onView(withId(R.id.recycle_view_tv_series)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvSeries.size))
    }

    @Test
    fun loadDetailFilmInTvSeries(){
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.recycle_view_tv_series)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.txt_film_title)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_film_title)).check(matches(withText(dummyTvSeries[0].filmName)))

        onView(withId(R.id.txt_film_type)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_film_type)).check(matches(withText(dummyTvSeries[0].filmType)))

        onView(withId(R.id.txt_film_description)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_film_description)).check(matches(withText(dummyTvSeries[0].filmDescription)))
    }
}