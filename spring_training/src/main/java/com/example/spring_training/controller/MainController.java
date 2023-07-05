package com.example.spring_training.controller;

import com.example.spring_training.domain.Currency;
import com.example.spring_training.repos.CurrencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private CurrencyRepo currencyRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {

        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Currency> currencies = currencyRepo.findAll();
        model.put("currencies", currencies);

        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String name, @RequestParam double course, Map<String, Object> model) {
        Currency currency = new Currency(name, course);
        currencyRepo.save(currency);

        Iterable<Currency> currencies = currencyRepo.findAll();
        model.put("currencies", currencies);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Currency> currencies;
        if (filter != null && !filter.isEmpty()) {
            currencies = currencyRepo.findByName(filter);
        } else {
            currencies = currencyRepo.findAll();
        }
        model.put("currencies", currencies);

        return "main";
    }
}