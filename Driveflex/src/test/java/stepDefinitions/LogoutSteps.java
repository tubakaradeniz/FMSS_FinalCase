package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogoutSteps {

    WebDriver driver;

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        // Initialize WebDriver and navigate to the main page
        driver = new ChromeDriver();
        driver.get("https://www.driveflex.com/login");

        // Log in with valid credentials
        driver.findElement(By.id("email")).sendKeys("user@driveflex.com");
        driver.findElement(By.id("password")).sendKeys("password123");
        driver.findElement(By.id("loginButton")).click();
    }

    @When("the user clicks the logout button")
    public void the_user_clicks_the_logout_button() {
        // Locate and click the logout button
        WebElement logoutButton = driver.findElement(By.id("logoutButton"));
        logoutButton.click();
    }

    @Then("the system displays a confirmation message")
    public void the_system_displays_a_confirmation_message() {
        // Verify the confirmation message is displayed
        WebElement confirmationMessage = driver.findElement(By.id("confirmationMessage"));
        assert(confirmationMessage.isDisplayed());
    }

    @When("the user selects {string}")
    public void the_user_selects(String option) {
        // User selects Yes or No on the confirmation dialog
        if (option.equals("Yes")) {
            WebElement yesButton = driver.findElement(By.id("yesButton"));
            yesButton.click();
        } else {
            WebElement noButton = driver.findElement(By.id("noButton"));
            noButton.click();
        }
    }

    @Then("the user should be redirected to the login page")
    public void the_user_should_be_redirected_to_the_login_page() {
        // Verify the user is redirected to the login page after logging out
        String currentUrl = driver.getCurrentUrl();
        assert(currentUrl.equals("https://www.driveflex.com/login"));
    }

    @Then("the user should remain on the main menu")
    public void the_user_should_remain_on_the_main_menu() {
        // Verify the user remains on the main menu if they cancel logout
        String currentUrl = driver.getCurrentUrl();
        assert(currentUrl.equals("https://www.driveflex.com/main"));
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

    @And("the system displays {string}")
    public void theSystemDisplays(String arg0) {
        
    }

    @Then("the user should be securely logged out")
    public void theUserShouldBeSecurelyLoggedOut() {
    }
}
