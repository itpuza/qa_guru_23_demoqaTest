import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class DemoqaTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;


    }
        @Test
        void successfulSearchTest() {
            open("/automation-practice-form");
            $("#firstName").setValue("Pasha");
            $("#lastName").setValue("Technique");
            $("#userEmail").setValue("Technique@mail.com");
            $("#genterWrapper").$(byText("Male")).click();
            $("#userNumber").setValue("1111111111");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__year-select").selectOption("1993");
            $(".react-datepicker__month-select").selectOption("January");
            $(".react-datepicker__day--023:not(.react-datepicker__day--outside-month)").click();
            $("#subjectsInput").val("Economics").pressEnter();;
            $("#hobbiesWrapper").$(byText("Sports")).click();
            $("#uploadPicture").uploadFromClasspath("123.jpeg");
            $("#currentAddress").setValue("Moscow");
            $("#react-select-3-input").val("Haryana").pressEnter();
            $("#react-select-4-input").val("Panipat").pressEnter();
            $("#submit").pressEnter();


            $(".table-responsive").shouldHave(text( "Pasha Technique"));
            $(".table-responsive").shouldHave(text("Male"));
            $(".table-responsive").shouldHave(text("1111111111"));
            $(".table-responsive").shouldHave(text("23 January,1993"));
            $(".table-responsive").shouldHave(text("Economics"));
            $(".table-responsive").shouldHave(text("Sports"));
            $(".table-responsive").shouldHave(text("123.jpeg"));
            $(".table-responsive").shouldHave(text("Haryana Panipat"));


        }

    }


