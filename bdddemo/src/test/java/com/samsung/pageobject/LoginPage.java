package com.samsung.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    /*
    Noi dinh nghia cac doi tuowng tren UI, cac method lam viec voi chung
     */
    @FindBy(css = "input#auth-block__form-group__email")
    public WebElement tbUserName;
    @FindBy(css = "input[data-test-login-password]")
    public WebElement tbPassword;
    @FindBy(css = "button.auth-block__login-btn")
    public WebElement btnLogin;

    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void openLoginPage()
    {
        this.driver.get("https://fado.vn/dang-nhap?redirect=https%3A%2F%2Ffado.vn%2F");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        PageFactory.initElements(driver, this);
    }
}
