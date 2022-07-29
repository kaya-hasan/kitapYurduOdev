package com.kitapyurdu;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.csv.CSVFormat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.FileReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

import static com.kitapyurdu.Driver.driver;

public class processPage {
    Methods metod;
    Logger logger = LogManager.getLogger(processPage.class);


    public processPage() {
        metod = new Methods();
    }


    public void search() {
        metod.click(By.id("search-input"));
        metod.sendKeys(By.id("search-input"), "roman");
        logger.info("Search Box'a roman bilgisi girildi.");
        driver.findElement(By.id("search-input")).sendKeys(Keys.ENTER);
    }

    public void randomProduct() {
        Random random = new Random();
        int randomProduct = random.nextInt(10);
        while (true) {
            if (randomProduct != 0) {
                break;
            }
            randomProduct = random.nextInt(10);
        }
        System.out.println("Seçilen kitap indisi: " +randomProduct);
        driver.findElement(By.xpath("//div[@class='product-list']/div[" + randomProduct + "]/div/div[1]")).click();
    }

    public void addToBasket() {
        metod.click(By.xpath("//span[text()='Sepete Ekle']"));
        logger.info("Sepete ekle butonuna tıklandı.");
        String value = metod.getText(By.xpath("//span[text()='1']"));
        Assert.assertEquals("1", value);
        logger.info("Değer kontrol edildi.");
    }

    public void clickMyCart() {
        metod.click(By.id("cart-items"));
        logger.info("Sepetime tıklandı.");

    }

    public void goToCard() {
        metod.click(By.id("js-cart"));
        logger.info("Sepete git butonuna tıklandı");
    }

    public void updateQuantity() {
        metod.click(By.xpath("//input[@name='quantity']"));
        driver.findElement(By.xpath("//input[@name='quantity']")).clear();
        metod.sendKeys(By.xpath("//input[@name='quantity']"), "2");
        metod.click(By.xpath("//i[@title='Güncelle']"));
        String value = metod.getText(By.xpath("//h2[text()='Sepetiniz güncelleniyor!']"));
        Assert.assertEquals("Sepetiniz güncelleniyor!", value);
    }

    public void deleteProduct() {
        metod.click(By.id("cart-items"));
        metod.click(By.xpath("//td[@class='remove']/i"));
        metod.click(By.id("cart-items"));
        String value = metod.getText(By.xpath("//div[text()='Alışveriş sepetiniz boş!']"));
        Assert.assertEquals("Alışveriş sepetiniz boş!", value);
    }

    public void readCSV() throws FileNotFoundException {

        Scanner sc = new Scanner(new File("C:\\Users\\hp\\Desktop\\YBS\\selenium\\kitap_yurdu_odev\\data.csv"));
        //parsing a CSV file into the constructor of Scanner class
        sc.useDelimiter(",");
        //setting comma as delimiter pattern
        while (sc.hasNext()) {
            System.out.print(sc.next());
        }
        sc.close();
        //closes the scanner
    }

}
