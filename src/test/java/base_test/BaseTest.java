package base_test;

import com.codeborne.selenide.WebDriverRunner;
import driver_manager.SetUp;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void setUp() {
        SetUp.setUp();
    }

    @AfterMethod
    public void tearDown(){
        WebDriverRunner.closeWebDriver();
    }
}