package driver_manager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static WebDriver webDriver;

    public DriverManager(){};

    public static WebDriver getDriver(){
        String browserName = System.getProperty("browserName", "chrome");

        try {
            return getDriver(Browsers.valueOf(browserName.toUpperCase()));
        }
        catch (IllegalArgumentException e){
            System.out.println(Browsers.valueOf(browserName.toUpperCase()));
            System.out.println("Browser does not supported");
            System.out.println(-1);
        }
        return null;
    }

    public static WebDriver getDriver(Browsers browser){
        switch (browser){
            case CHROME: {
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                webDriver.manage().window().maximize();
                webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                return webDriver;
            }
            case FIREFOX: {
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                webDriver.manage().window().maximize();
                webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                return webDriver;
            }
            case SAFARI: {
                WebDriverManager.safaridriver().setup();
                webDriver = new SafariDriver();
                webDriver.manage().window().maximize();
                webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                return webDriver;
            }
        }
        return null;
    }

    public static void quitDriver(){
        if (webDriver!=null){
            webDriver.quit();
            webDriver = null;
        }
    }
}