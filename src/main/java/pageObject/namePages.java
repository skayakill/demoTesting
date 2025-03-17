package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class namePages {
    WebDriver driver;
    public namePages(WebDriver driver) { this.driver =driver; }

    By firstnameField = By.name("customer.firstName");
    By lastnameField = By.name("customer.lastName");
    public void inputFullData(String firstName, String lastName) {
    driver.findElement(firstnameField).sendKeys(firstName);
    driver.findElement(lastnameField).sendKeys(lastName);
    }
}
