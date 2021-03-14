package com.example.moneyconveter.service;

import com.example.moneyconveter.model.CurrencyCode;
import com.example.moneyconveter.request.MoneyRequest;
import com.example.moneyconveter.response.MoneyResult;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.*;

@Service
public class MoneyConverter {
    private Map<String, Double> exchangeRate;
    private List<CurrencyCode> list;

    public MoneyConverter() {
        exchangeRate = new HashMap<>();
        parseExchangeRate();
        parseCurrencyCode();
    }

    public List<CurrencyCode> listCurrencyCode() {
        Collections.sort(list);
        return list;
    }

    private void parseExchangeRate() {
        try {
            File file = ResourceUtils.getFile("classpath:static/exchange_rate.json");
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode masterNode = objectMapper.readTree(bufferedReader);

            Iterator<Map.Entry<String, JsonNode>> iter = masterNode.fields();
            while (iter.hasNext()) {
                var node = iter.next();
                exchangeRate.put(node.getKey(), node.getValue().doubleValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseCurrencyCode() {
        Map<String, String> mapping = new HashMap<>();
        mapping.put("Country", "Country");
        mapping.put("CountryCode", "CountryCode");
        mapping.put("Currency", "Currency");
        mapping.put("Code", "Code");

        HeaderColumnNameTranslateMappingStrategy<CurrencyCode> strategy = new
                HeaderColumnNameTranslateMappingStrategy<>();
        strategy.setType(CurrencyCode.class);
        strategy.setColumnMapping(mapping);
        try {
            File file = ResourceUtils.getFile("classpath:static/currency.csv");
            FileReader fileReader = new FileReader(file);
            CSVReader csvReader = new CSVReader(fileReader);

            CsvToBean csvToBean = new CsvToBean();
            list = csvToBean.parse(strategy, csvReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public MoneyResult calculateMoney(MoneyRequest request) {
        double moneyResult = request.getAmount() * exchangeRate.get(request.getToCode()) /
                exchangeRate.get(request.getFromCode());

        return new MoneyResult(String.format("%,.2f", moneyResult), String.format("%,.0f", (double)request.getAmount()),
                request.getFromCode(), request.getToCode());
    }
}
