package com.ivanov;


import com.ivanov.util.StringUtils;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        StringUtils util = StringUtils.getInstance();

        System.out.println(util.extractDomain("https://www.google.com/search?q="));

        /*String link = "https://www.etsk.ru/product/57202/";
        link = link.substring(0, link.indexOf("/", 10));
        System.out.println(link);
        //Commenting driver.quit() for user to easily verify the links
        //driver.quit();*/
    }

}
//searchResult_2021-01-01_13:20:00.txt