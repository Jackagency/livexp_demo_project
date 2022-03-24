package livexp.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Configuration.browser;
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

    @Step("Click 'Блог' button")
    public MainPageComponents clickBlog() {
        SelenideElement allLanguagesButton = $("div nav div:nth-child(2) > a span");
        allLanguagesButton.click();
        return this;
    }

    @Step("Click App button")
    public MainPageComponents clickApp() {
        SelenideElement appButton = $(".HeaderRightGuest_root__Gzgry > button > span.Button_startIcon__y_Rjx");
        appButton.click();
        return this;
    }

    @Step("Blog title check")
    public MainPageComponents blogTitleCheck() {
        SelenideElement blogTitle = $("div.c-archive > h1");
        blogTitle.click();
        return this;
    }

    @Step("Click Google Play link")
    public MainPageComponents googlePlayLink() {
        SelenideElement googlePlayLink = $(".MobileAppPromoModal_link__2Mt_d > span > img", 1);
        googlePlayLink.click();
        return this;
    }

    @Step("Click AppStore link")
    public MainPageComponents appstoreLink() {
        SelenideElement appstoreLink = $(".MobileAppPromoModal_link__2Mt_d > span > img", 0);
        appstoreLink.click();
        return this;
    }

    @Step("Switch to a new tab")
    public MainPageComponents switchTab() {
        Selenide.switchTo().window(1);
        return this;
    }

    @Step("Check the App in the Google Play")
    public MainPageComponents appCheckGoogle() {
        SelenideElement app = $("c-wiz:nth-child(1) > h1 > span");
        app.shouldHave(Condition.text("LiveXP: Изучение Языков"));
        return this;
    }

    @Step("Check the App in the AppStore")
    public MainPageComponents appCheckAppStore() {
        SelenideElement app = $("div.l-column > header > h1");
        app.shouldHave(Condition.text("LiveXP: Language Learning"));
        return this;
    }

}
