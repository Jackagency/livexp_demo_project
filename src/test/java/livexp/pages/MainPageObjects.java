package livexp.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainPageObjects {
    //locators

    SelenideElement searchField = $(".Input_input__WSVhI");
    SelenideElement languageBlock = $(".CategoryThumbDesktop_root__exzGr > span");


    //actions

    @Step("Set language")
    public MainPageObjects setLanguage(String value) {
        searchField.setValue(value);
        return this;
    }

    @Step("Check search results")
    public MainPageObjects checkLanguageBlock(String value) {
        languageBlock.shouldHave(Condition.text(value));
        return this;
    }
}
