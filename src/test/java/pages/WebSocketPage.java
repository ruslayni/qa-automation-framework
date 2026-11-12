package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSocketPage {
    private final SelenideElement connectButton = $("#connect");
    private final SelenideElement searchField = $("#example-filter");
    private final SelenideElement disconnectButton = $("#disconnect");
    private final SelenideElement webSocketSearchField = $("#message");
    public WebSocketPage() {
    }

    public void waitUntilConnected() {
        disconnectButton.shouldBe(enabled, Duration.ofSeconds(10));}

    public void openPage(){
        open("https://the-internet.herokuapp.com/");
    }

    public void webSocketSearch(){
        searchField.setValue("WebSocket");
        $(byText("WebSocket")).click();
    }

    public void connect(){
        connectButton.click();
    }

    public void disconnect(){
        disconnectButton.click();
    }
    public boolean isConnected() {
        System.out.println("Connect enabled: " + connectButton.isEnabled());
        System.out.println("Disconnect enabled: " + disconnectButton.isEnabled());

        return disconnectButton.isEnabled();
    }


}
