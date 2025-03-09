package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    private WebElement myAccountHeading;
    @FindBy(xpath = "//div[@class='list-group']//a[contains(text(),'Logout')]")
    private WebElement logoutBtn;

    public boolean isMyAccountExist() {
        try {
            boolean isMyAccExist = myAccountHeading.isDisplayed();
            return isMyAccExist;
        } catch (Exception e){
            return false;
        }

    }

    public void clickLogout() {
        logoutBtn.click();
    }
}
