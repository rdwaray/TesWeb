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


public class boundarySteps {

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


    @Given(": User is on register page")
    public void userIsOnRegisterPage() {
        driver.get("https://www.demoblaze.com");
        WebElement signUp = driver.findElement(By.id("signin2"));
        signUp.click();
        WebElement registerForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModalLabel")));
        System.out.println("Form = " + registerForm);
    }


    @When(": User click on register button")
    public void userClickOnRegisterButton() {
        WebElement signButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")));
        signButton.click();
    }

    @Then(": User get alert")
    public void userGetAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String textAlert2 = alert.getText();
        System.out.println(textAlert2);
        alert.accept();
    }

    @And(": User input boundary username with {string}")
    public void userInputBoundaryUsernameWith(String username) {
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-username")));
        usernameField.sendKeys(username);
    }

    @And(": User input boundary password with {string}")
    public void userInputBoundaryPasswordWith(String password) {
        WebElement passwordField = driver.findElement(By.id("sign-password"));
        passwordField.sendKeys(password);
    }
}
