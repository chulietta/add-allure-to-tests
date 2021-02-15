package allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.visible;

public class SimpleSelenideTest {

    private static final String BASE_URL = "http://github.com";
    private final static String REPOSITORY = "chulietta/qa_guru-4_5";
    private final static String ISSUE_NAME = "Добавить тест";

    @Test
    @Owner("koronkevich")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag("web"), @Tag("critical")})
    @Link(name = "Base URL", value = BASE_URL)

    @Feature("Issues")
    @Story("Поск Issue")
    @DisplayName("Поиск Issue по названию в репозитории")

    public void simpleSelenideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open(BASE_URL);
        $(".header-search-input").setValue(REPOSITORY).pressEnter();
        $(By.linkText(REPOSITORY)).click();
        $(withText("Issues")).click();
        $(withText(ISSUE_NAME)).shouldBe(visible);
    }
}
