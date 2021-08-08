package ru.renessans.autotests.selenium.framework.yashkin.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.renessans.autotests.selenium.framework.yashkin.DataBase.DataBaseHandler;
import ru.renessans.autotests.selenium.framework.yashkin.Utils.Time;


/**
 * КЛАСС РАБОТЫ С МОДУЛЕМ "КАРТЫ"
**/

public class CardsPage extends BasePage {

    private WebDriver driver;
    DataBaseHandler dbHandler = new DataBaseHandler();

    public CardsPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    private By smartCardLink=By.xpath("//a[@href='https://rencredit.ru/cards/creditcardsmart/']"); //ССЫЛКА НА СТРАНИЦУ ОПИСАНИЯ УСЛОВИЙ РАЗУМНОЙ КАРТЫ

    @Step("НАЖАТИЕ НА ССЫЛКУ ОПИСАНИЯ УСЛОВИЙ РАЗУМНОЙ КАРТЫ")
    public CreditCardSmartConditionPage clickCreditCardSmartConditionLink(){ //НАЖАТИЕ НА ССЫЛКУ ОПИСАНИЯ УСЛОВИЙ РАЗУМНОЙ КАРТЫ
        Time.setBeginStepTime();
        isElementClickable(smartCardLink);
        dbHandler.signUpTest_Report("    clickCreditCardSmartConditionLink",
                Time.beginStepTime, Time.getCurrentTime());
        return new CreditCardSmartConditionPage(driver);
    }

}
