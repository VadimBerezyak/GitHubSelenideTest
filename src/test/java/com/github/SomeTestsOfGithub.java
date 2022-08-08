package com.github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class SomeTestsOfGithub {
    @BeforeAll
    static void configuration(){
        Configuration.browser = "firefox";
        Configuration.browserSize = "1024x768";
        Configuration.baseUrl = "https://github.com";
    }
    @BeforeEach
    void beforeTest(){
        Selenide.clearBrowserCookies();
    }
    @Test
    void someGithubTest(){
        Selenide.open("/");
        $("[data-test-selector=nav-search-input]").setValue("Selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#wiki-tab ").click();
        $("")






    }
}
