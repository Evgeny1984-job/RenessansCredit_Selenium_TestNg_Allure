import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//КЛАСС РАБОТЫ С МОДУЛЕМ "КАРТЫ"
public class CardsPage extends BasePage{

    private WebDriver driver;

    public CardsPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    private By smartCardLink=By.xpath("//a[@href='https://rencredit.ru/cards/creditcardsmart/']"); //ССЫЛКА НА СТРАНИЦУ ОПИСАНИЯ УСЛОВИЙ РАЗУМНОЙ КАРТЫ

    @Step("НАЖАТИЕ НА ССЫЛКУ ОПИСАНИЯ УСЛОВИЙ РАЗУМНОЙ КАРТЫ")
    public CreditCardSmartConditionPage clickCreditCardSmartConditionLink(){ //НАЖАТИЕ НА ССЫЛКУ ОПИСАНИЯ УСЛОВИЙ РАЗУМНОЙ КАРТЫ
        isElementClickable(smartCardLink);
//        driver.findElement(smartCardLink).click();
        return new CreditCardSmartConditionPage(driver);
    }

}
