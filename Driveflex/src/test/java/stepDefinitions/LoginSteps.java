package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {

    WebDriver driver;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Initialize the WebDriver and navigate to the login page
        driver = new ChromeDriver();
        driver.get("https://www.driveflex.com/login");
    }

    @When("the user enters {string} and {string}")
    public void the_user_enters_and(String email, String password) {
        // Locate email and password fields and enter provided credentials
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));

        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }

    @When("clicks the login button")
    public void clicks_the_login_button() {
        // Locate and click the login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }

    @Then("the system should display {string} and prompt the user to sign up")
    public void the_system_should_display_and_prompt_the_user_to_sign_up(String message) {
        // Check for the "Account does not exist" message
        WebElement alert = driver.findElement(By.id("alertMessage"));
        assert(alert.getText().equals(message));
    }

    @Then("the user should be redirected to the dashboard page")
    public void the_user_should_be_redirected_to_the_dashboard_page() {
        // Verify the user is redirected to the dashboard
        String currentUrl = driver.getCurrentUrl();
        assert(currentUrl.equals("https://www.driveflex.com/dashboard"));
    }

    @Then("the system should display {string}")
    public void the_system_should_display(String message) {
        // Check for the "Incorrect email or password" message
        WebElement alert = driver.findElement(By.id("alertMessage"));
        assert(alert.getText().equals(message));
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

    @And("the user has an account with email {string} and password {string}")
    public void theUserHasAnAccountWithEmailAndPassword(String arg0, String arg1) {
    }

    @When("the user clicks on the {string} link")
    public void theUserClicksOnTheLink(String arg0) {
        
    }

    @Then("the system should redirect to the registration page")
    public void theSystemShouldRedirectToTheRegistrationPage() {
    }
}
