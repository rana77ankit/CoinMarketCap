package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class webRunSteps extends startWebDriver {

    @Given("I open url {string}")
    public void iOpenUrl(String url) {
        getDriver().get(url);
    }

    @When("Scroll to Show rows to {int}")
    public void Scroll_to_Show_rows_to_(int rows) {
        webScreens.scrollToShowRows(getDriver(), rows);
    }

    @Then("Verify that {int} rows are displayed")
    public void verifyRows(int rows) {
        webScreens.showVaueAt100(getDriver(), rows);
    }

    @When("Click on Filters button")
    public void clickFilters() throws InterruptedException {
        webScreens.showFilters();
    }

    @And("Filter records by MarketCap $1B to $10B and Price $101 to $1000")
    public void applyFilters() {
        webScreens.applyFiltersCrypto();
    }

    @Then("Check records displayed on page are correct as per the filter applied")
    public void checkRecords() {
        webScreens.checkRecordsDetail();
    }
}
