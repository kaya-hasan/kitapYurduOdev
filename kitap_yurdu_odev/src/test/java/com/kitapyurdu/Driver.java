package com.kitapyurdu;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import org.apache.commons.csv.CSVFormat;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;
import java.util.logging.Logger;

public class Driver {
    public static WebDriver driver;
    public static Logger logger;

    public Driver()  {
    }
//    private int col;
//    private String[][] numbers;
//    private int row;


    @Before
    public void startDriver()  {

        System.setProperty("webdriver.chrome.driver","src/test/java/com/kitapyurdu/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.get("https://www.kitapyurdu.com/");
        //C:\Users\hp\Desktop\YBS\selenium\kitap_yurdu_odev\data.csv





    }
    @After
    public void closeDriver(){
        if(driver !=null) {
            driver.close();
            driver.quit();


        }
    }

}
