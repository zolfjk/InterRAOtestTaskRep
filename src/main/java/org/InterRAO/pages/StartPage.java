package org.InterRAO.pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.$;

public class StartPage extends BasePage{

    public SelenideElement buttonSingIn = $(By.xpath("//div[@data-testid='login-button-wrapper']//button[@data-testid='login-button']"));
    public SelenideElement buttonSingInWithYandexId = $(By.xpath("//span[text()='Войти через Яндекс ID']"));

    public StartPage(String pageUrl) {
        super(pageUrl);
    }

    public void goToAutorizationPage(){
        buttonSingIn.shouldBe(clickable);
        buttonSingIn.click();
        buttonSingInWithYandexId.shouldBe(clickable);
        buttonSingInWithYandexId.click();
    }
}
