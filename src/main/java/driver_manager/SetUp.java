package driver_manager;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class SetUp {
    static String browserForJenkins = System.getProperty("browser", "chrome");
    static String selenoidUrl = System.getProperty("selenoidUrl");

    public static void setUp(Browsers browser) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.browserCapabilities = capabilities;
        Configuration.browserSize = "1920x1008";
        Configuration.browserPosition = "1x1";
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 60000;
        Configuration.downloadsFolder = "src/test/resources";
        Configuration.browser = null;
        Configuration.remote = selenoidUrl;

        if (selenoidUrl != null) {
            switch (browser) {
                case CHROME: {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setCapability("selenoid:options", getSelenoidOption());
                    Configuration.browserCapabilities = chromeOptions;
                    Configuration.browser = "chrome";
                    return;
                }
                case FIREFOX: {
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setCapability("selenoid:options", getSelenoidOption());
                    firefoxOptions.addArguments("--user-agent=hillel_autotest");
                    Configuration.browserCapabilities = firefoxOptions;
                    Configuration.browser = "firefox";
                    return;
                }
                default: throw new IllegalStateException("Wrong value: " + browser);
            }
            } else {
                switch (browser) {
                    case CHROME: {
                        Configuration.browser = "chrome";
                        return;
                    }
                    case FIREFOX: {
                        Configuration.browser = "firefox";
                        return;
                    }
                    case SAFARI: {
                        Configuration.browser = "safari";
                    }
                    default: throw new IllegalStateException("Wrong value: " + browser);
                }
            }
        }

    private static Map<String, Object> getSelenoidOption(){
        Map<String, Object> selenoidOption = new HashMap<>();
        selenoidOption.put("enableVNC", true);
        selenoidOption.put("enableVideo", true);
        selenoidOption.put("sessionTimeout", "5m");
        return selenoidOption;
    }

    public static WebDriver setUp() {
        String browserName = System.getProperty("browserName", browserForJenkins);

        try {
            setUp(Browsers.valueOf(browserName.toUpperCase()));
        }
        catch (IllegalArgumentException e){
            System.out.println(Browsers.valueOf(browserName.toUpperCase()));
            System.out.println("Browser does not supported");
            System.out.println(-1);
        }
        return null;
    }

    public static void quitDriver(){
        closeWebDriver();
    }
}
