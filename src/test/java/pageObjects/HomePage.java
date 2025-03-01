package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//a[@title='My Account']") private WebElement myAccountBtn;
    @FindBy(xpath="//a[normalize-space()='Register']") private WebElement registerBtn;

    public void clickMyAccount(){
        myAccountBtn.click();
    }

    public void clickRegister(){
        registerBtn.click();
    }
}
