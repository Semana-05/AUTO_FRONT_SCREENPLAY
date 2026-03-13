package com.filtertickets.hooks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.Tasks;

public class OpenBrowser implements Task {

    private final String url;

    public OpenBrowser(String url) {
        this.url = url;
    }

    public static OpenBrowser openURL(String url) {
        return Tasks.instrumented(OpenBrowser.class, url);
    }

    public String getUrl() {
        return url;
    }

    @Override
    public void performAs(Actor actor) {
        actor.attemptsTo(
                Open.url(url)
        );
    }
}

