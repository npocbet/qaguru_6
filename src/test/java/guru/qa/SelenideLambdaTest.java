package guru.qa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SelenideLambdaTest {

    private static final String REPOSITORY = "npocbet/qaguru_6";
    private static final Integer ISSUE_NUMBER = 1;

    @Test
    public void testGitHub(){

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Переходим в репозиторий", () -> {
            $(By.linkText(REPOSITORY)).click();
        });

        step("Открываем таб Issues", () -> {
            $(By.partialLinkText("Issues")).click();
        });

        step("Проверяем, что существует Issue " + ISSUE_NUMBER, () -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.visible);
        });

    }

}
