package stepDef;

import config.envTarget;
import pageObject.homePages;
import pageObject.namePages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class para_bankRegis extends envTarget {

    @Given("^user is on parabank homepage$")
    public void user_is_on_parabank_homepage() {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.get(regisParabank);

    wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftPanel']/h2")));
    }

    @When("^user click register link button$")
    public void user_click_register_link_button() {
        homePages homePage = new homePages(driver);
        homePage.clickRegister();

    }

    @Then("^user is in register page$")
    public void user_is_in_register_page() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Signing up is easy!')]")));
    }

    @When("^user input name$")
    public void user_input_name() {
        namePages inputName = new namePages(driver);
        inputName.inputFullData("Pedro", "November");
    }

    @And("^user input address detail$")
    public void user_input_address_detail() {
        driver.findElement(By.id("customer.address.street")).sendKeys("Anggur Hijau");
        driver.findElement(By.name("customer.address.city")).sendKeys("Jakarta");
        driver.findElement(By.id("customer.address.state")).sendKeys("DKI Bandung");
        driver.findElement(By.name("customer.address.zipCode")).sendKeys("212144");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("87363652637");
        driver.findElement(By.id("customer.ssn")).sendKeys("44433422");
    }

    @And("^user fill input username and password$")
    public void user_fill_input_username_and_password() {
        Random rand = new Random();
        int userRand = rand.nextInt(1000);
        driver.findElement(By.name("customer.username")).sendKeys("user" + userRand);
        driver.findElement(By.name("customer.password")).sendKeys("12345");
    }

    @And("^user input password confirmation$")
    public void user_input_password_confirmation() {
        driver.findElement(By.name("repeatedPassword")).sendKeys("12345");
    }

    @When("^user click register button$")
    public void user_click_register_button() {
        driver.findElement(By.xpath("//*[@class='button'][@value='Register']")).click();
    }

    @Then("^user register successfully$")
    public void user_registration_successfully() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Your account was created successfully. You are now logged in.')]"))
        );
        driver.quit();
    }
    @And("^user input invalid password confirmation$")
    public void user_input_invalid_password_confirmation() {
        driver.findElement(By.name("repeatedPassword")).sendKeys("111111");
    }

    @Then("^user get error password did not match$")
        public void user_get_error_password_did_not_match() {
            Duration duration = Duration.ofSeconds(10);
            WebDriverWait wait = new WebDriverWait(driver, duration);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Passwords did not match.')]"))
            );
            driver.quit();
    }

}


