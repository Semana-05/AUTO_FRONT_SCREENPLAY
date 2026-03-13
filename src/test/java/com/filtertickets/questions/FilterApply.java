package com.filtertickets.questions;

import com.filtertickets.ui.InitPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import java.util.List;
import java.util.stream.Collectors;

public class FilterApply implements Question<List<String>> {

    public static FilterApply theDisplayedPriorities() {
        return new FilterApply();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        return actor.asksFor(Text.ofEach(InitPage.PRIORITY_CELL))
                    .stream()
                    .map(String::trim)
                    .collect(Collectors.toList());
    }
}