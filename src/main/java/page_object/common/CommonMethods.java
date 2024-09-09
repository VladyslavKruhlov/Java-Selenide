package page_object.common;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class CommonMethods {

    @Step("Open page: {url}")
    public static void openPage(String url) {
        open(url);
    }
}