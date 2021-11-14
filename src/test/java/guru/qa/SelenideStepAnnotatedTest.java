package guru.qa;

import guru.qa.steps.WebSteps;
import org.junit.jupiter.api.Test;

public class SelenideStepAnnotatedTest {
    private static final String REPOSITORY = "npocbet/qaguru_6";
    private static final Integer ISSUE_NUMBER = 1;

    private WebSteps steps = new WebSteps();

    @Test
    public void testGitHub(){
        steps.openMainPage();
        steps.searchRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
