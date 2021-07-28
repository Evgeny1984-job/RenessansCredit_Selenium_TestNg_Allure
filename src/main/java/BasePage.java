import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

//БАЗОВЫЙ КЛАСС
public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver=driver;
    }

    public boolean isElementClickable(By by) { //ЕСЛИ ЕЛЕМЕНТ НАЙДЕН, ТО КЛИКАЕМ НА НЕГО ИЛИ ВЫЗЫВАЕМ ИСКЛЮЧЕНИЕ

        try {
            Thread.sleep(3000);
            driver.findElement(by).click();
            return true;

        } catch (NoSuchElementException e) {
            return false;
        } catch (ElementNotInteractableException e) {
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

}
