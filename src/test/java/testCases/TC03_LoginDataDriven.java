package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC02_LoginDataDriven extends BaseClass {
    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void logInMultipleAccs(String username, String pw, String expect) {
        try {
            logger.info("******TC02_LoginDataDriven STARTED******");
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();
            logger.info("Clicked Login");

            LoginPage loginPage = new LoginPage(driver);
            loginPage.setEmail(username);
            loginPage.setPassword(pw);
            loginPage.clickLogin();
            logger.info("Filled login info");

            MyAccountPage myAccountPage = new MyAccountPage(driver);
            boolean isAccountHeaderExist = myAccountPage.isMyAccountExist();

            if (expect.equalsIgnoreCase("Login successfully")) {
                if (isAccountHeaderExist) {
                    logger.info("Login successfully");
                    myAccountPage.clickLogout();
                    Assert.assertTrue(true);
                } else {
                    logger.error("Valid data but login unsuccessfully");
                    Assert.fail();
                }
            }
            if (expect.equalsIgnoreCase("Login unsuccessfully")) {
                if (isAccountHeaderExist) {
                    logger.error("Invalid data but login successfully");
                    myAccountPage.clickLogout();
                    Assert.fail();
                } else {
                    logger.info("Login unsuccessfully");
                    Assert.assertTrue(true);
                }
            }
        } catch (Exception e) {
            logger.error("Exception: " + e.getMessage());
            Assert.fail();
        } finally {
            logger.info("****FINISHED****");
        }
    }

}
