package stepDef;

import config.envTarget;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginBdd extends envTarget {
    @Given("user is on login page")
    public void user_is_on_login_page() {
        // Set chrome driver and set Url manage size
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit'][@data-test='login-button']"))
        );
    }
    @When("user fill username and password")
    public void user_fill_username_and_password() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }
    @When("user click login button")
    public void user_click_login_button() {
        driver.findElement(By.xpath("//input[@type='submit'][@data-test='login-button']")).click();
    }
    @Then("user verify login result")
    public void user_verify_login_result() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title'][contains(text(), 'Products')]"))
        );
        driver.quit();
    }
    @When("user fill invalid username and password")
    public void user_fill_invalid_username_and_password() {
        driver.findElement(By.name("user-name")).sendKeys("standard_sauce");
        driver.findElement(By.id("password")).sendKeys("12345");
    }
    @When("user get message error")
    public void user_get_message_error() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3/button"))
        );
        driver.quit();
    }
    @When("^user input (.*) and (.*)$")
    public void user_fill_username_and_password(String username, String password) {
        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }
    @Then("^user get verify login (.*)$")
    public void user_get_verify_login_result_tdd(String result) {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        if (result == "Passed") {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title'][contains(text(),'Products')]"))
            ));
        } else if (result == "Failed") {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.className("error-button"))
            ));
        }
        driver.quit();
    }
}
