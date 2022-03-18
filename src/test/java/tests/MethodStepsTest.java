package tests;

import baseSteps.BaseSteps;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class MethodStepsTest {

    public BaseSteps steps = new BaseSteps();

    private final static String REPOSITORY = "chulietta/qa_guru-4_5";
    private final static String ISSUE_NAME = "Добавить тест";

    @Test
    @Owner("koronkevich")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag("web"), @Tag("critical")})

    @Feature("Issues")
    @Story("Поск Issue")
    @DisplayName("Поиск Issue по названию в репозитории (шаги с аннотацией @Step)")

    public void searchIssueByName() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        steps.openMainPage();
        steps.findRepository(REPOSITORY);
        steps.gotoRepositoryFromSearch(REPOSITORY);
        steps.gotoIssues();
        steps.issueWithNameExists(ISSUE_NAME);
    }
}
