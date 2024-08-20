package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class registerDeps {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1936, 1056));
    }
    @After
    public void tearDown() {
        driver.close();
    }

    @Given("User is on the register page")
    public void userIsOnTheRegisterPage() {
        driver.get("https://www.demoblaze.com");
        WebElement signUp = driver.findElement(By.id("signin2"));
        signUp.click();
        WebElement registerForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModalLabel")));
        System.out.println("Form = " + registerForm);
    }

    @And(": Register username with {string}")
    public void registerUsernameWith(String username) {
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-username")));
        usernameField.sendKeys(username);
    }

    @And(": Register password with {string}")
    public void registerPasswordWith(String password) {
        WebElement passwordField = driver.findElement(By.id("sign-password"));
        passwordField.sendKeys(password);
    }

    @When(": User click  register button")
    public void userClickRegisterButton() {
        WebElement signUpButton = driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]"));
        signUpButton.click();

    }

    @Then("User receives alert register successfull")
    public void userReceivesAlertRegisterSuccessfull() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String textAlert2 = alert.getText();
        System.out.println(textAlert2);
        alert.accept();
    }

    @And(": User see error register message")
    public void userSeeErrorRegisterMessage() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String textAlert2 = alert.getText();
        System.out.println(textAlert2);
        alert.accept();
    }
}
