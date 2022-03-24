package livexp.tests;

import livexp.helpers.DriverUtils;
import io.qameta.allure.Description;
import livexp.pages.MainPageComponents;
import livexp.pages.MainPageObjects;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class MainPageTests extends TestBase {

    MainPageObjects mainPageObjects = new MainPageObjects();
    MainPageComponents mainPageComponents  = new MainPageComponents ();

    String languageEng = "Английский";
    String languageDu = "Немецкий";
    String languageOldRu = "Старорусский";

    @Test
    @Tag("Search")
    @Description("Languages search checks")
    @DisplayName("English language search")
    void searchForAEnglish() {
        mainPageComponents
                .openMainPage()
                .clickAllLanguages();
        mainPageObjects
                .setLanguage(languageEng)
                .checkLanguageBlock(languageEng);
    }

    @Test
    @Tag("Search")
    @Description("Languages search checks")
    @DisplayName("Dutch language search")
    void searchForADutch() {
        mainPageComponents
                .openMainPage()
                .clickAllLanguages();
        mainPageObjects
                .setLanguage(languageDu)
                .checkLanguageBlock(languageDu);
    }

    @Test
    @Tag("Search")
    @Description("Languages search checks")
    @DisplayName("Old Russian language search")
    void searchForAOldRussian() {
        mainPageComponents
                .openMainPage()
                .clickAllLanguages();
        mainPageObjects
                .setLanguage(languageOldRu)
                .checkLanguageBlock(languageOldRu);
    }

    @Test
    @Tag("Main")
    @Description("Blog page")
    @DisplayName("Blog title check")
    void blogTitleCheck() {
        mainPageComponents
                .openMainPage()
                .clickBlog()
                .switchTab()
                .blogTitleCheck();
    }

    @Test
    @Tag("Main")
    @Description("App visibility")
    @DisplayName("App visibility in the Google Play")
    void googleAppDownload() {
        mainPageComponents
                .openMainPage()
                .clickApp()
                .googlePlayLink()
                .switchTab()
                .appCheckGoogle();
    }

    @Test
    @Tag("Main")
    @Description("App visibility")
    @DisplayName("App visibility in the AppStore")
    void appleAppDownload() {
        mainPageComponents
                .openMainPage()
                .clickApp()
                .appstoreLink()
                .switchTab()
                .appCheckAppStore();
    }


    @Test
    @Tag("Main")
    @Description("Page title test")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://livexp.com/ru'", () ->
            open("https://livexp.com/ru"));

        step("Page title should have text 'LiveXP: Изучайте языки онлайн с Лучшими Преподавателями'", () -> {
            String expectedTitle = "LiveXP: Изучайте языки онлайн с Лучшими Преподавателями";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Tag("Main")
    @Description("Page console test")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://livexp.com/ru'", () ->
            open("https://livexp.com/ru"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}