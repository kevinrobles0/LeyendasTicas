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
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TestCuestionario {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testCuestionario() {
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
                allOf(withId(R.id.btnCegua),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.HorizontalScrollView")),
                                        0),
                                1)));
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
                allOf(withId(R.id.btnPreguntas),
                        childAtPosition(
                                allOf(withId(R.id.layoutLecturaCuento),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatButton3.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction textView = onView(
                allOf(withId(R.id.etiqueta_preguntas), withText("Iniciar Preguntas"),
                        withParent(withParent(withId(R.id.layoutIniciarPreguntasCuento))),
                        isDisplayed()));
        textView.check(matches(withText("Iniciar Preguntas")));

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.botonIniciarPreguntas),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layoutIniciarPreguntasCuento),
                                        1),
                                0),
                        isDisplayed()));
        appCompatButton4.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.btnPreguntaSiguiente), withText("Siguiente Pregunta"),
                        childAtPosition(
                                allOf(withId(R.id.layoutPreguntasLectura),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.btnPreguntaSiguiente), withText("Siguiente Pregunta"),
                        childAtPosition(
                                allOf(withId(R.id.layoutPreguntasLectura),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatButton6.perform(click());

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.btnPreguntaSiguiente), withText("Siguiente Pregunta"),
                        childAtPosition(
                                allOf(withId(R.id.layoutPreguntasLectura),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatButton7.perform(click());

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.btnPreguntaSiguiente), withText("Siguiente Pregunta"),
                        childAtPosition(
                                allOf(withId(R.id.layoutPreguntasLectura),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatButton8.perform(click());

        ViewInteraction appCompatButton9 = onView(
                allOf(withId(R.id.btnPreguntaSiguiente), withText("Siguiente Pregunta"),
                        childAtPosition(
                                allOf(withId(R.id.layoutPreguntasLectura),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatButton9.perform(click());

        ViewInteraction appCompatButton10 = onView(
                allOf(withId(R.id.btnPreguntaSiguiente), withText("Siguiente Pregunta"),
                        childAtPosition(
                                allOf(withId(R.id.layoutPreguntasLectura),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatButton10.perform(click());

        ViewInteraction appCompatButton11 = onView(
                allOf(withId(R.id.btnPreguntaSiguiente), withText("Siguiente Pregunta"),
                        childAtPosition(
                                allOf(withId(R.id.layoutPreguntasLectura),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatButton11.perform(click());

        ViewInteraction appCompatButton12 = onView(
                allOf(withId(R.id.btnPreguntaSiguiente), withText("Ver Resultados"),
                        childAtPosition(
                                allOf(withId(R.id.layoutPreguntasLectura),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatButton12.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction button = onView(
                allOf(withId(R.id.botonMenu),
                        withParent(allOf(withId(R.id.layoutResultadosPreguntas),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.txtPuntaje), withText("Usted contestó correctamente\n0  de  8 preguntas.\n Su puntuación es: 0"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))),
                        isDisplayed()));
        textView2.check(matches(withText("Usted contestó correctamente\n0  de  8 preguntas.\n Su puntuación es: 0")));
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
