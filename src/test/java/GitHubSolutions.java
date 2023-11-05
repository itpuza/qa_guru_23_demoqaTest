import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class GitHubSolutions {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test

    void searchSolutions() {

        open(baseUrl);
        $("li").sibling(0)
                .hover();
        $("a[href='/enterprise']").click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform."));
    }

}
