package the_internet_tests;

import base_test.BaseTest;
import org.testng.annotations.Test;
import page_object.pages.the_internet.MainPageTheInternet;

import static com.codeborne.selenide.Selenide.open;
import static page_object.Constants.*;

public class AddRemoveElementsSingleAction extends BaseTest {

    @Test(groups = "TheInternet", description = "Add/remove elements single action")
    public void  addRemoveElementsSingleAction(){
        open(URL_THE_INTERNET);
        new MainPageTheInternet()
                .checkHomePage()
                .checkRedirectToAddRemovePage()
                .checkAddRemoveElementsPage()
                .clickToAddElementsButton()
                .clickToRemoveElementsButton();
    }
}