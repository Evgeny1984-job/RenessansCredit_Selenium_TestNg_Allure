package ru.renessans.autotests.selenium.framework.yashkin.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.renessans.autotests.selenium.framework.yashkin.DataBase.DataBaseHandler;
import ru.renessans.autotests.selenium.framework.yashkin.Utils.Time;


/**
 * КЛАСС РАБОТЫ С МОДУЛЕМ РАЗУМНОЙ КАРТЫ
 */

public class CreditCardSmartConditionPage {

    WebDriver driver;
    DataBaseHandler dbHandler = new DataBaseHandler();

    public CreditCardSmartConditionPage(WebDriver driver) {
        this.driver=driver;
    }

    private By smartCardLinkNext = By.xpath("//a[@href='https://rencredit.ru/app/card_smart/site_cc_smart']");

    @Step("НАЖАТИЕ НА ССЫЛКУ СТРАНИЦЫ РАЗУМНОЙ КАРТЫ")
    public CreditCardSmartPage clickCreditCardSmartLink(){ //НАЖАТИЕ НА ССЫЛКУ СТРАНИЦЫ РАЗУМНОЙ КАРТЫ
        Time.setBeginStepTime();
        driver.findElement(smartCardLinkNext).click();
        dbHandler.signUpTest_Report("    clickCreditCardSmartLink",
                Time.beginStepTime, Time.getCurrentTime());
        return new CreditCardSmartPage(driver);
    }

}
