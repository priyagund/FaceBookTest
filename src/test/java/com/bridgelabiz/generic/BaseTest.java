package com.bridgelabiz.generic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.util.concurrent.TimeUnit;

public class BaseTest implements IAutoConstant {

    public WebDriver driver;
    static
    {
//        System.setProperty(GECKO_KEY, GECKO_VALUE);
        System.setProperty(CHROME_KEY,CHROME_VALUE);
    }

    @BeforeMethod
    public void openApplication()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        String url = Library.getProperty(CONFIG_PATH,"URL");
        driver.manage().window().maximize();
        driver.get(url);
        String ITO = Library.getProperty(CONFIG_PATH,"ImplicitTimeOut");
        int timeoutPeriod = Integer.parseInt(ITO);
        driver.manage().timeouts().implicitlyWait(timeoutPeriod, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeApplication()
    {
        driver.close();
    }
}
