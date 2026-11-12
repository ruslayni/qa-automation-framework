package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.WebSocketPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pages.WebSocketPage.*;

public class WebTests {

    WebSocketPage manager;
    @BeforeEach
    public void setUp(){
        manager = new WebSocketPage();
    }
    @Test
    public void shouldOpenGooglePage(){
        open("https://www.google.com/");
        $("body").shouldBe(visible);
        System.out.println("Page title: " + title());
        System.out.println("Current URL: " + webdriver().driver().url());
    }
//Selenide Test
    @Test
    public void uniProjectLogin(){
        open("https://ruslayni.github.io/uni/");

        $("#login-username").setValue("1");
        $("#login-password").setValue("1");
        $(".btn-ghost").click();
        $("#btn-login").click();

        $(byText("Monthly Balance")).shouldBe(visible);
    }
//Test using page object
    @Test
    public void shouldConnectToWebsocket(){
        manager.openPage();
        manager.webSocketSearch();
        manager.connect();
        manager.waitUntilConnected();
        assertTrue(manager.isConnected());
    }
}
