package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePages {
    WebDriver driver;
    public homePages(WebDriver driver) { this.driver= driver; }
    // Locator dari home page
    By RegisterButton =By.xpath("//a[contains(@href, 'register')]");

    // Metode click register button
    public void clickRegister () { driver.findElement(RegisterButton).click(); }
}
