package com.stephenjfox.simpletextreplacer;


import android.support.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Tests to exercise the view and expected behaviors
 *
 * Created by Stephen on 9/18/2016.
 */
public class TextReplacerActivityInstrumentationTest {

  // Preferred JUnit 4 mechanism of specifying the activity to be launched before each test
  @Rule
  public ActivityTestRule<TextReplacerActivity> activityTestRule =
      new ActivityTestRule<>(TextReplacerActivity.class);

  @Test
  public void testSimpleTextFill() {
    // type text into the edit text
    onView(withId(R.id.main_edit_text))
        .perform(typeText("Test text"))
        .check(matches(withText("Test text")));
    // valid that it exists
  }

  ///////////////////////////////////////////////////////////////////////////
  // Test LabelTextField in action
  ///////////////////////////////////////////////////////////////////////////

  @Test
  public void testFillFindText() {
    // I don't know where to go from here.
//    onView(withContentDescription(R.string.find_field_description))
  }

  @Test
  public void testFillReplaceText() {

  }
}
