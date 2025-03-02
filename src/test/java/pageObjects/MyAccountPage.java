package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//h2[normalize-space()='My Account']") private WebElement myAccount;

    public boolean isMyAccountExist(){
        boolean isMyAccExist = myAccount.isDisplayed();
        return isMyAccExist;
    }
}
