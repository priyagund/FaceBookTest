package com.bridgelabz.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id="email")
    private WebElement Email;

    @FindBy(id ="pass")
    private WebElement Password;

    @FindBy(xpath="//label[@id='loginbutton']")
    private WebElement loginBtn;

    //Initialization
    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    //Utilization
    public void setUsername(String userName)

    {
        Email.sendKeys(userName);
    }

    public void setPassword(String passWord)

    {
        Password.sendKeys(passWord);
    }

    public void clickLogin()

    {
        loginBtn.click();
    }
}