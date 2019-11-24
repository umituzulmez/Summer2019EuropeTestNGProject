package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {

    @Test

    public void test1(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();

        WebElement dropdownElement = driver.findElement(By.cssSelector("#dropdownMenuLink"));

        // does not work because webElement does not have "select" class
        //Select links = new Select(dropdownElement);

        //open the dropdown
        dropdownElement.click();

        List<WebElement> listofLinks = driver.findElements(By.className("dropdown-item"));

        System.out.println("number of Links = " + listofLinks.size());

        //print first element

        System.out.println(listofLinks.get(0).getText());

        //print text of each link
        for(WebElement Link : listofLinks){

            System.out.println(Link.getText());
        }

        //locate the element and click it
        //driver.findElement(By.linkText("Yahoo")).click();

        //or index of element and click
        listofLinks.get(3).click();






    }
}
