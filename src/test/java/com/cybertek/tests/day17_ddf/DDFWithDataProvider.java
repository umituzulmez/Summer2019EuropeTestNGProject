package com.cybertek.tests.day17_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {

    @DataProvider
    public Object[][] testData(){

        String[][] data = {
                {"GoT","9"},
                {"HYMYM","9"},
                {"Friends","10"},
                {"Person of Interest","10"},
                {"Breaking Bad","9"},
                {"Big Bang Theory","9"},
                {"Chernobyl","9"},
                {"Prison Break","10"}
        };
        return data;
    }

    //get the data from data provider and pass as and arguement
    @Test(dataProvider = "testData")
    public void test1(String tvshow, String rating){

        System.out.println("Tv Show: " + tvshow + " has rating " + rating);
    }
}
