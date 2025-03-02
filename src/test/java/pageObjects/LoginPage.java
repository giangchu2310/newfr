package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//input[@id='input-email']") private WebElement email;
    @FindBy(xpath="//input[@id='input-password']") private WebElement password;
    @FindBy(xpath="//input[@value='Login']") private WebElement loginBtn;

    public void setEmail(String emailVal){
        email.sendKeys(emailVal);
    }

    public void setPassword(String pwVal){
        password.sendKeys(pwVal);
    }

    public void clickLogin(){
        loginBtn.click();
    }
}
