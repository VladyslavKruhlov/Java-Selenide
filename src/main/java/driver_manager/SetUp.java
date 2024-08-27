package driver_manager;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class SetUp {

    static String browserForJenkins = System.getenv("BROWSER");

    public static void setUp(Browsers browser) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.browserCapabilities = capabilities;
        Configuration.browserSize = "1920x1008";
        Configuration.browserPosition = "1x1";
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 60000;
        Configuration.browser = null;

        if (browserForJenkins != null) {
            Configuration.browser = browserForJenkins;
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

    public static WebDriver setUp() {
        String browserName = System.getProperty("browserName", "chrome");

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
