package page_object.pages.the_internet;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebElement;
import page_object.locators.the_intennet.AddRemovePageLocatorsTheInternet;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.*;
import static page_object.Constants.*;
import static page_object.locators.the_intennet.AddRemovePageLocatorsTheInternet.*;

public class AddRemoveElementsPage {
    public AddRemoveElementsPage checkAddRemoveElementsPage(){
        assertEquals(WebDriverRunner.url() , URL_THE_INTERNET_AFTER_REDIRECTION);
        $(AddRemovePageLocatorsTheInternet.ADD_REMOVE_PAGE_TITLE_TEXT).shouldBe(visible);
        assertEquals($(AddRemovePageLocatorsTheInternet.ADD_REMOVE_PAGE_TITLE_TEXT).getText(), THE_INTERNET_ADD_REMOVE_PAGE_TITLE);
        return this;
    }

    public AddRemoveElementsPage checkCountOfRemovedElementsAfterRemoving(){
        boolean removeElementsFound = ($(REMOVE_ELEMENT_BUTTON).exists());
        assertFalse(removeElementsFound);
        return this;
    }

    public AddRemoveElementsPage addAndRemoveElements(int i){
        clickToAddElementsButton(i);
        checkCountOfRemovedElements(i);
        clickToRemoveElementsButton(i);
        return this;
    }

    private AddRemoveElementsPage clickToAddElementsButton(int n){
        $(AddRemovePageLocatorsTheInternet.ADD_ELEMENT_BUTTON)
                .shouldBe(visible);
        assertEquals($(AddRemovePageLocatorsTheInternet.ADD_ELEMENT_BUTTON).getText(), ADD_ELEMENT_BUTTON_TITLE);

        for (int i=1; i<=n; i++){
            $(AddRemovePageLocatorsTheInternet.ADD_ELEMENT_BUTTON)
                    .click();
        }
        return this;
    }

    private AddRemoveElementsPage checkCountOfRemovedElements(int n){
        List<WebElement> removedElements = new ArrayList<>();
        for (int i=1; i<=n; i++){
            $(gerDeleteButtonLocators("["+n+"]"))
                    .shouldBe(visible);
            removedElements.add($(gerDeleteButtonLocators("["+n+"]")));
        }
        assertEquals(removedElements.size(), n);
        return this;
    }

    private SelenideElement gerDeleteButtonLocators(String string){
        return $x(REMOVE_BUTTON_FOR_MASS_ACTION + string);
    }

    private AddRemoveElementsPage clickToRemoveElementsButton(int n){
        for (int i=n; i>=1; i--){
            $(gerDeleteButtonLocators("["+i+"]"))
                    .shouldBe(visible);
            assertEquals($(gerDeleteButtonLocators("["+i+"]")).getText(), DELETE_ELEMENT_BUTTON_TITLE);
            $(gerDeleteButtonLocators("["+i+"]"))
                    .click();
        }
        return this;
    }

    public AddRemoveElementsPage clickToAddElementsButton(){
        $(AddRemovePageLocatorsTheInternet.ADD_ELEMENT_BUTTON)
                .shouldBe(visible);
        assertEquals($(AddRemovePageLocatorsTheInternet.ADD_ELEMENT_BUTTON).getText(), ADD_ELEMENT_BUTTON_TITLE);
        $(AddRemovePageLocatorsTheInternet.ADD_ELEMENT_BUTTON)
                .click();
        return this;
    }

    public AddRemoveElementsPage clickToRemoveElementsButton(){
        $(AddRemovePageLocatorsTheInternet.REMOVE_ELEMENT_BUTTON)
                .shouldBe(visible);
        assertEquals(AddRemovePageLocatorsTheInternet.REMOVE_ELEMENT_BUTTON.getText(), DELETE_ELEMENT_BUTTON_TITLE);
        $(AddRemovePageLocatorsTheInternet.REMOVE_ELEMENT_BUTTON)
                .click();
        return this;
    }
}