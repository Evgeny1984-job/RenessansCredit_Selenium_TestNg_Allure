package ru.renessans.autotests.selenium.framework.yashkin.BaseTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ru.renessans.autotests.selenium.framework.yashkin.DataBase.DataBaseHandler;
import ru.renessans.autotests.selenium.framework.yashkin.Pages.*;
import ru.renessans.autotests.selenium.framework.yashkin.Managers.InitManager;


/**
 * БАЗОВЫЙ КЛАСС ДЛЯ ТЕСТОВ TESTNG
 */

public class BaseTest {

    protected WebDriver driver;
    protected MainPage mainPage;
    protected DataBaseHandler dbHandler = new DataBaseHandler();
    protected InitManager initManager= new InitManager();

    @BeforeSuite
    public void BeforeSuite() throws Exception{
        System.out.println("@START UNIT TESTS");
        dbHandler.dropOldTableReport();
        dbHandler.createNewTableReport();
    }

    @AfterSuite
    public void AfterSuite() throws Exception{
        System.out.println("@END UNIT TESTS");
    }

    //ВЫПОЛНЕНИЕ ПЕРЕХОДА НА ГЛАВНУЮ СТРАНИЦУ РЕНЕССАНС КРЕДИТ И ПОЛУЧЕНИЕ ОБЪЕКТА ДРАЙВЕРА
    @BeforeMethod
    public void setUp() throws Exception{
        driver = initManager.initFramework().getDriver();
        mainPage = new MainPage(driver);
    }

    @AfterMethod
    public void tearDown() throws Exception{
        initManager.quitFramework();
    }

}
