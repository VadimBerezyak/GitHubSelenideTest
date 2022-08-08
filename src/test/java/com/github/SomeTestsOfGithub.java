package com.github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SomeTestsOfGithub {
    @BeforeAll
    static void configuration() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "1024x768";
    }

    //    @AfterEach
//    void afterEachTest(){
//        Selenide.clearBrowserLocalStorage();
//    }
    @BeforeEach
    void beforeTest() {
        Selenide.clearBrowserCookies();
    }

    @Test
    void someGithubTest() {
        Selenide.open("https://github.com");
        $("[data-test-selector=nav-search-input]").setValue("Selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#wiki-tab ").click();
        $(byText("Show 2 more pages…")).click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-box a[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }
}
