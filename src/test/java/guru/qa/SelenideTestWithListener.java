package guru.qa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTestWithListener {

    @Test
    public void testGitHub(){
        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("npocbet/qaguru_6");
        $(".header-search-input").submit();

        $(By.linkText("npocbet/qaguru_6")).click();
        $(By.partialLinkText("Issues")).click();

        $(withText("#1")).should(Condition.visible);

    }

}
