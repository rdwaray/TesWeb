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

public class loginSteps {

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
    @Given("User in on login form")
    public void userInOnLoginForm() {
        driver.get("https://www.demoblaze.com/");
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
        WebElement loginForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModalLabel")));
        System.out.println("Form = " + loginForm);
        loginButton.click();
    }

    @When(": User click on login button")
    public void userClickOnLoginButton() {
        WebElement loginSubmitButton = driver.findElement(By.cssSelector("#logInModal .btn-primary"));
        loginSubmitButton.click();
    }

    @Then(": User is on homepage")
    public void userIsOnHomepage() {
        String title = driver.getTitle();
        System.out.println(title);
    }



    @And(": User see error message")
    public void userSeeErrorMessage() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String textAlert = alert.getText();
        System.out.println(textAlert);
        alert.accept();
    }

    @Given("User is on the login form")
    public void userIsOnTheLoginForm() {
        driver.get("https://www.demoblaze.com/");
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
        WebElement loginForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModalLabel")));
        System.out.println("Form = " + loginForm);
        loginButton.click();
    }

    @Then(": User back to login form")
    public void userBackToLoginForm() {
        WebElement loginForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModalLabel")));
        System.out.println(loginForm);
    }

    @And(": User input correct username with {string}")
    public void userInputCorrectUsernameWith(String username) {
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginusername")));
        usernameField.sendKeys(username);
    }

    @And(": User input incorrect username with {string}")
    public void userInputIncorrectUsernameWith(String username) {
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginusername")));
        usernameField.sendKeys(username);
    }

    @And(": User input correct password with {string}")
    public void userInputCorrectPasswordWith(String password) {
        WebElement passwordField = driver.findElement(By.id("loginpassword"));
        passwordField.sendKeys(password);
    }

    @And(": User input incorrect password with {string}")
    public void userInputIncorrectPasswordWith(String password) {
        WebElement passwordField = driver.findElement(By.id("loginpassword"));
        passwordField.sendKeys(password);
    }
}
