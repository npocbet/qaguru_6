package guru.qa;

import com.codeborne.selenide.Condition;
import guru.qa.steps.WebSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SelenideLambdaTest {

    private static final String REPOSITORY = "npocbet/qaguru_6";
    private static final Integer ISSUE_NUMBER = 1;
    private WebSteps s = new WebSteps();

    @Test
    @Owner("npocbet(kravtsovsv)")
    @Feature("Авторизация?")
    @Story("Авторизация через Email?")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Тест гитхаба, Issues в репозитории. Лямбда шаги через step (name, () -> {})")
    @Link(name = "Github", url = "https://github.com")
    public void testGitHub(){
        AllureLifecycle lifecycle = Allure.getLifecycle();

        // эквивалентно @DisplayName
        // Allure.getLifecycle().updateTestCase(testCase -> {
        //      estCase.setName("Тест гитхаба, Issues в репозитории. Лямбда шаги через step (name, () -> {})");
        // });
        // эквивалентно owner
        // Allure.label("owner", "npocbet(kravtsovsv)");
        // эквивалентно Feature
        // Allure.feature("Авторизация?");
        // эквивалентно Story
        // Allure.story("Авторизация через Email?");
        // эквивалентно Severity
        // Allure.label("severity", "BLOCKER");
        // эквивалентно Link
        //Allure.link("Github", "https://github.com");




        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
            lifecycle.addAttachment("Screenshot", "image/png", "png", s.getScreenshot());
        });

        step("Переходим в репозиторий", () -> {
            $(By.linkText(REPOSITORY)).click();
        });

        step("Открываем таб Issues", () -> {
            $(By.partialLinkText("Issues")).click();
            lifecycle.addAttachment("Screenshot", "image/png", "png", s.getScreenshot());
        });

        step("Проверяем, что существует Issue " + ISSUE_NUMBER, () -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.visible);
        });

    }

}
