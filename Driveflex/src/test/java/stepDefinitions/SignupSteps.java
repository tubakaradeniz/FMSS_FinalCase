package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignupSteps {

    WebDriver driver;

    @Given("the user is on the sign up page")
    public void the_user_is_on_the_sign_up_page() {
        // Initialize WebDriver and navigate to the sign-up page
        driver = new ChromeDriver();
        driver.get("https://www.driveflex.com/signup");
    }

    @When("the user enters valid registration details")
    public void the_user_enters_valid_registration_details() {
        // Fill in the registration form with valid data
        driver.findElement(By.id("firstName")).sendKeys("Frodo");
        driver.findElement(By.id("lastName")).sendKeys("Baggins");
        driver.findElement(By.id("email")).sendKeys("frodobaggins@driveflex.com");
        driver.findElement(By.id("password")).sendKeys("password123");
    }

    @When("the user does not fill in the required fields")
    public void the_user_does_not_fill_in_the_required_fields() {
        // Leave required fields empty
        driver.findElement(By.id("email")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
    }

    @Then("the system should prevent the user from proceeding")
    public void the_system_should_prevent_the_user_from_proceeding() {
        // Ensure the user cannot proceed without filling required fields
        WebElement submitButton = driver.findElement(By.id("submitButton"));
        submitButton.click();
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assert(errorMessage.isDisplayed());
    }

    @When("the user submits the form")
    public void the_user_submits_the_form() {
        // Submit the registration form
        WebElement submitButton = driver.findElement(By.id("submitButton"));
        submitButton.click();
    }

    @Then("the system should save the user's details")
    public void the_system_should_save_the_user_s_details() {
        // Verify that user details are saved in the database (simplified here)
        // Typically, this would involve checking the database directly.
        String currentUrl = driver.getCurrentUrl();
        assert(currentUrl.contains("verification"));
    }

    @Then("the system should generate and send a verification code")
    public void the_system_should_generate_and_send_a_verification_code() {
        // Verify that the verification code is generated and sent
        // You would typically check for an email/SMS or an entry in the database.
        WebElement verificationPrompt = driver.findElement(By.id("verificationPrompt"));
        assert(verificationPrompt.isDisplayed());
    }

    @When("the user enters the correct verification code")
    public void the_user_enters_the_correct_verification_code() {
        // User enters the correct verification code
        driver.findElement(By.id("verificationCode")).sendKeys("123456");
    }

    @When("the user enters an incorrect or expired verification code")
    public void the_user_enters_an_incorrect_or_expired_verification_code() {
        // User enters an incorrect or expired verification code
        driver.findElement(By.id("verificationCode")).sendKeys("654321");
    }

    @Then("the system should display an error and prompt the user to retry")
    public void the_system_should_display_an_error_and_prompt_the_user_to_retry() {
        // Verify that an error message is displayed and user can retry
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assert(errorMessage.isDisplayed());
    }

    @Then("the system should allow the user to access the home page")
    public void the_system_should_allow_the_user_to_access_the_home_page() {
        // Verify that the user is taken to the home page after successful registration
        String currentUrl = driver.getCurrentUrl();
        assert(currentUrl.equals("https://www.driveflex.com/home"));
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

    @When("the user leaves mandatory fields blank")
    public void theUserLeavesMandatoryFieldsBlank() {
        
        
    }

    @And("clicks the sign-up button")
    public void clicksTheSignUpButton() {
        
    }

    @And("the user should remain on the sign-up page")
    public void theUserShouldRemainOnTheSignUpPage() {
        
    }

    @Then("the system should display an error message")
    public void theSystemShouldDisplayAnErrorMessage() {
    }

    @And("the user fills in all mandatory fields")
    public void theUserFillsInAllMandatoryFields() {
        
    }

    @When("the user clicks the sign-up button")
    public void theUserClicksTheSignUpButton() {
        
    }

    @Then("the system should save the user information in the database")
    public void theSystemShouldSaveTheUserInformationInTheDatabase() {
        
    }

    @And("the system should generate a verification code")
    public void theSystemShouldGenerateAVerificationCode() {
        
    }

    @And("the system should prompt the user to choose SMS or email for receiving the verification code")
    public void theSystemShouldPromptTheUserToChooseSMSOrEmailForReceivingTheVerificationCode() {
        
    }

    @And("enters the correct verification code within {int} minute")
    public void entersTheCorrectVerificationCodeWithinMinute(int arg0) {
        
    }

    @Then("the system should confirm the account verification")
    public void theSystemShouldConfirmTheAccountVerification() {
        
    }

    @And("the user should be redirected to the home page")
    public void theUserShouldBeRedirectedToTheHomePage() {
        
    }

    @Given("the user is on the verification page")
    public void theUserIsOnTheVerificationPage() {
        
    }

    @When("the user enters an incorrect verification code or the code has expired")
    public void theUserEntersAnIncorrectVerificationCodeOrTheCodeHasExpired() {
        
    }

    @And("the system should prompt the user to request a new verification code")
    public void theSystemShouldPromptTheUserToRequestANewVerificationCode() {
    }
}
