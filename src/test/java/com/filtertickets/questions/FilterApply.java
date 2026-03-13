package com.filtertickets.questions;

import com.filtertickets.ui.InitPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.stream.Collectors;

public class FilterApply implements Question<List<String>> {

    public static FilterApply theDisplayedPriorities() {
        return new FilterApply();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(InitPage.PRIORITY_CELL, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10)
                        .seconds()
        );

        List<String> priorities = actor.asksFor(
            Text.ofEach(InitPage.PRIORITY_CELL)
        ).stream()
        .map(String::trim)
        .collect(Collectors.toList());

        System.out.println("Prioridades capturadas: " + priorities);
        return priorities;
    }
}


