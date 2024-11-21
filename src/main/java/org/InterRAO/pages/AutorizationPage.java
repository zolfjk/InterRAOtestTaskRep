package org.InterRAO.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AutorizationPage{

    public SelenideElement FIELD_LOGIN_AND_EMAIL = $(By.xpath("//input[@placeholder='Логин или email']"));
    public SelenideElement BUTTON_SINGIN = $(By.xpath("//button[@id='passp:sign-in']"));
    public SelenideElement FIELD_PASSWORD = $(By.xpath("//input[@placeholder='Введите пароль']"));
    public SelenideElement MESSAGE_TWO_FACTOR_AUTORIZATION = $(By.xpath("//label[@data-t='field:label-confirmation-code']" ));
    public SelenideElement MESSAGE_INVALID_LOGIN = $(By.xpath("//div[@id='field:input-login:hint']" ));
    public SelenideElement MESSAGE_INVALID_PASSWORD = $(By.xpath("//div[@id='field:input-passwd:hint']" ));
}

