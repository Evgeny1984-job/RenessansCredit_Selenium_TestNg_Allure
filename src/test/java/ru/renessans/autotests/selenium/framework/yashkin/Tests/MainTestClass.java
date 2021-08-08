package ru.renessans.autotests.selenium.framework.yashkin.Tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.*;

import ru.renessans.autotests.selenium.framework.yashkin.BaseTests.BaseTest;
import ru.renessans.autotests.selenium.framework.yashkin.Pages.*;
import ru.renessans.autotests.selenium.framework.yashkin.Utils.Time;


/**
 * ТЕСТИРОВАНИЕ ФУНКЦИОНАЛА САЙТА БАНКА РЕНЕССАНС КРЕДИТ СОГЛАСНО ЗАДАНИЮ
 */
public class MainTestClass extends BaseTest {

    //1Й ТЕСТ: ПЕРЕХОД НА СТРАНИЦУ РАЗУМНОЙ КАРТЫ И ЗАПОЛНЕНИЕ ПОЛЕЙ ДЛЯ ОФОРМЛЕНИЯ
    @Epic("ТЕСТИРОВАНИЕ https://rencredit.ru/")
    @Feature(value="АВТОТЕСТ НА ЗАПОЛНЕНИЕ ПОЛЕЙ СТРАНИЦЫ 'РАЗУМНОЙ КАРТЫ'")
    @Description("ЗАПОЛНЕНИЕ ПОЛЕЙ СТРАНИЦЫ 'РАЗУМНОЙ КАРТЫ'")
    @Test
    public void test1() throws Exception{
        dbHandler.signUpTest_Report("TEST_1 BEGIN: FILLING SMART CARD PAGE FIELDS", Time.getCurrentTime(), "");
        CardsPage cardsPage = mainPage.clickCardsLink();
        CreditCardSmartConditionPage creditCardSmartConditionPage = cardsPage.clickCreditCardSmartConditionLink();
        CreditCardSmartPage creditCardSmartPage = creditCardSmartConditionPage.clickCreditCardSmartLink();
        Assert.assertTrue(creditCardSmartPage.smartCardPageFieldExists());//ПРОВЕРКА ЗАГРУЗКИ СТРАНИЦЫ РАЗУМНОЙ КАРТЫ И НАЛИЧИЯ ПОЛЕЙ НА СТРАНИЦЕ
        creditCardSmartPage.fillCreditCardSmartPageValues("Семенов","Александр", "4957834623", "A_SEMENOV_2014@MAIL.RU");
        dbHandler.signUpTest_Report("TEST_1 END", "", Time.getCurrentTime());
    }

    //2Й ТЕСТ: ПЕРЕХОД НА СТРАНИЦУ "ВКЛАДЫ" И ЗАПОЛНЕНИЕ ПОЛЕЙ
    @Epic("ТЕСТИРОВАНИЕ https://rencredit.ru/")
    @Feature(value="АВТОТЕСТ НА ЗАПОЛНЕНИЕ ПОЛЕЙ СТРАНИЦЫ 'ВКЛАДЫ'")
    @Description("ЗАПОЛНЕНИЕ ПОЛЕЙ СТРАНИЦЫ 'ВКЛАДЫ'")
    @Test
    public void test2() throws Exception{
        dbHandler.signUpTest_Report("TEST_2 BEGIN: FILLING CONTRIBUTION PAGE FIELDS", Time.getCurrentTime(), "");
        ContributionsPage contributionsPage = mainPage.clickContributionsLink();
        Assert.assertTrue(contributionsPage.contributionsFieldSExists());//ПРОВЕРКА ЗАГРУЗКИ СТРАНИЦЫ "ВКЛАДЫ" И НАЛИЧИЕ ПОЛЕЙ НА СТРАНИЦЕ
        contributionsPage.fillContributionsPageValues("6000000");
        SupportPage supportPage = contributionsPage.clickSupportPageLink();
        supportPage.click_OU_po_VKLADAM_link(); //СТРАНИЦА ОБЩИХ УСЛОВИЙ ПО ВКЛАДАМ
        dbHandler.signUpTest_Report("TEST_2 END", "", Time.getCurrentTime());
    }

}
