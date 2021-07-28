import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//КЛАСС РАБОТЫ СО СТРАНИЦЕЙ "СЕРВИСЫ"
public class SupportPage{

    WebDriver driver;

    public SupportPage(WebDriver driver) {
        this.driver=driver;
    }

    private By OU_po_VKLADAM_link=By.xpath("//a[@href='/upload/iblock/02e/ou-po-vkladam-27.01.pdf']//span[1]");//ССЫЛКА "ОБЩИЕ УСЛОВИЯ ПО ВКЛАДАМ" ОТ 27.01.2021

    @Step("НАЖАТИЕ НА ССЫЛКУ 'ОБЩИЕ УСЛОВИЯ ПО ВКЛАДАМ' ОТ 27.01.2021")
    public SupportPage click_OU_po_VKLADAM_link(){//НАЖАТИЕ НА ССЫЛКУ "ОБЩИЕ УСЛОВИЯ ПО ВКЛАДАМ" ОТ 27.01.2021
        driver.findElement(OU_po_VKLADAM_link).click();
        return this;
    }

}
