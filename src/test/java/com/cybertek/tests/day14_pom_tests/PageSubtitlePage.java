package com.cybertek.tests.day14_pom_tests;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitlePage extends TestBase {

    /*
    Test case
    Open browser
    Login as a Driver
    Verify that page subtitle is Quick Launchpad
    Go to Activities -> Calendar Events
    verify that page subtitle is Calendar Events
    */

    @Test
    public void verifySubtitleTest() {

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage();

        String actualSubtitle = dashboardPage.getPageSubTitle();
        String expectedSubtitle = "Quick Launchpad";

        Assert.assertEquals(actualSubtitle,expectedSubtitle,"Verify Subtitles");

        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events","Verify Subtitle");

    }
}
