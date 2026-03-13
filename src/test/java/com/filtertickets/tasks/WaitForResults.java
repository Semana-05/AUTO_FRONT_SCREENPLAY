package com.filtertickets.tasks;

import com.filtertickets.ui.InitPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class WaitForResults implements Task {

    public static WaitForResults toBeVisible() {
        return Tasks.instrumented(WaitForResults.class);
    }

    @Override
    public void performAs(Actor actor) {
        actor.attemptsTo(
            WaitUntil.the(InitPage.PRIORITY_CELL, WebElementStateMatchers.isVisible())
                     .forNoMoreThan(10)
                     .seconds()
        );
    }
}