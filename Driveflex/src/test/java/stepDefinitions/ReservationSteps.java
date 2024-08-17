package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;

public class ReservationSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("the user is on the homepage")
    public void userIsOnHomepage() {
        driver.get("https://driveflex.com");
    }

    @When("the user views recommended vehicles")
    public void userViewsRecommendedVehicles() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("recommendedVehicles")));
    }

    @Then("the user should see a list of recommended vehicles")
    public void userShouldSeeRecommendedVehicles() {
        WebElement recommendedVehicles = driver.findElement(By.id("recommendedVehicles"));
        assert recommendedVehicles.isDisplayed();
    }

    @Given("the user has selected a vehicle")
    public void userHasSelectedVehicle() {
        WebElement vehicle = driver.findElement(By.cssSelector(".vehicle-select"));
        vehicle.click();
    }

    @When("the user chooses rental dates")
    public void userChoosesRentalDates() {
        WebElement startDate = driver.findElement(By.id("startDate"));
        WebElement endDate = driver.findElement(By.id("endDate"));
        startDate.sendKeys("2024-09-01");
        endDate.sendKeys("2024-09-10");
    }

    @Then("the system checks if the vehicle is available on the selected dates")
    public void systemChecksVehicleAvailability() {
        WebElement checkButton = driver.findElement(By.id("checkAvailability"));
        checkButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("availabilityStatus")));
    }

    @And("if the vehicle is not available, the user is prompted to select a different vehicle or dates")
    public void vehicleNotAvailable() {
        WebElement status = driver.findElement(By.id("availabilityStatus"));
        assert status.getText().contains("not available");
    }

    @And("if the vehicle is available, the rental dates are confirmed")
    public void vehicleAvailable() {
        WebElement status = driver.findElement(By.id("availabilityStatus"));
        assert status.getText().contains("available");
    }

    @When("the system checks for existing driver information")
    public void systemChecksDriverInfo() {
        WebElement driverInfo = driver.findElement(By.id("driverInfo"));
        if (driverInfo.getText().isEmpty()) {
            driver.findElement(By.id("addDriverInfo")).click();
        }
    }

    @Then("the user is directed to the rental agreement screen")
    public void userDirectedToRentalAgreement() {
        WebElement agreementScreen = driver.findElement(By.id("rentalAgreement"));
        assert agreementScreen.isDisplayed();
    }

    @When("the user reviews the rental agreement")
    public void userReviewsRentalAgreement() {
        WebElement agreement = driver.findElement(By.id("agreementText"));
        assert agreement.isDisplayed();
    }

    @Then("the user must accept the agreement to proceed to the payment screen")
    public void userAcceptsAgreement() {
        WebElement acceptButton = driver.findElement(By.id("acceptAgreement"));
        acceptButton.click();
    }

    @When("the user completes the payment")
    public void userCompletesPayment() {
        WebElement paymentButton = driver.findElement(By.id("completePayment"));
        paymentButton.click();
    }

    @Then("if the payment is successful, the user receives a receipt via email or SMS")
    public void paymentSuccessful() {
        WebElement receipt = driver.findElement(By.id("paymentReceipt"));
        assert receipt.isDisplayed();
    }

    @Then("if the payment fails, the user is notified and cannot proceed")
    public void paymentFailed() {
        WebElement errorMessage = driver.findElement(By.id("paymentError"));
        assert errorMessage.isDisplayed();
    }

    @Given("the user has confirmed rental dates")
    public void theUserHasConfirmedRentalDates() {
        
    }

    @Then("if no driver information exists, the user is prompted to enter driver information")
    public void ifNoDriverInformationExistsTheUserIsPromptedToEnterDriverInformation() {
    }

    @And("if driver information exists, the user is directed to the rental agreement screen")
    public void ifDriverInformationExistsTheUserIsDirectedToTheRentalAgreementScreen() {
        
    }

    @Given("the user is on the rental agreement screen")
    public void theUserIsOnTheRentalAgreementScreen() {
        
    }

    @Given("the user is on the payment screen")
    public void theUserIsOnThePaymentScreen() {
    }

    @Given("the user is on the vehicle selection page")
    public void userOnVehicleSelectionPage() {
        driver.get("https://driveflex.com/vehicle-selection");
    }

    @When("the user selects a vehicle")
    public void userSelectsVehicle() {
        WebElement vehicle = driver.findElement(By.id("vehicle-id"));
        vehicle.click();
    }

    @When("the user selects rental dates from {string} to {string}")
    public void userSelectsRentalDates(String startDate, String endDate) {
        WebElement start = driver.findElement(By.id("start-date"));
        start.sendKeys(startDate);
        WebElement end = driver.findElement(By.id("end-date"));
        end.sendKeys(endDate);
        WebElement confirmDates = driver.findElement(By.id("confirm-dates"));
        confirmDates.click();
    }

    @When("the user realizes the dates need to be changed")
    public void userRealizesDatesNeedChange() {
        WebElement changeDatesButton = driver.findElement(By.id("change-dates"));
        changeDatesButton.click();
    }

    @When("the user selects new rental dates from {string} to {string}")
    public void userSelectsNewRentalDates(String newStartDate, String newEndDate) {
        WebElement newStart = driver.findElement(By.id("start-date"));
        newStart.clear();
        newStart.sendKeys(newStartDate);
        WebElement newEnd = driver.findElement(By.id("end-date"));
        newEnd.clear();
        newEnd.sendKeys(newEndDate);
        WebElement confirmNewDates = driver.findElement(By.id("confirm-new-dates"));
        confirmNewDates.click();
    }

    @Then("the system updates the reservation with the new dates")
    public void systemUpdatesReservationWithNewDates() {
        WebElement confirmationMessage = driver.findElement(By.id("confirmation"));
        assert(confirmationMessage.getText().contains("Dates updated"));
    }

    @Then("the user sees the updated rental dates in the confirmation")
    public void userSeesUpdatedRentalDatesInConfirmation() {
        WebElement updatedDates = driver.findElement(By.id("updated-dates"));
        assert(updatedDates.isDisplayed());
    }
}
