package com.kitapyurdu;

import java.io.*;
import java.util.Scanner;

import org.junit.Test;

public class TestPage extends Driver {
    @Test
    public void processPage() throws FileNotFoundException {
        processPage process = new processPage();
        process.search();
        process.randomProduct();
        process.addToBasket();
        process.clickMyCart();
        process.goToCard();
        process.updateQuantity();
        process.deleteProduct();
        process.readCSV();
    }
}


