package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pageObjects.HomePage;
import pageObjects.RegisterAccountPage;
import testBase.BaseClass;

import java.time.Duration;

public class TC01_VerifyRegisterAccount extends BaseClass{

    @Test
    public void registerAccSuccess() {

        try{
            logger.info("******TC01_VerifyRegisterAccount STARTED******");
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            logger.info("Clicked on My account");
            homePage.clickRegister();
            logger.info("Clicked on Register");

            RegisterAccountPage registerPage = new RegisterAccountPage(driver);
            registerPage.setFirstName("Giang");
            registerPage.setLastName("Chu");
            registerPage.setEmail("giang.908"+"@gmail.com");
            registerPage.setTelephone("0934345435");
            String pw = "abc4123";
            registerPage.setPassword(pw);
            registerPage.setConfirmPw(pw);
            logger.info("Filled in information");
            registerPage.tickAgreeBox();
            registerPage.clickContinue();
            logger.info("Click on continue");

            if(registerPage.getMsg().equals("Your Account Has Been Created!")){
                //log statement placed before Assert
                logger.info("TC01_VerifyRegisterAccount PASSED");
                Assert.assertTrue(true); //Hard assertion,if put log statement below Assert true statement -> Still execute
            } else {
                logger.error("TC01_VerifyRegisterAccount FAILED");
                Assert.fail(); //Hard assertion,if put log statement below Assert fail statement -> Wont execute
            }
        }catch (Exception e ){
            logger.error("Error logs..... ");
            logger.debug("Debug logs.....");
            Assert.fail(); //Hard assertion,if put log statement below Assert fail statement -> Wont execute
        } finally { //Always execute no matter the tc gets failed or passed
            logger.info("******TC01_VerifyRegisterAccount FINISHED******");
        }

    }

}
