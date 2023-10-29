import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
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
            $("[id=firstName]").setValue("Pasha");
            $("[id=lastName]").setValue("Technique");
            $("[id=userEmail]").setValue("Technique@mail.com");
            $("[for='gender-radio-1']").click();
            $("[id=userNumber").setValue("1111111111");
            $("[id=dateOfBirthInput").click();
            $(".react-datepicker__year-select").selectOption("1993");
            $(".react-datepicker__month-select").selectOption("January");
            $(".react-datepicker__day--023:not(.react-datepicker__day--outside-month)").click();
            $("[id=subjectsInput]").val("Economics").pressEnter();;
            $("[for='hobbies-checkbox-1']").click();
            $("#uploadPicture").uploadFromClasspath("123.jpeg");
            $("[id=currentAddress]").setValue("Moscow");
            $("#react-select-3-input").val("Haryana").pressEnter();
            $("#react-select-4-input").val("Panipat").pressEnter();
            $("#submit").pressEnter();


            $(".table-responsive").shouldHave(
                    text("Pasha Technique"),
                    text("Technique@mail.com"),
                    text("Male"),
                    text("1111111111"),
                    text("23 January,1993"),
                    text("Economics"),
                    text("Sports"),
                    text("123.jpeg"),
                    text("Moscow"),
                    text("Haryana Panipat"));



        }
    }


