package autorizationTests;

import base.BaseTest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.InterRAO.pages.AutorizationPage;
import org.InterRAO.pages.StartPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;


public class SingInWithLoginAndPasswordTest extends BaseTest {

    private static String VALID_LOGIN = "zolfjkimblee16@mail.ru";
    private static String VALID_PASSWORD = "001Test!";
    private static String INVALID_LOGIN_UNCORRECT = "Тест";
    private static String INVALID_LOGIN_UNREGISTERED = "testermi85422";
    private static String INVALID_PASSWORD = "1";


    @Owner("Серебряков Михаил")
    @DisplayName("Ввод валидных данных в поля логина и пароля")
    @Test
    public void validLoginAndPasswordTest(){
        StartPage startPage = new StartPage("http://yandex.ru/");
        AutorizationPage autorizationPage = new AutorizationPage();

        startPage.goToAutorizationPage();
        autorizationPage.FIELD_LOGIN_AND_EMAIL.sendKeys(VALID_LOGIN);
        autorizationPage.BUTTON_SINGIN.click();
        autorizationPage.FIELD_PASSWORD.sendKeys(VALID_PASSWORD);
        autorizationPage.BUTTON_SINGIN.click();

        Assertions.assertEquals("Введите код из письма", autorizationPage.MESSAGE_TWO_FACTOR_AUTORIZATION.getText());
    }

    @Owner("Серебряков Михаил")
    @DisplayName("Ввод невалидного логина, не зарегестрированного в системе")
    @Test
    public void invalidUnregisteredLoginTest(){
        StartPage startPage = new StartPage("http://yandex.ru/");
        AutorizationPage autorizationPage = new AutorizationPage();

        startPage.goToAutorizationPage();
        autorizationPage.FIELD_LOGIN_AND_EMAIL.sendKeys(INVALID_LOGIN_UNREGISTERED);
        autorizationPage.BUTTON_SINGIN.click();
        autorizationPage.MESSAGE_INVALID_LOGIN.shouldBe(visible);

        Assertions.assertEquals("Нет такого аккаунта. Проверьте логин или войдите по телефону", autorizationPage.MESSAGE_INVALID_LOGIN.getText());
    }

    @Owner("Серебряков Михаил")
    @DisplayName("Ввод невалидного логина, не соответствующего условиям регистрации")
    @Test
    public void invalidUncorrectLoginTest(){
        StartPage startPage = new StartPage("http://yandex.ru/");
        AutorizationPage autorizationPage = new AutorizationPage();

        startPage.goToAutorizationPage();
        autorizationPage.FIELD_LOGIN_AND_EMAIL.sendKeys(INVALID_LOGIN_UNCORRECT);
        autorizationPage.BUTTON_SINGIN.click();
        autorizationPage.MESSAGE_INVALID_LOGIN.shouldBe(visible);

        Assertions.assertEquals("Такой логин не подойдет", autorizationPage.MESSAGE_INVALID_LOGIN.getText());
    }

    @Owner("Серебряков Михаил")
    @DisplayName("Нажатие на кнопку 'Войти',с незаполненным полем ввода логина")
    @Test
    public void invalidExistLoginTest(){
        StartPage startPage = new StartPage("http://yandex.ru/");
        AutorizationPage autorizationPage = new AutorizationPage();

        startPage.goToAutorizationPage();
        autorizationPage.BUTTON_SINGIN.click();
        autorizationPage.MESSAGE_INVALID_LOGIN.shouldBe(visible);

        Assertions.assertEquals("Логин не указан", autorizationPage.MESSAGE_INVALID_LOGIN.getText());
    }

    @Owner("Серебряков Михаил")
    @DisplayName("Нажатие на кнопку 'Продолжить', с незаполненным полем ввода логина")
    @Test
    public void invalidExistPasswordTest(){
        StartPage startPage = new StartPage("http://yandex.ru/");
        AutorizationPage autorizationPage = new AutorizationPage();

        startPage.goToAutorizationPage();
        autorizationPage.FIELD_LOGIN_AND_EMAIL.sendKeys(VALID_LOGIN);
        autorizationPage.BUTTON_SINGIN.click();
        autorizationPage.BUTTON_SINGIN.click();

        Assertions.assertEquals("Пароль не указан", autorizationPage.MESSAGE_INVALID_PASSWORD.getText());
    }

    @Owner("Серебряков Михаил")
    @DisplayName("Ввод невалидного пароля")
    @Test
    public void invalidUncorrectPasswordTest(){
        StartPage startPage = new StartPage("http://yandex.ru/");
        AutorizationPage autorizationPage = new AutorizationPage();

        startPage.goToAutorizationPage();
        autorizationPage.FIELD_LOGIN_AND_EMAIL.sendKeys(VALID_LOGIN);
        autorizationPage.BUTTON_SINGIN.click();
        autorizationPage.FIELD_PASSWORD.sendKeys(INVALID_PASSWORD);
        autorizationPage.BUTTON_SINGIN.click();

        Assertions.assertEquals("Неверный пароль", autorizationPage.MESSAGE_INVALID_PASSWORD.getText());
    }
}
