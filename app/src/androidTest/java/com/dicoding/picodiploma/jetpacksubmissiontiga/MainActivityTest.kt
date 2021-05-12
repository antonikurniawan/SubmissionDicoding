package com.dicoding.picodiploma.jetpacksubmissiontiga

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.dicoding.picodiploma.jetpacksubmissiontiga.main.MainActivity
import com.dicoding.picodiploma.jetpacksubmissiontiga.utils.DataDummy
import com.dicoding.picodiploma.jetpacksubmissiontiga.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest {

    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyTvSeries = DataDummy.generateDummyTvSeries()


    @Before
    fun setup(){
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

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