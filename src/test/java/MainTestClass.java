import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

//TESTNG TESTS
public class MainTestClass {

    private WebDriver driver;
    private MainPage mainPage;

    @BeforeSuite
    public void BeforeSuite() throws Exception{
        System.out.println("@START UNIT TESTS");
    }

    @AfterSuite
    public void AfterSuite() throws Exception{
        System.out.println("@END UNIT TESTS");
    }

    //ВЫПОЛНЕНИЕ ПЕРЕХОДА НА ГЛАВНУЮ СТРАНИЦУ РЕНЕССАНС КРЕДИТ
    @BeforeMethod
    public void setUp() throws Exception{
        System.setProperty("webdriver.chrome.driver","C:\\RenessansCreditAutotests\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://rencredit.ru/");
        mainPage = new MainPage(driver);
    }

    @AfterMethod
    public void tearDown() throws Exception{
        if (driver !=null)
            driver.quit();//ЗАКРЫТИЕ БРАУЗЕРА
    }

    //1Й ТЕСТ: ПЕРЕХОД НА СТРАНИЦУ РАЗУМНОЙ КАРТЫ И ЗАПОЛНЕНИЕ ПОЛЕЙ ДЛЯ ОФОРМЛЕНИЯ
    @Epic("ТЕСТИРОВАНИЕ https://rencredit.ru/")
    @Feature(value="АВТОТЕСТ НА ЗАПОЛНЕНИЕ ПОЛЕЙ СТРАНИЦЫ 'РАЗУМНОЙ КАРТЫ'")
    @Description("ЗАПОЛНЕНИЕ ПОЛЕЙ СТРАНИЦЫ 'РАЗУМНОЙ КАРТЫ'")
    @Test
    public void test1() throws Exception{
        CardsPage cardsPage = mainPage.clickCardsLink();
        CreditCardSmartConditionPage creditCardSmartConditionPage = cardsPage.clickCreditCardSmartConditionLink();
        CreditCardSmartPage creditCardSmartPage = creditCardSmartConditionPage.clickCreditCardSmartLink();
        Assert.assertTrue(creditCardSmartPage.smartCardPageFieldExists());//ПРОВЕРКА ЗАГРУЗКИ СТРАНИЦЫ РАЗУМНОЙ КАРТЫ И НАЛИЧИЯ ПОЛЕЙ НА СТРАНИЦЕ
        creditCardSmartPage.fillCreditCardSmartPageValues("Семенов","Александр", "4957834623", "A_SEMENOV_2014@MAIL.RU");
    }

    //2Й ТЕСТ: ПЕРЕХОД НА СТРАНИЦУ "ВКЛАДЫ" И ЗАПОЛНЕНИЕ ПОЛЕЙ
    @Epic("ТЕСТИРОВАНИЕ https://rencredit.ru/")
    @Feature(value="АВТОТЕСТ НА ЗАПОЛНЕНИЕ ПОЛЕЙ СТРАНИЦЫ 'ВКЛАДЫ'")
    @Description("ЗАПОЛНЕНИЕ ПОЛЕЙ СТРАНИЦЫ 'ВКЛАДЫ'")
    @Test
    public void test2() throws Exception{
        ContributionsPage contributionsPage = mainPage.clickContributionsLink();
        Assert.assertTrue(contributionsPage.contributionsFieldSExists());//ПРОВЕРКА ЗАГРУЗКИ СТРАНИЦЫ "ВКЛАДЫ" И НАЛИЧИЕ ПОЛЕЙ НА СТРАНИЦЕ
        contributionsPage.fillContributionsPageValues("6000000");
        SupportPage supportPage = contributionsPage.clickSupportPageLink();
        supportPage.click_OU_po_VKLADAM_link(); //СТРАНИЦА ОБЩИХ УСЛОВИЙ ПО ВКЛАДАМ

    }

}
