package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest {

    private static final String BASE_URL = "http://github.com";
    private final static String REPOSITORY = "chulietta/qa_guru-4_5";
    private static final String ISSUES = "Issues";
    private final static String ISSUE_NAME = "Добавить тест";

    @Test
    @Owner("koronkevich")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag("web"), @Tag("critical")})
    @Link(name = "Base URL", value = BASE_URL)

    @Feature("Issues")
    @Story("Поск Issue")
    @DisplayName("Поиск Issue по названию в репозитории")

    public void searchIsseuByname() {
        parameter("Repository", REPOSITORY);
        parameter("Issue name", ISSUE_NAME);

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу", () -> {
            open(BASE_URL);
        });
        step("Найти репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").setValue(REPOSITORY).pressEnter();
        });
        step("Перейти в репозиторий " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Перейти в раздел " + ISSUES, () -> {
            $(withText(ISSUES)).click();
        });
        step("Найти Issue с именем " + ISSUE_NAME, () -> {
            $(withText(ISSUE_NAME)).shouldBe(visible);
        });
    }
}
