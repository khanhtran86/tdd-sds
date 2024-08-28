package com.samsung.stepsdefinition;

import java.time.Duration;

import com.samsung.pageobject.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;

public class loginstepdefinition {
    WebDriver driver;
    LoginPage loginPage;
    @Before
    public void setup()
    {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @After
    public void Teardown()
    {
        this.driver.quit();
    }
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        this.loginPage.openLoginPage();
    }

    @When("I attempt to login with valid credentials")
    public void i_attempt_to_login_with_valid_credentials() {
        this.loginPage.tbUserName.sendKeys("khanh.tx@live.com");
        this.loginPage.tbPassword.sendKeys("@2KhanhTran");
        this.loginPage.btnLogin.click();
    }

    @Then("I should be Logged in Successfully")
    public void i_should_be_logged_in_successfully() throws InterruptedException {
        Thread.sleep(3000);

        WebElement lbUserName = this.driver.findElement(By.cssSelector("div.user-name-col"));
        assertThat(lbUserName.getText(), equals("Tran Xuan Khanh"));
    }

    @When("I attempt to login with invalid credentials")
    public void i_attempt_to_login_with_invalid_credentials() {
        this.loginPage.tbUserName.sendKeys("khanh.tx@live.com");
        this.loginPage.tbPassword.sendKeys("@2KhanhTran123");
        this.loginPage.btnLogin.click();
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() throws InterruptedException {
        Thread.sleep(3000);

        WebElement lbError = this.driver.findElement(By.cssSelector("div.my-alert.-alert-danger"));
        assertThat(lbError.getText(), equals("Có lỗi xảy ra:\n- Mật khẩu không đúng, vui lòng kiểm tra lại"));
    }
}
