package livexp.tests;

import livexp.helpers.DriverUtils;
import io.qameta.allure.Description;
import livexp.pages.MainPageComponents;
import livexp.pages.MainPageObjects;
import org.junit.jupiter.api.DisplayName;
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