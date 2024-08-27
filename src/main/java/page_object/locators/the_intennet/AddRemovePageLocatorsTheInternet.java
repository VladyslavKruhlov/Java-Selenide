package page_object.locators.the_intennet;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AddRemovePageLocatorsTheInternet {
    public static final SelenideElement ADD_REMOVE_PAGE_TITLE_TEXT = $x("//h3[text()='Add/Remove Elements']");
    public static final SelenideElement ADD_ELEMENT_BUTTON = $x("//button[@onclick='addElement()' and text()='Add Element']");
    public static final SelenideElement REMOVE_ELEMENT_BUTTON = $x("//button[@onclick='deleteElement()' and text()='Delete']");
    public static final String REMOVE_BUTTON_FOR_MASS_ACTION = "(//button[@onclick='deleteElement()' and text()='Delete'])";
}