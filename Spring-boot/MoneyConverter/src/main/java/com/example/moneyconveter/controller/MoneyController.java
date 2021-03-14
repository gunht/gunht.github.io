package com.example.moneyconveter.controller;

import com.example.moneyconveter.request.MoneyRequest;
import com.example.moneyconveter.response.MoneyResult;
import com.example.moneyconveter.service.MoneyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/converter")
public class MoneyController {

    @Autowired
    private MoneyConverter moneyConverter;

    @GetMapping
    public String getMoneyConverter(Model model) {
        MoneyRequest moneyRequest = new MoneyRequest();
        if (moneyRequest.getFromCode() == null && moneyRequest.getToCode() == null) {
            moneyRequest.setFromCode("USD");
            moneyRequest.setToCode("VND");
        }
        model.addAttribute("currencyCode", moneyConverter.listCurrencyCode());
        model.addAttribute("moneyRequest", moneyRequest);
        return "money";
    }

    @PostMapping
    public String postMoneyConverter(@ModelAttribute MoneyRequest request, Model model) {
        model.addAttribute("currencyCode", moneyConverter.listCurrencyCode());
        MoneyResult moneyResult = moneyConverter.calculateMoney(request);
        model.addAttribute("moneyResult", moneyResult);
        return "money";
    }
}
