package org.InterRAO.pages;

import com.codeborne.selenide.Selenide;

public abstract class BasePage {

    protected String START_PAGE_URL = "http://yandex.ru/";

    public BasePage(String pageUrl){
        this.START_PAGE_URL = pageUrl;
        openStartPage();
    }

    public void openStartPage(){
        Selenide.open(START_PAGE_URL);
    }
}

