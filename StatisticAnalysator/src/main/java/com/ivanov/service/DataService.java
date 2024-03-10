package com.ivanov.service;

import com.ivanov.util.StringUtil;

import java.io.PrintWriter;
import java.util.*;

import static com.ivanov.util.Constant.*;

public class DataService {
    private static DataService instance;

    private DataService() {
         domainsWithoutQuantity = new ArrayList<>();
         allDomainsWithQuantity = new HashMap<>();
         categories = new HashMap<>();
    }

    public static DataService getInstance() {
        if (instance == null) {
            instance = new DataService();
        }
        return instance;
    }
    public List<String> domainsWithoutQuantity;
    public Map<String, Integer> allDomainsWithQuantity;
    public Map<String, Integer> categories;
    StringUtil stringUtil = StringUtil.getInstance();

    public void addDomainsWithoutQuantity(Scanner reader) {
        while (reader.hasNext()) { // добавляются домены без их количества в список
            String lineWithDomain = reader.next();
            domainsWithoutQuantity.add(stringUtil.obtainDomain(lineWithDomain));
        }
    }
    public void addDomainsWithQuantity(Scanner reader) {
        while (reader.hasNext()) { // читает из файла домены с их количеством и отправляет в мапу
            String[] arrayWithDomainAndQuantity = reader.next().split(SPLIT_PATTERN);
            allDomainsWithQuantity.put(stringUtil.obtainLink(arrayWithDomainAndQuantity), stringUtil.obtainQuantity(arrayWithDomainAndQuantity));
        }
    }
    public void increaseQuantityOfDomain() {
        for (String domain : domainsWithoutQuantity) { // прибавляет количество доменов
            if (allDomainsWithQuantity.containsKey(domain)) {
                allDomainsWithQuantity.put(domain, allDomainsWithQuantity.get(domain) + 1);
            } else {
                allDomainsWithQuantity.put(domain, 1);
            }
        }
    }
    public void writeDomainsToFile(PrintWriter writer) {
        for (Map.Entry<String, Integer> entry : allDomainsWithQuantity.entrySet()) {
            String domain = entry.getKey();
            Integer quantity = entry.getValue();
            writer.println(stringUtil.obtainResultRow(domain, quantity));

        }
        writer.close();
    }
    public void addOrIncreaseCategories(Scanner reader, String[] args) {
        while (reader.hasNext()) {
            String[] listWithCategoryAndQuantity = reader.nextLine().split(EQUAL);
            categories.put(listWithCategoryAndQuantity[INDEX_NAME_CATEGORY], Integer.parseInt(listWithCategoryAndQuantity[INDEX_OF_QUANTITY].substring(1, listWithCategoryAndQuantity[INDEX_OF_QUANTITY].lastIndexOf("\"")))); //addorincreasecategories
        }
        String categoryName = stringUtil.obtainCategoryName(args);
        if (categories.containsKey(categoryName)) {
            categories.put(categoryName, categories.get(categoryName) + 1);
        } else {
            categories.put(categoryName, 1);
        }
    }
    public void writeCategoryAndQuantity(PrintWriter writer) {
        for (Map.Entry<String, Integer> entry : categories.entrySet()) {
            String categoryName = entry.getKey();
            Integer categoryQuantity = entry.getValue();
            writer.println(stringUtil.obtainResultRow(categoryName, categoryQuantity));
        }
        writer.close();
    }

    public List<String> obtainDomainsWithoutQuantity() {
        return domainsWithoutQuantity;
    }
    public Map<String, Integer> obtainDomainsWithQuantity() {
        return allDomainsWithQuantity;
    }



}
