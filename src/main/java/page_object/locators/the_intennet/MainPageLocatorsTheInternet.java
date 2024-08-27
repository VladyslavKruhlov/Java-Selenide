package page_object.locators.the_intennet;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;

public class MainPageLocatorsTheInternet {
    public static final SelenideElement MAIN_TITLE_TEXT = $x("//*[@class='heading' and text()='Welcome to the-internet']");
    public static final SelenideElement LIST_OF_FUNCTIONS = $x("//h2[text()='Available Examples']");
    public static final SelenideElement ADD_REMOVE_ELEMENTS_REDIRECT = $x("//*[text()='Add/Remove Elements' and @href='/add_remove_elements/']");
}