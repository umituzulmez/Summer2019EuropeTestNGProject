package com.cybertek.tests.day7_TestNG;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BeforeAndAfterTest {

    @Test
    public void test1(){

        System.out.println("This is my test one");
    }

    @Ignore
    @Test
    public void test2(){

        System.out.println("This is my test two");
    }

    @Test
    public void test3(){

        System.out.println("This is my test three");
    }

    @BeforeMethod
    public void setUpMethod(){

        System.out.println("BEFORE METHOD");
        System.out.println("OPENNİNG THE BROWSER");
    }

    @AfterMethod
    public void tearDown(){

        System.out.println("CLOSE BROWSER");
    }

    @BeforeClass
    public void beforeClass(){

        System.out.println("BEFORE CLASS CODE");
    }

    @AfterClass
    public void afterClass(){

        System.out.println("AFTER CLASS CODE");
        System.out.println("REPORTİNG");
    }

}
