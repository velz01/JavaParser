package com.ivanov.util;

import com.ivanov.service.IOService;
import static com.ivanov.util.Constant.*;
public class StringUtil {
    private static StringUtil instance;
    public StringUtil() {}

    public static StringUtil getInstance() {
        if (instance == null) {
            instance = new StringUtil();
        }
        return instance;
    }
    public String obtainFilePath(String[] args, String pathDirectory) {
        return pathDirectory + args[INDEX_OF_FILENAME];
    }

    public String obtainDomain(String lineWithDomain) {
        return lineWithDomain.substring(lineWithDomain.lastIndexOf(EQUAL) + 1);
    }

    public String obtainLink(String[] ArrayWithDomainAndQuantity) {
        return ArrayWithDomainAndQuantity[INDEX_OF_DOMAIN];
    }
    public int obtainQuantity(String[] ArrayWithDomainAndQuantity) {
        return Integer.parseInt(ArrayWithDomainAndQuantity[INDEX_OF_QUANTITY].substring(0, ArrayWithDomainAndQuantity[INDEX_OF_QUANTITY].lastIndexOf(QUOTATION_MARK)));
    }
    public String obtainCategoryName(String[] args) {
        StringBuilder string = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            if (i + 1 < args.length) {
                string.append(args[i]).append(SPACE);
            } else {
                string.append(args[i]);
            }
        }
        string.insert(0, QUOTATION_MARK).append(QUOTATION_MARK);
        return string.toString();
    }
    public String obtainResultRow(String categoryName, int categoryQuantity) {
        return String.format(RESULT_ROW_PATTERN, categoryName, categoryQuantity);
    }
}
