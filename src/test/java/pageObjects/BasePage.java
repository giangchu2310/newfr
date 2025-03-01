package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//BasePage: Contain constructor which is applied to all Page object class
public class BasePage {
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
