package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterAccountPage extends BasePage {

    public RegisterAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-firstname']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@id='input-lastname']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement email;
    @FindBy(xpath = "//input[@id='input-telephone']")
    private WebElement telephone;
    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement password;
    @FindBy(xpath = "//input[@id='input-confirm']")
    private WebElement confirmPw;
    @FindBy(xpath = "//input[@name='agree']")
    private WebElement agreeBox;
    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueBtn;
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    private WebElement msgSuccess;

    public void setFirstName(String firstNameVal) {
        firstName.sendKeys(firstNameVal);
    }

    public void setLastName(String lastNameVal) {
        lastName.sendKeys(lastNameVal);
    }

    public void setEmail(String emailVal) {
        email.sendKeys(emailVal);
    }

    public void setTelephone(String phoneVal) {
        telephone.sendKeys(phoneVal);
    }

    public void setPassword(String pwVal) {
        password.sendKeys(pwVal);
    }

    public void setConfirmPw(String confirmPwVal) {
        confirmPw.sendKeys(confirmPwVal);
    }

    public void tickAgreeBox() {
        agreeBox.click();
    }

    public void clickContinue() {
        continueBtn.click();

    }

    public String getMsg() {
        try {
            String msg = msgSuccess.getText();
            return msg;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
