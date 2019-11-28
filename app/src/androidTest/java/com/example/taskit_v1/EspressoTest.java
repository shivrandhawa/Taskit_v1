package com.example.taskit_v1;

import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.DatePicker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import androidx.test.espresso.contrib.PickerActions;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class EspressoTest {
    GlobalVars g = GlobalVars.getInstance();

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);
    @Test
    public void ensureTextChangesWork() {
        onView(withId(R.id.editText)).perform(typeText("espressotest"),closeSoftKeyboard());
        onView(withId(R.id.goto_activity)).perform(click());
        onView(withId(R.id.displayText)).check(matches(withText("espressotest")));

    }

    @Test
    public void testCrateTask(){
        String testString = "Test Task created by espresso";
        onView(withId(R.id.add_task_btn)).perform(click());
        onView(withId(R.id.create_textbox)).perform(replaceText(testString));
        onView(withId(R.id.post_btn)).perform(click());
        @SuppressLint({"NewApi", "LocalSuppress"}) String listString = String.join(", ", g.getTasks());
        String str = String.valueOf(g.getSize());

        String t1 = g.getTasks().get(1);

        assertEquals(testString,t1);

        Log.e( "arraylistcontents: ", listString);
        Log.e( "sizeofArray: ", str);

    }
    @Test
    public void testCrateTask_long(){
        String testString_l = "A sample much much longer version of the testCrateTask espresso test.. A sample much much longer version of the testCrateTask espresso test..A sample much much longer version of the testCrateTask espresso test..";

        onView(withId(R.id.add_task_btn)).perform(click());
        onView(withId(R.id.create_textbox)).perform(replaceText(testString_l));
        onView(withId(R.id.post_btn)).perform(click());
        @SuppressLint({"NewApi", "LocalSuppress"}) String listString = String.join(", ", g.getTasks());
        String str = String.valueOf(g.getSize());

        String t1 = g.getTasks().get(0);

        assertEquals(testString_l,t1);

}}
