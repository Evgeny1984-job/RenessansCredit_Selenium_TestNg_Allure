import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

//КЛАСС РАБОТЫ СО СТРАНИЦЕЙ ЗАПОЛНЕНИЯ ДАННЫХ ДЛЯ ОФРМЛЕНИЯ РАЗУМНОЙ КАРТЫ
public class CreditCardSmartPage {

    WebDriver driver;

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
        driver.findElement(familyField).sendKeys(family);
        return this;
    }

    @Step("ЗАПОЛНЕНИЕ ПОЛЯ 'ИМЯ'")
    public CreditCardSmartPage typeName(String name){  //ЗАПОЛНЕНИЕ ПОЛЯ "ИМЯ"
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    @Step("ЗАПОЛНЕНИЕ ПОЛЯ 'МОБИЛЬНЫЙ ТЕЛЕФОН'")
    public CreditCardSmartPage typePhoneNumberField(String phoneNumber) { //ЗАПОЛНЕНИЕ ПОЛЯ "МОБИЛЬНЫЙ ТЕЛЕФОН"
        driver.findElement(phoneNumberField).click();
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        return this;
    }

    @Step("ЗАПОЛНЕНИЕ ПОЛЯ 'E-MAIL'")
    public CreditCardSmartPage typeEmailField(String email){ //ЗАПОЛНЕНИЕ ПОЛЯ "E-MAIL"
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    @Step("ВЫБИРАЕМ ЧЕКБОКС 'НЕТ ОТЧЕСТВА'")
    public CreditCardSmartPage clickWithoutMiddleNameCheckBox(){ //ВЫБИРАЕМ ЧЕКБОКС "НЕТ ОТЧЕСТВА"
        driver.findElement(withoutMiddleNameCheckBox).click();
        return this;
    }

    @Step("ВЫБИРАЕМ РЕГИОН 'ПЕНЗЕНСКАЯ ОБЛАСТЬ'")
    public CreditCardSmartPage dropDownRegionPenza(){//ВЫБИРАЕМ РЕГИОН "ПЕНЗЕНСКАЯ ОБЛАСТЬ"
        driver.findElement(cardGetCardPlaceDropDown).click();
        driver.findElement(dropDownElementPenza).click();
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
        return this;
    }

    @Step("ПРОВЕРКА НАЛИЧИЯ ПОЛЕЙ НА СТРАНИЦЕ РАЗУМНОЙ КАРТЫ")
    public boolean smartCardPageFieldExists(){//ПРОВЕРКА НАЛИЧИЯ ПОЛЕЙ НА СТРАНИЦЕ РАЗУМНОЙ КАРТЫ
        if (driver.findElement(familyField).isDisplayed()&&
                driver.findElement(nameField).isDisplayed()&&
                driver.findElement(phoneNumberField).isDisplayed()&&
                driver.findElement(withoutMiddleNameCheckBox).isDisplayed()&&
                driver.findElement(cardGetCardPlaceDropDown).isDisplayed())
            return true;
        else
            return false;
    }

}
