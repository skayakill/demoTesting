package loginPages;
import config.envTarget;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class oranghrmDemo extends envTarget {
    @Test
    public void main() {
        // Set chrome driver and set Url manage size
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(orangeHrm);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit'][@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"))
        );
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit'][@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
        driver.quit();
    }
}
