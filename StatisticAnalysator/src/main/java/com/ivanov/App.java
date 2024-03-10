package com.ivanov;

import java.io.*;
import java.util.*;

import com.ivanov.service.*;
import com.ivanov.util.StringUtil;

import static com.ivanov.util.Constant.*;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        IOService ioService = IOService.getInstance();
        DataService dataService = DataService.getInstance();
        StringUtil stringUtil = StringUtil.getInstance();


        dataService.addDomainsWithoutQuantity(
                ioService.obtainReader(
                        ioService.obtainFile(
                                stringUtil.obtainFilePath(args, PATH_DIRECTORY_SEARCH)
                        )
                )
        );

        dataService.addDomainsWithQuantity(
                ioService.obtainReader(
                        ioService.obtainFile(PATH_FILE_COMMON)
                )
        );


        dataService.increaseQuantityOfDomain();


        dataService.writeDomainsToFile(
                ioService.obtainWriter(
                        ioService.obtainFile(PATH_FILE_COMMON)
                )
        );

        dataService.addOrIncreaseCategories(
                ioService.obtainReader(
                        ioService.obtainFile(PATH_FILE_CATEGORY)
                ), args

        );

        dataService.writeCategoryAndQuantity(
                ioService.obtainWriter(
                        ioService.obtainFile(PATH_FILE_CATEGORY)
                )
        );
    }
}

