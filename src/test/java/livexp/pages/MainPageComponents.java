package livexp.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageComponents {

    @Step("Open main page")
    public MainPageComponents openMainPage() {
        open("");
        return this;
    }

    @Step("Click 'Все языки' button")
    public MainPageComponents clickAllLanguages() {
        SelenideElement allLanguagesButton = $("div nav div:nth-child(1) > a span");
        allLanguagesButton.click();
        return this;
    }

}
