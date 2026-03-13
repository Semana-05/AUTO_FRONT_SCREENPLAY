package com.filtertickets.tasks;

import com.filtertickets.ui.InitPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class ExecuteFilter implements Task {

    private final String priority;

    public ExecuteFilter(String priority) {
        this.priority = priority;
    }

    public static ExecuteFilter filterTicket(String priority) {
        return Tasks.instrumented(ExecuteFilter.class, priority);
    }

    public String getPriority() {
        return priority;
    }

    @Override
    public void performAs(Actor actor) {
        actor.attemptsTo(
            WaitUntil.the(InitPage.PRIORITY_DROPDOWN, WebElementStateMatchers.isClickable())
                .forNoMoreThan(10)
                .seconds(),
                SelectFromOptions.byValue(priority)
                .from(InitPage.PRIORITY_DROPDOWN)
        );
    }

    @Override
    public String toString() {
        return "Ejecutar filtro de tickets por prioridad: " + priority;
    }
}
