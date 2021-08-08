package ru.renessans.autotests.selenium.framework.yashkin.Managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class InitManager {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public InitManager initFramework() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(ProjectConst.IMPLICITLY_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ProjectConst.APP_URL);
        return this;
    }

   public void quitFramework() {
        if (driver !=null)
            driver.quit();//ЗАКРЫТИЕ БРАУЗЕРА
    }
}
