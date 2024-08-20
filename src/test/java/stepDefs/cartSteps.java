package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class cartSteps {
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

    @Given("User is on the homepage")
    public void userIsOnTheHomepage() {
        driver.get("https://www.demoblaze.com");
    }

    @When("User clicks on product {int}")
    public void userClicksOnProduct(int arg0) {
        WebElement product1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")));
        product1.click();
    }

    @And("User adds that item to the cart")
    public void userAddsThatItemToTheCart() {
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")));
        addToCartButton.click();
    }

    @And("User receives an alert")
    public void userReceivesAnAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String textAlert = alert.getText();
        System.out.println(textAlert);
        alert.accept();
    }

    @And("User goes back to the homepage")
    public void userGoesBackToTheHomepage() {
        WebElement homepage = wait.until(ExpectedConditions.elementToBeClickable(By.id("nava")));
        homepage.click();
    }

    @Then("User goes to the cart page")
    public void userGoesToTheCartPage() {
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur")));
        cart.click();

    }
    @When("User adds items to the cart")
    public void userAddsItemsToTheCart() {
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")));
        addToCartButton.click();
    }

    @When("User deletes {int} item from the cart")
    public void userDeletesItemFromTheCart(int arg0) {
        WebElement deleteItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tbodyid\"]/tr/td[4]/a")));
        deleteItem.click();
    }

    @And("The item should be removed from the cart")
    public void theItemShouldBeRemovedFromTheCart() {
        By deleteButton = By.xpath("//*[@id='tbodyid']/tr/td[4]/a");

        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(deleteButton));
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }
}
