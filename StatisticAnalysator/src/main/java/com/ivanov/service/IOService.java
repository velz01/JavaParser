package com.ivanov.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IOService {

    private static IOService instance;
    public IOService() {}

    public static IOService getInstance() {
        if (instance == null) {
            instance = new IOService();
        }
        return instance;
    }

    public File obtainFile(String path) {
        return new File(path);
    }

    public Scanner obtainReader(File file) throws FileNotFoundException {
        return new Scanner(file);
    }
    public PrintWriter obtainWriter(File file) throws FileNotFoundException {
        return new PrintWriter(file);
    }


}
