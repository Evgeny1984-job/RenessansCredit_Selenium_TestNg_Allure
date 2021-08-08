package ru.renessans.autotests.selenium.framework.yashkin.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.renessans.autotests.selenium.framework.yashkin.DataBase.DataBaseHandler;
import ru.renessans.autotests.selenium.framework.yashkin.Utils.Time;


/**
 * КЛАСС РАБОТЫ СО СТРАНИЦЕЙ ЗАПОЛНЕНИЯ ДАННЫХ ДЛЯ ОФОРМЛЕНИЯ РАЗУМНОЙ КАРТЫ
 */

public class CreditCardSmartPage {

    WebDriver driver;
    DataBaseHandler dbHandler = new DataBaseHandler();

    public CreditCardSmartPage(WebDriver driver) {
        this.driver=driver;
    }

    private By familyField=By.xpath("//input[@data-message-title='Фамилия']"); //ПОЛЕ "ФАМИЛИЯ"
    private By nameField=By.xpath("//input[@data-message-title='Имя']");      //ПОЛЕ "ИМЯ"
    private By phoneNumberField=By.xpath("//input[@data-message-title='Мобильный телефон']"); //ПОЛЕ "МОБИЛЬНЫЙ ТЕЕЛФОН"
    private By emailField=By.xpath("//input[@data-index='2']");   //ПОЛЕ E-MAIL
    private By withoutMiddleNameCheckBox=By.xpath("//div[@data-ignoreid='1']"); //ЧЕКБОКС "НЕТ ОТЧЕСТВА"
    private By cardGetCardPlaceDropDown=By.xpath("//div[@class='jq-selectbox__trigger']"); //ВЫПАДАЮЩИЙ СПИСОК ДЛЯ ВЫБОРА РЕГИОНА ВЫДАЧИ КАРТЫ
    private By dropDownElementPenza = By.xpath("//li[text()='Пензенская область']"); //РЕГИОН "ПЕНЗЕНСКАЯ ОБЛАСТЬ"

    @Step("ЗАПОЛНЕНИЕ ПОЛЯ 'ФАМИЛИЯ'")
    public CreditCardSmartPage typeFamily(String family){ //ЗАПОЛНЕНИЕ ПОЛЯ "ФАМИЛИЯ"
        Time.setBeginStepTime();
        driver.findElement(familyField).sendKeys(family);
        dbHandler.signUpTest_Report("    typeFamily",
                Time.beginStepTime, Time.getCurrentTime());
        return this;
    }

    @Step("ЗАПОЛНЕНИЕ ПОЛЯ 'ИМЯ'")
    public CreditCardSmartPage typeName(String name){  //ЗАПОЛНЕНИЕ ПОЛЯ "ИМЯ"
        Time.setBeginStepTime();
        driver.findElement(nameField).sendKeys(name);
        dbHandler.signUpTest_Report("    typeName",
                Time.beginStepTime, Time.getCurrentTime());
        return this;
    }

    @Step("ЗАПОЛНЕНИЕ ПОЛЯ 'МОБИЛЬНЫЙ ТЕЛЕФОН'")
    public CreditCardSmartPage typePhoneNumberField(String phoneNumber) { //ЗАПОЛНЕНИЕ ПОЛЯ "МОБИЛЬНЫЙ ТЕЛЕФОН"
        Time.setBeginStepTime();
        driver.findElement(phoneNumberField).click();
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        dbHandler.signUpTest_Report("    typePhoneNumberField",
                Time.beginStepTime, Time.getCurrentTime());
        return this;
    }

    @Step("ЗАПОЛНЕНИЕ ПОЛЯ 'E-MAIL'")
    public CreditCardSmartPage typeEmailField(String email){ //ЗАПОЛНЕНИЕ ПОЛЯ "E-MAIL"
        Time.setBeginStepTime();
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(email);
        dbHandler.signUpTest_Report("    typeEmailField",
                Time.beginStepTime, Time.getCurrentTime());
        return this;
    }

    @Step("ВЫБИРАЕМ ЧЕКБОКС 'НЕТ ОТЧЕСТВА'")
    public CreditCardSmartPage clickWithoutMiddleNameCheckBox(){ //ВЫБИРАЕМ ЧЕКБОКС "НЕТ ОТЧЕСТВА"
        Time.setBeginStepTime();
        driver.findElement(withoutMiddleNameCheckBox).click();
        dbHandler.signUpTest_Report("    clickWithoutMiddleNameCheckBox",
                Time.beginStepTime, Time.getCurrentTime());
        return this;
    }

    @Step("ВЫБИРАЕМ РЕГИОН 'ПЕНЗЕНСКАЯ ОБЛАСТЬ'")
    public CreditCardSmartPage dropDownRegionPenza(){//ВЫБИРАЕМ РЕГИОН "ПЕНЗЕНСКАЯ ОБЛАСТЬ"
        Time.setBeginStepTime();
        driver.findElement(cardGetCardPlaceDropDown).click();
        driver.findElement(dropDownElementPenza).click();
        dbHandler.signUpTest_Report("    dropDownRegionPenza",
                Time.beginStepTime, Time.getCurrentTime());
        return this;
    }

    @Step("ЗАПОЛНЕНИЕ ВСЕХ НЕОБХОДИМЫХ ПОЛЕЙ НА ОФОРМЛЕНИЕ РАЗУМНОЙ КАРТЫ'")
    public CreditCardSmartPage fillCreditCardSmartPageValues(String family, String name, String phoneNumber, String email){
        this.typeFamily(family);
        this.typeName(name);
        this.typePhoneNumberField(phoneNumber);
        this.typeEmailField(email);
        this.clickWithoutMiddleNameCheckBox();
        this.dropDownRegionPenza();
        Time.setBeginStepTime();
        dbHandler.signUpTest_Report("    fillCreditCardSmartPageValues",
                Time.beginStepTime, Time.getCurrentTime());
        return this;
    }

    @Step("ПРОВЕРКА НАЛИЧИЯ ПОЛЕЙ НА СТРАНИЦЕ РАЗУМНОЙ КАРТЫ")
    public boolean smartCardPageFieldExists(){//ПРОВЕРКА НАЛИЧИЯ ПОЛЕЙ НА СТРАНИЦЕ РАЗУМНОЙ КАРТЫ
        Time.setBeginStepTime();
        if (driver.findElement(familyField).isDisplayed()&&
                driver.findElement(nameField).isDisplayed()&&
                driver.findElement(phoneNumberField).isDisplayed()&&
                driver.findElement(withoutMiddleNameCheckBox).isDisplayed()&&
                driver.findElement(cardGetCardPlaceDropDown).isDisplayed()) {
            dbHandler.signUpTest_Report("    smartCardPageFieldExists",
                    Time.beginStepTime, Time.getCurrentTime());
            return true;
        }
        else
            dbHandler.signUpTest_Report("  smartCardPageFieldExists",
                    Time.beginStepTime, Time.getCurrentTime());
            return false;
    }

}
