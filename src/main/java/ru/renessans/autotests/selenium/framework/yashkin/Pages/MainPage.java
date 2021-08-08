package ru.renessans.autotests.selenium.framework.yashkin.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import ru.renessans.autotests.selenium.framework.yashkin.DataBase.DataBaseHandler;
import ru.renessans.autotests.selenium.framework.yashkin.Utils.Time;


/**
 * КЛАСС РАБОТЫ С ГЛАВНОЙ СТРАНИЦЕЙ(rencredit.ru)
 */

public class MainPage extends BasePage {
    private WebDriver driver;
    DataBaseHandler dbHandler = new DataBaseHandler();

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By contributionsLink = By.xpath("//a[@href='/contributions/']");       //ссылка Вклады
    private By contributionsLinkFull = By.xpath("//a[@href='https://rencredit.ru/contributions/']");       //ссылка Вклады
    private By contributionsLinkAggregateMenu = By.xpath("//span[text()[normalize-space()='Вклады']]");   //ссылка Вклады
    private By cardsLink = By.xpath("//a[@href='/cards/']");                       //ссылка Карты
    private By cardsLinkAggregateMenu = By.xpath("//span[text()[normalize-space()='Карты']]");            //ссылка Карты


    @Step("НАЖАТИЕ НА ССЫЛКУ 'ВКЛАДЫ'")
    public ContributionsPage clickContributionsLink() {//НАЖАТИЕ НА ССЫЛКУ "ВКЛАДЫ"
        Time.setBeginStepTime();
        if (isElementClickable(contributionsLink)) {
        } else {
            isElementClickable(contributionsLinkAggregateMenu);
            isElementClickable(contributionsLinkFull);
        }
        dbHandler.signUpTest_Report("    clickContributionsLink",
                Time.beginStepTime, Time.getCurrentTime());
        return new ContributionsPage(driver);
    }

    @Step("НАЖАТИЕ НА ССЫЛКУ 'КАРТЫ'")
    public CardsPage clickCardsLink() { //НАЖАТИЕ НА ССЫЛКУ "КАРТЫ"
        Time.setBeginStepTime();
        if (isElementClickable(cardsLink)) {
        } else {
            isElementClickable(cardsLinkAggregateMenu);
        }
        dbHandler.signUpTest_Report("    clickCardsLink",
                Time.beginStepTime, Time.getCurrentTime());
        return new CardsPage(driver);
    }

}
