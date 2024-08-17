package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;

public class VehicleFilteringSteps {

    WebDriver driver;

    @Given("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        driver.get("http://driveflex.com");
    }

    @When("the user opens the filter menu")
    public void theUserOpensTheFilterMenu() {
        driver.findElement(By.id("filter-menu-button")).click();
    }

    @When("the user selects the {string} filter")
    public void theUserSelectsTheFilter(String filterType) {
        WebElement filterDropdown = driver.findElement(By.id("filter-dropdown"));
        Select selectFilter = new Select(filterDropdown);
        selectFilter.selectByVisibleText(filterType);
    }

    @When("the user chooses {string}")
    public void theUserChooses(String filterOption) {
        WebElement filterOptionElement = driver.findElement(By.xpath("//option[contains(text(),'" + filterOption + "')]"));
        filterOptionElement.click();
    }

    @When("the user sets the price range between {string} and {string} dollars per day")
    public void theUserSetsThePriceRangeBetweenAndDollarsPerDay(String minPrice, String maxPrice) {
        driver.findElement(By.id("min-price")).sendKeys(minPrice);
        driver.findElement(By.id("max-price")).sendKeys(maxPrice);
    }

    @Then("the list of available vehicles should display only {string}")
    public void theListOfAvailableVehiclesShouldDisplayOnly(String expectedType) {
        WebElement vehicleList = driver.findElement(By.id("vehicle-list"));
        Assert.assertTrue(vehicleList.getText().contains(expectedType));
    }

    @Then("the list of available vehicles should display only vehicles within the specified price range")
    public void theListOfAvailableVehiclesShouldDisplayOnlyVehiclesWithinTheSpecifiedPriceRange() {
        WebElement vehicleList = driver.findElement(By.id("vehicle-list"));
        // Add your logic to validate price range
    }

    @Then("the list of available vehicles should display all vehicle options")
    public void theListOfAvailableVehiclesShouldDisplayAllVehicleOptions() {
        WebElement vehicleList = driver.findElement(By.id("vehicle-list"));
        // Add logic to verify that all vehicles are displayed
    }

    @When("the user clears all filters")
    public void theUserClearsAllFilters() {
        driver.findElement(By.id("clear-filters")).click();
    }

    @Then("the list of available vehicles should display only SUVs")
    public void theListOfAvailableVehiclesShouldDisplayOnlySUVs() {
        
    }

    @Then("the list of available vehicles should display only vehicles with automatic transmission")
    public void theListOfAvailableVehiclesShouldDisplayOnlyVehiclesWithAutomaticTransmission() {
        
    }

    @And("the user selects the {string} filter and chooses {string}")
    public void theUserSelectsTheFilterAndChooses(String arg0, String arg1) {
        
    }

    @And("the user selects the {string} filter and sets it between {string} and {string} dollars per day")
    public void theUserSelectsTheFilterAndSetsItBetweenAndDollarsPerDay(String arg0, String arg1, String arg2) {
        
    }

    @Then("the list of available vehicles should display only SUVs with automatic transmission within the specified price range")
    public void theListOfAvailableVehiclesShouldDisplayOnlySUVsWithAutomaticTransmissionWithinTheSpecifiedPriceRange() {
        
    }

    @Given("the user has applied multiple filters")
    public void theUserHasAppliedMultipleFilters() {
    }
}
