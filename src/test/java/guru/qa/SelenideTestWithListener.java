package guru.qa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTestWithListener {

    @Test
    public void testGitHub(){
        open("github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("npocbet/qaguru_6");
        $(".header-search-input").click();



    }





}
