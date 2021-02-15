package baseSteps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {

    private static final String BASE_URL = "http://github.com";

    @Step("Открыть главную страницу")
    public void openMainPage() {
        open(BASE_URL);
    }

    @Step("Найти репозиторий {repository}")
    public void findRepositiry(final String repository) {
        $(".header-search-input").setValue(repository).pressEnter();
    }

    @Step("Перейти в репозиторий {repository}")
    public void gotoRepositoryFromSearch(final String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Перейти в раздел Issues")
    public void gotoIssues() {
        $(withText("Issues")).click();
    }

    @Step("Найти Issue с именем {name}")
    public void issueWithNameExists(final String name) {
        $(withText(name)).shouldBe(visible);
    }
}
