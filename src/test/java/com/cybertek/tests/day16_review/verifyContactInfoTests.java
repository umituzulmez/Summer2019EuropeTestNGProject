package com.cybertek.tests.day16_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTests extends TestBase {

    @Test
    public void contactDetailsTest(){
        /*
        open the chrome
        go to qa3.vytrack
        login as a sales manager
        navigate to customers ->contacts
        click on email mbrackstone9@example.com
        verify that full name is Ms Mariam Brackstone
        verify that email is mbrackstone9@example.com
        verify that phone number is +18982323434
        */

        extentLogger = report.createTest("contactDetailsTest");
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");
        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        extentLogger.info("Login as a sales manager");
        loginPage.login(username,password);

        ContactsPage contactsPage = new ContactsPage();
        contactsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Navigate to Customer/Contacts module");
        contactsPage.navigateToModule("Customers","Contacts");

        contactsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Click on mbrackstone9@example.com email");
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        ContactInfoPage contactInfoPage = new ContactInfoPage();
        String actualFullname = contactInfoPage.fullname.getText();
        String expectedFullname = "Ms Mariam Brackstone";
        extentLogger.info("Verify fullname is: " + expectedFullname);
        Assert.assertEquals(actualFullname,expectedFullname,"verify full name is Ms Mariam Brackstone");

        String actualEmail = contactInfoPage.email.getText();
        String expectedEmail = "mbrackstone9@example.com";
        extentLogger.info("Verify email is: " + expectedEmail);
        Assert.assertEquals(actualEmail,expectedEmail, "Verify email is mbrackstone9@example.com");

        //lazy way
        extentLogger.info("Verify phone number is +18982323434");
        Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434", "Verify phone number is +18982323434");

    }
}
