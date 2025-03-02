package testBase;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Parameters;

//BaseClass: Contain common methods of TC class
public class BaseClass {
    public WebDriver driver;
    public Logger logger; //because logs will be generated every time a test case run --> place in BaseClass
    public Properties properties;

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String br) throws IOException {
        //Load Properties file
        FileReader file = new FileReader(".//src//test//resources//config.properties");
        properties = new Properties();
        properties.load(file);

        //Set up to record logs when executing test case
        logger = LogManager.getLogger(this.getClass());
        //From which class we want to generate the log?
        //'this.getClass()' gets class name dynamically because we run multiple test cases in multiple classes

        //Run tc based on param passed in xml file
        switch (br.toLowerCase()){
            case "chrome": driver = new ChromeDriver(); break;
            case "edge": driver = new EdgeDriver(); break;
            case "firefox": driver = new FirefoxDriver(); break;
            default: System.out.println("Invalid browser"); return;
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.get(properties.getProperty("appURL"));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
