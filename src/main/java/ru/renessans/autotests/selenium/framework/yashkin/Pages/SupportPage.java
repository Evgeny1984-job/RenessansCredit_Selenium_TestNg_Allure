package ru.renessans.autotests.selenium.framework.yashkin.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.renessans.autotests.selenium.framework.yashkin.DataBase.DataBaseHandler;
import ru.renessans.autotests.selenium.framework.yashkin.Utils.Time;


/**
 * КЛАСС РАБОТЫ С МОДУЛЕМ "СЕРВИСЫ"
 */

public class SupportPage{

    WebDriver driver;
    DataBaseHandler dbHandler = new DataBaseHandler();

    public SupportPage(WebDriver driver) {
        this.driver=driver;
    }

    private By OU_po_VKLADAM_link=By.xpath("//a[@href='/upload/iblock/02e/ou-po-vkladam-27.01.pdf']//span[1]");//ССЫЛКА "ОБЩИЕ УСЛОВИЯ ПО ВКЛАДАМ" ОТ 27.01.2021

    @Step("НАЖАТИЕ НА ССЫЛКУ 'ОБЩИЕ УСЛОВИЯ ПО ВКЛАДАМ' ОТ 27.01.2021")
    public SupportPage click_OU_po_VKLADAM_link(){//НАЖАТИЕ НА ССЫЛКУ "ОБЩИЕ УСЛОВИЯ ПО ВКЛАДАМ" ОТ 27.01.2021
        Time.setBeginStepTime();
        driver.findElement(OU_po_VKLADAM_link).click();
        dbHandler.signUpTest_Report("    click_OU_po_VKLADAM_link",
                Time.beginStepTime, Time.getCurrentTime());
        return this;
    }

}