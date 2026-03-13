package com.filtertickets.ui;

import net.serenitybdd.screenplay.targets.Target;

public class InitPage {

    public static final Target PRIORITY_DROPDOWN = Target.the("Priority dropdown")
            .locatedBy("#filter-priority");

    public static final Target TICKETS_TABLE = Target.the("Tickets table container")
            .locatedBy("table.min-w-full");

    public static final Target PRIORITY_CELL = 
        Target.the("priority cell")
                          .locatedBy("td:nth-child(5) span");

            static final Target PAGE_TITLE = Target.the("Page title")
            .locatedBy("//h1[@class='dashboard-title']");

}


