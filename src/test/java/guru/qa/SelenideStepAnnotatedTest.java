package guru.qa;

import guru.qa.steps.WebSteps;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SelenideStepAnnotatedTest {
    private static final String REPOSITORY = "npocbet/qaguru_6";
    private static final Integer ISSUE_NUMBER = 1;

    private WebSteps steps = new WebSteps();

    @Test
    @Owner("npocbet(kravtsovsv)")
    @DisplayName("Тест гитхаба, Issues в репозитории. Шаги с аннотацией @Step")
    public void testGitHub(){
        steps.openMainPage();
        steps.searchRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
