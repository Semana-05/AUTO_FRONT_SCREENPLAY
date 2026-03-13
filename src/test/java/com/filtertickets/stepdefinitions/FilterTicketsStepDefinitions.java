package com.filtertickets.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import com.filtertickets.hooks.OpenBrowser;
import com.filtertickets.util.Constants;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import com.filtertickets.tasks.ExecuteFilter;
import com.filtertickets.tasks.WaitForResults;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import com.filtertickets.questions.FilterApply;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.equalToIgnoringCase;


public class FilterTicketsStepDefinitions {
    @Given("the operator is in view ticket window")
    public void theOperatorIsInViewTicketWindow() {
        OnStage.theActorCalled(Constants.ACTOR).attemptsTo(
                OpenBrowser.openURL(Constants.URL)
        );
    }

    @When("select priority {string}")
    public void selectPriority(String arg0) throws Throwable {
        theActorInTheSpotlight().attemptsTo(
                ExecuteFilter.filterTicket(arg0)
        );
    }

    @Then("only show tickets from priority {string}")
    public void onlyShowTicketsFromPriority(String arg0) {
        theActorInTheSpotlight().attemptsTo(
            WaitForResults.toBeVisible()       
        );
        theActorInTheSpotlight().should(
            seeThat(FilterApply.theDisplayedPriorities(),
                everyItem(equalToIgnoringCase(arg0)))
        );
    }
}