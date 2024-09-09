package page_object.pages.the_internet;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import page_object.locators.the_intennet.MainPageLocatorsTheInternet;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;
import static page_object.Constants.*;

public class MainPageTheInternet {

    @Step("Check that homePage is displayed")
    public MainPageTheInternet checkHomePage() {
        assertEquals(WebDriverRunner.url(), URL_THE_INTERNET);
        $(MainPageLocatorsTheInternet.MAIN_TITLE_TEXT)
                .shouldBe(visible);
        assertEquals($(MainPageLocatorsTheInternet.MAIN_TITLE_TEXT).getText(), THE_INTERNET_MAIN_PAGE);
        $(MainPageLocatorsTheInternet.LIST_OF_FUNCTIONS)
                .shouldBe(visible);
        assertEquals($(MainPageLocatorsTheInternet.LIST_OF_FUNCTIONS).getText(), THE_INTERNET_LIST_OF_FUNCTIONS);
        return this;
    }

    @Step("Check redirection to add/remove element page")
    public AddRemoveElementsPage checkRedirectToAddRemovePage() {
        $(MainPageLocatorsTheInternet.ADD_REMOVE_ELEMENTS_REDIRECT)
                .shouldBe(visible);
        $(MainPageLocatorsTheInternet.ADD_REMOVE_ELEMENTS_REDIRECT)
                .click();
        return new AddRemoveElementsPage();
    }
}