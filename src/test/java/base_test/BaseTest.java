package base_test;

import driver_manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver webDriver;
    @BeforeClass
    public void setUp(){
        webDriver = DriverManager.getDriver();
    }

    @AfterClass
    public void closeDriver(){
        DriverManager.quitDriver();
    }
}