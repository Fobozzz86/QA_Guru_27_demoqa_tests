package qa.demo;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @BeforeAll
    static void beforeAll() {
        //Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void successFillPracticeFormTest() {
        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $(".practice-form-wrapper").shouldHave(text("Practice Form"));
        $("#firstName").setValue("Artem");
        $("#lastName").setValue("Bulaev");
        $("#userEmail").setValue("Fooolll@test.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("89649990000");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("bio").pressEnter();
        $("#subjectsInput").setValue("ch").pressEnter();
        $("[for=hobbies-checkbox-3]").click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/Test.jpg");
        $("#currentAddress").setValue("Penza");
        $("#submit").scrollIntoView(true);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-hover").shouldHave(text("Artem Bulaev"), text("Fooolll@test.com"),
                text("Male"), text("8964999000"));
        $("#closeLargeModal").scrollIntoView(true).click();
           $(".practice-form-wrapper").shouldHave(text("Practice Form"));

//        sleep(600_000);

    }
}
