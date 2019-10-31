package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {

    public static void main(String[] args) throws InterruptedException {

        //setting up the browser
        WebDriverManager.chromedriver().setup();

        //import class CMD+ENTER ot ALT+ENTER or CONRTOL+SPACE
        //selenium object
        WebDriver driver = new ChromeDriver();

        //navigate the website
        driver.get("https://www.google.com");

        //another way of openning website
        driver.navigate().to("https://wwww.facebook.com");

        //goes back to previous webpage
        driver.navigate().back();

        //stops your code based on millis
        Thread.sleep(3000);

        //goes forward to next webpage
        driver.navigate().forward();

        //refresh the webpage
        driver.navigate().refresh();



    }
}
