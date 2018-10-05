package com.example.sanzarouth.tddtest;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.view.View;

import com.example.sanzarouth.tddtest.View.AdvancedActivity;
import com.example.sanzarouth.tddtest.View.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
public class InstrumentedTestMainActivity {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void canAddTwoInts() {
        Log.e("@Test","Testing addition of ints");

        Espresso.onView((withId(R.id.number1)))
                .perform(ViewActions.typeText("22"));
        Espresso.onView((withId(R.id.number2)))
                .perform(ViewActions.typeText("292"));

        Espresso.onView(withId(R.id.addBtn))
                .perform(ViewActions.click());

        Espresso.onView(withId(R.id.resultView))
                .check(matches(withText("314.0")));
    }

    @Test
    public void canAddTwoDoubles() {
        Log.e("@Test", "Testing addition of doubles");

        Espresso.onView((withId(R.id.number1)))
                .perform(ViewActions.typeText("3.4"));
        Espresso.onView((withId(R.id.number2)))
                .perform(ViewActions.typeText("9.1"));

        Espresso.onView(withId(R.id.addBtn))
                .perform(ViewActions.click());

        Espresso.onView(withId(R.id.resultView))
                .check(matches(withText("12.5")));
    }


    @Test
    public void canSubstractTwoDoubles() {
        Log.e("@Test", "Testing subtraction of doubles");

        Espresso.onView((withId(R.id.number1)))
                .perform(ViewActions.typeText("3.4"));
        Espresso.onView((withId(R.id.number2)))
                .perform(ViewActions.typeText("1.1"));

        Espresso.onView(withId(R.id.subBtn))
                .perform(ViewActions.click());

        Espresso.onView(withId(R.id.resultView))
                .check(matches(withText("2.3")));
    }

    @Test
    public void canMultiplyTwoDoubles() {
        Log.e("@Test", "Testing multiplication of doubles");

        Espresso.onView((withId(R.id.number1)))
                .perform(ViewActions.typeText("2.3"));
        Espresso.onView((withId(R.id.number2)))
                .perform(ViewActions.typeText("4.5"));

        Espresso.onView(withId(R.id.multBtn))
                .perform(ViewActions.click());

        Espresso.onView(withId(R.id.resultView))
                .check(matches(withText("10.35")));
    }

    @Test
    public void canDivideTwoDoubles() {
        Log.e("@Test", "Testing division of doubles");

        Espresso.onView((withId(R.id.number1)))
                .perform(ViewActions.typeText("3.4"));
        Espresso.onView((withId(R.id.number2)))
                .perform(ViewActions.typeText("1.1"));

        Espresso.onView(withId(R.id.divBtn))
                .perform(ViewActions.click());

        Espresso.onView(withId(R.id.resultView))
                .check(matches(withText(Double.toString(3.4/1.1))));
    }

    @Test
    public void canUpdateResult() {
        Log.e("@Test", "Testing result updating");

        Espresso.onView((withId(R.id.number1)))
                .perform(ViewActions.typeText("22"));
        Espresso.onView((withId(R.id.number2)))
                .perform(ViewActions.typeText("292"));

        Espresso.onView(withId(R.id.addBtn))
                .perform(ViewActions.click());

        Espresso.onView(withId(R.id.number1))
                .perform(ViewActions.replaceText("1"));

        Espresso.onView(withId(R.id.addBtn))
                .perform(ViewActions.click());

        Espresso.onView(withId(R.id.resultView))
                .check(matches(withText("293.0")));
    }

    @Test
    public void canRotateScreenAndSaveState() {
        Log.e("@Test", "Testing screen rotation");

        Espresso.onView((withId(R.id.number1)))
                .perform(ViewActions.typeText("1"));
        Espresso.onView((withId(R.id.number2)))
                .perform(ViewActions.typeText("292"));

        Espresso.onView(withId(R.id.addBtn))
                .perform(ViewActions.click());

        rotateScreen();

        Espresso.onView(withId(R.id.resultView))
                .check(matches(withText("293.0")));

    }

    @Test
    public void advancedSettingsOpenOnButtonClick() {
        Log.e("@Test", "Testing new activity on Advanced button click");

        Intents.init();

        Espresso.onView(withId(R.id.advancedBtn))
                .perform(ViewActions.click());

        intended(hasComponent(AdvancedActivity.class.getName()));

        Intents.release();
    }

    private void rotateScreen() {
        Context context = InstrumentationRegistry.getTargetContext();
        int orientation = context.getResources().getConfiguration().orientation;

        Activity activity = activityRule.getActivity();
        activity.setRequestedOrientation(
                (orientation == Configuration.ORIENTATION_PORTRAIT) ?
                        ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE :
                        ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

}
