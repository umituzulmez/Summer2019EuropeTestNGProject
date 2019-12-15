package com.cybertek.tests.day14_pom_tests;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTests extends TestBase {

    @Test
    public void wrongPasswordTest(){

        //how to use page object model locaters?
        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        loginPage.passwordInput.sendKeys("wrongPassword");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");
    }

    @Test
    public void wrongUsernameTest(){

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("wrongUsername");
        loginPage.passwordInput.sendKeys("UseUser123");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");
    }
}
