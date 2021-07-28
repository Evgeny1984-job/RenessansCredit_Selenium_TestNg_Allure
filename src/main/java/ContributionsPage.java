import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

//КЛАСС РАБОТЫ СО СТРАНИЦЕЙ "ВКЛАДЫ"
public class ContributionsPage {

    WebDriver driver;

    public ContributionsPage(WebDriver driver) {
        this.driver=driver;
    }

    private By checkBoxBankBranch=By.xpath("//div[@class='jq-checkbox calculator__check']"); //ЧЕКБОКС "В ОТДЕЛЕНИИ БАНКА"
    private By amountField=By.xpath("//input[contains(@class,'calculator__slide-input currency-input')]"); //ПОЛЕ СУММА
    private By supportPageLink=By.xpath("//a[@href='/support/conditions/']"); //ССЫЛКА ПЕРЕХОДАНА СТРАНИЦУ "СЕРВИСЫ"
    private By termination_line=By.xpath("(//span[contains(@class,'ui-slider-handle ui-state-default')])[2]"); //ПОЛЗУНОК "НА СРОК"
    private By destinyPoint=By.xpath("(//div[@data-pos='1'])[2]"); //6 МЕСЯЦЕВ-ПЕРЕТАСКИВАНИЕ ПОЛЗУНКА "НА СРОК"

    @Step("ЗАПОЛНЕНИЕ ПОЛЯ 'СУММА'")
    public ContributionsPage typeAmountField(String amount){ //ЗАПОЛНЕНИЕ ПОЛЯ "СУММА"
        driver.findElement(amountField).sendKeys(amount);
        return this;
    }

    @Step("ВЫДЕЛЕНИЕ ЧЕКБОКСА 'В ОТДЕЛЕНИИ БАНКА'")
    public ContributionsPage clickCheckBoxBankBranch(){ //ВЫДЕЛЕНИЕ ЧЕКБОКСА "В ОТДЕЛЕНИИ БАНКА"
        driver.findElement(checkBoxBankBranch).click();
        return this;
    }

    @Step("ПЕРЕТАСКИВАНИЕ ПОЛЗУНКА 'НА СРОК")
    public ContributionsPage moveTerminationLinePoint() { //ПЕРЕТАСКИВАНИЕ ПОЛЗУНКА "НА СРОК"
        Actions actions = new Actions(driver);
        driver.findElement(termination_line).click();
        actions
                .dragAndDrop(
                        driver.findElement(termination_line),
                        driver.findElement(destinyPoint)).
                build().
                perform();
        return this;
    }

    @Step("НАЖАТИЕ НА ССЫЛКУ 'СЕРВИСЫ'")
    public SupportPage clickSupportPageLink(){ //НАЖАТИЕ НА ССЫЛКУ "СЕРВИСЫ"
        driver.findElement(supportPageLink).click();
        return new SupportPage(driver);
    }

    @Step("ЗАПОЛНЕНИЕ ВСЕХ НЕОБХОДИМЫХ ЗНАЧЕНИЙ СТРАНИЦЫ 'ВКЛАДЫ'")
    public ContributionsPage fillContributionsPageValues(String amount){ //ЗАПОЛНЕНИЕ ВСЕХ НЕОБХОДИМЫХ ЗНАЧЕНИЙ СТРАНИЦЫ "ВКЛАДЫ"
        this.typeAmountField(amount);
        this.clickCheckBoxBankBranch();
        this.moveTerminationLinePoint();
        return this;
    }

    @Step("ПРОВЕРКА НАЛИЧИЯ ПОЛЕЙ НА СТРАНИЦЕ ВКЛАДОВ")
    public boolean contributionsFieldSExists(){//ПРОВЕРКА НАЛИЧИЯ ПОЛЕЙ НА СТРАНИЦЕ ВКЛАДОВ
        if (driver.findElement(checkBoxBankBranch).isDisplayed()&&
                driver.findElement(amountField).isDisplayed()&&
                driver.findElement(supportPageLink).isDisplayed()&&
                driver.findElement(termination_line).isDisplayed())
            return true;
        else
            return false;
    }


}
