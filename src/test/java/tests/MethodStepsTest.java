package tests;

import baseSteps.BaseSteps;
import io.qameta.allure.*;
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
    @DisplayName("Поиск Issue по названию в репозитории")

    public void searchIssueWithName() {
        steps.openMainPage();
        steps.findRepositiry(REPOSITORY);
        steps.gotoRepositoryFromSearch(REPOSITORY);
        steps.gotoIssues();
        steps.issueWithNameExists(ISSUE_NAME);
    }
}
