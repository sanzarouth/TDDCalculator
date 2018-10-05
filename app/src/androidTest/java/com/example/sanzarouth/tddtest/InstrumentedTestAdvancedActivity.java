package com.example.sanzarouth.tddtest;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.sanzarouth.tddtest.View.AdvancedActivity;
import com.example.sanzarouth.tddtest.View.MainActivity;

import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class InstrumentedTestAdvancedActivity {

    @Rule
    public ActivityTestRule<AdvancedActivity> activityRule = new ActivityTestRule<AdvancedActivity>(AdvancedActivity.class);



}
