import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//КЛАСС РАБОТЫ СО СТРАНИЦЕЙ ОПИСАНИЯ РАЗУМНОЙ КАРТЫ
public class CreditCardSmartConditionPage {

    WebDriver driver;

    public CreditCardSmartConditionPage(WebDriver driver) {
        this.driver=driver;
    }

    private By smartCardLinkNext = By.xpath("//a[@href='https://rencredit.ru/app/card_smart/site_cc_smart']");

    @Step("НАЖАТИЕ НА ССЫЛКУ СТРАНИЦЫ РАЗУМНОЙ КАРТЫ")
    public CreditCardSmartPage clickCreditCardSmartLink(){ //НАЖАТИЕ НА ССЫЛКУ СТРАНИЦЫ РАЗУМНОЙ КАРТЫ
        driver.findElement(smartCardLinkNext).click();
        return new CreditCardSmartPage(driver);
    }

}
