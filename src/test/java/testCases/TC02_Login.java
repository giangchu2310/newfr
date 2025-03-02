package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC02_Login extends BaseClass {

    @Test
    public void loginSuccess() {
        try {
            logger.info("******TC02_Login STARTED******");
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();
            logger.info("Clicked Login");

            LoginPage loginPage = new LoginPage(driver);
            loginPage.setEmail(properties.getProperty("username"));
            loginPage.setPassword(properties.getProperty("pw"));
            loginPage.clickLogin();
            logger.info("Filled login info");

            MyAccountPage myAccountPage = new MyAccountPage(driver);
            if (myAccountPage.isMyAccountExist()) {
                logger.info("Login successfully");
                Assert.assertTrue(true);
            } else {
                logger.error("Login failed");
                Assert.fail();
            }

        } catch (Exception e) {
            logger.error("Login failed with exception");
            Assert.fail();
        } finally {
            logger.info("******TC02_Login ENDED******");
        }


    }

}
