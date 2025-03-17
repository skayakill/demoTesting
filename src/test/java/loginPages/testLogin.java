package loginPages;

import config.envTarget;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class testLogin extends envTarget {
    @Test
    public void main() {
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
        driver.findElement(By.xpath("//input[@type='text'][@data-test='username']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@type='password'][@data-test='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit'][@data-test='login-button']")).click();
        wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title'][contains(text(), 'Products')]"))
        );
        driver.quit();
    }
    @Test
    public void Invalidlogin() {
        // Set chrome driver and set Url manage size
        System.setProperty("web driver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit'][@data-test='login-button']"))
        );
        driver.findElement(By.xpath("//input[@type='text'][@data-test='username']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@type='password'][@data-test='password']")).sendKeys("213567");
        driver.findElement(By.xpath("//input[@type='submit'][@data-test='login-button']")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"))
        );
        driver.quit();

    }

}
