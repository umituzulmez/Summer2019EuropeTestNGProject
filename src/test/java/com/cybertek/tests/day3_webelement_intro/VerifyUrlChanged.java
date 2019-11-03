package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrlChanged {

    /**
     * Verify URL changed
     * open browser
     * go to http://practice.cybertekschool.com/forgot_password Links to an external site.
     * enter any email
     * click on Retrieve password
     * verify that url changed to http://practice.cybertekschool.com/email_sent
     */

    public static void main(String[] args) {

        //open the chrome
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email
        WebElement emailInput = driver.findElement(By.name("email"));

        //senKeys() ==> send keyboard actions to webElement / enters given text
        emailInput.sendKeys("email@gmail.com");

        //locate to password button
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));

        //click the button
        retrievePasswordButton.click();

        String expectedUrl = "http://practice.cybertekschool.com/email_sent";

        String actualUrl = driver.getCurrentUrl();

        //verify that url changed to http://practice.cybertekschool.com/email_sent
        if(expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedUrl = " + expectedUrl);
            System.out.println("actualUrl = " + actualUrl);
        }

        //close
        driver.close();



    }
}
