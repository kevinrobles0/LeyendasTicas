package cr.ac.tec.lectuticas.Activities;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cr.ac.tec.lectuticas.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TestRepasoDelCuento {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testRepasoDelCuento() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.botonSeleccionarHistoria),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_menu_principal),
                                        0),
                                0),
                        isDisplayed()));
        appCompatButton.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btnCadejos),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.HorizontalScrollView")),
                                        0),
                                0)));
        appCompatButton2.perform(scrollTo(), click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.btnAdelante),
                        childAtPosition(
                                allOf(withId(R.id.layoutLecturaCuento),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.btnAdelante),
                        childAtPosition(
                                allOf(withId(R.id.layoutLecturaCuento),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.btnAdelante),
                        childAtPosition(
                                allOf(withId(R.id.layoutLecturaCuento),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.btnAdelante),
                        childAtPosition(
                                allOf(withId(R.id.layoutLecturaCuento),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatButton6.perform(click());

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.btnAdelante),
                        childAtPosition(
                                allOf(withId(R.id.layoutLecturaCuento),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatButton7.perform(click());

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.btnAdelante),
                        childAtPosition(
                                allOf(withId(R.id.layoutLecturaCuento),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatButton8.perform(click());

        ViewInteraction appCompatButton9 = onView(
                allOf(withId(R.id.btnAdelante),
                        childAtPosition(
                                allOf(withId(R.id.layoutLecturaCuento),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatButton9.perform(click());

        ViewInteraction appCompatButton10 = onView(
                allOf(withId(R.id.btnAdelante),
                        childAtPosition(
                                allOf(withId(R.id.layoutLecturaCuento),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatButton10.perform(click());

        ViewInteraction appCompatButton11 = onView(
                allOf(withId(R.id.btnAdelante),
                        childAtPosition(
                                allOf(withId(R.id.layoutLecturaCuento),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatButton11.perform(click());

        ViewInteraction appCompatButton12 = onView(
                allOf(withId(R.id.btnAdelante),
                        childAtPosition(
                                allOf(withId(R.id.layoutLecturaCuento),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatButton12.perform(click());

        ViewInteraction appCompatButton13 = onView(
                allOf(withId(R.id.btnAdelante),
                        childAtPosition(
                                allOf(withId(R.id.layoutLecturaCuento),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatButton13.perform(click());

        ViewInteraction appCompatButton14 = onView(
                allOf(withId(R.id.btnAdelante),
                        childAtPosition(
                                allOf(withId(R.id.layoutLecturaCuento),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatButton14.perform(click());

        ViewInteraction button = onView(
                allOf(withId(R.id.btnAtras),
                        withParent(allOf(withId(R.id.layoutLecturaCuento),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction button2 = onView(
                allOf(withId(R.id.botonMenu),
                        withParent(allOf(withId(R.id.layoutLecturaCuento),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        button2.check(matches(isDisplayed()));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
