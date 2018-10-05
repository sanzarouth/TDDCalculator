package com.example.sanzarouth.tddtest;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.sanzarouth.tddtest.View.AdvancedActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class InstrumentedTestAdvancedActivity {

    @Rule
    public ActivityTestRule<AdvancedActivity> activityRule = new ActivityTestRule<AdvancedActivity>(AdvancedActivity.class);


    @Test
    public void canEvaluateExpression() {
        Espresso.onView(withId(R.id.advancedInput)).perform(ViewActions.typeText("(3+3)*(3-1)"));
        Espresso.onView(withId(R.id.calculateBtn)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.advancedResultView)).check(matches(withText("12.0")));
    }

    @Test
    public void cannotEvaluateExpressionWithWrongFormat() {
        Espresso.onView(withId(R.id.advancedInput)).perform(ViewActions.typeText("(3+3)*3-1)"));
        Espresso.onView(withId(R.id.calculateBtn)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.advancedResultView)).check(matches(withText("NaN")));
    }

    @Test
    public void cannotEvaluateExpressionWithWrongCharacters() {
        Espresso.onView(withId(R.id.advancedInput)).perform(ViewActions.typeText("(3+3)*3-p)"));
        Espresso.onView(withId(R.id.calculateBtn)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.advancedResultView)).check(matches(withText("NaN")));
    }

    @Test
    public void canRotateScreenAndSaveState() {
        Espresso.onView(withId(R.id.advancedInput)).perform(ViewActions.typeText("(3+3)*(3-1)"));
        Espresso.onView(withId(R.id.calculateBtn)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.advancedResultView)).check(matches(withText("12.0")));

        rotateScreen();

        Espresso.onView(withId(R.id.advancedResultView)).check(matches(withText("12.0")));

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
