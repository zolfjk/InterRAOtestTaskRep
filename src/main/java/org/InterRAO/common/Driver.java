package org.InterRAO.common;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Driver {

    public static void setupBrowser(String browserName) {

        Configuration.headless = false;
        Configuration.browserSize = "1920x1200";

        switch (browserName) {
            case "chrome":
                Configuration.browser = Browsers.CHROME;
                break;
            case "firefox":
                Configuration.browser = Browsers.FIREFOX;
                break;
            case "edge":
                Configuration.browser = Browsers.EDGE;
                break;
            default:
                Configuration.browser = Browsers.CHROME;
                break;
        }
    }

    public static void open(String url) {
        Selenide.open(url);
    }

    public static WebDriver currentDriver() {
        return WebDriverRunner.getWebDriver();
    }

    public static void waitUntilElementClickable(String elementLocator) {
        WebDriverWait wait = new WebDriverWait(currentDriver(), Duration.ofSeconds(19));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementLocator)));
    }

    public static void impWait(int seconds){
        WebDriverWait wait = new WebDriverWait(currentDriver(), Duration.ofSeconds(seconds));
    }

    public static void close() {
        currentDriver().quit();
    }
}
