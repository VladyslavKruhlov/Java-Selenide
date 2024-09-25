package the_internet_tests;

import base_test.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import page_object.pages.the_internet.MainPageTheInternet;

import static page_object.Constants.*;
import static page_object.common.CommonMethods.openPage;

public class AddRemoveElementsMassAction extends BaseTest {
    @Test(groups = "TheInternet", description = "Add/remove elements mass action")
    @Owner("v.kruhlov")
    @Description("Check that add elements button works and after check that delete button works")
    @Severity(SeverityLevel.NORMAL)
    @Epic("UI")
    @Feature("Add/Delete elements")
    @Story("Buttons")
    @Link(name = "Website", url = "https://the-internet.herokuapp.com/add_remove_elements/")
    public void  addRemoveElementsMassAction(){
        openPage(URL_THE_INTERNET);
        new MainPageTheInternet()
                .checkHomePage()
                .checkRedirectToAddRemovePage()
                .checkAddRemoveElementsPage()
                .addAndRemoveElements(3)
                .checkCountOfRemovedElementsAfterRemoving();
    }
}