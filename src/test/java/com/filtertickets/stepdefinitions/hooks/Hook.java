package com.filtertickets.stepdefinitions.hooks;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import io.cucumber.java.Before;

public class Hook {

    @Before
    public void initScenario() {
            OnStage.setTheStage(new OnlineCast());
    }

}
