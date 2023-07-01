package com.example.spring_training;

import com.example.spring_training.domain.Currency;
import com.example.spring_training.repos.CurrencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private CurrencyRepo currencyRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name,
                           Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model){
        Iterable<Currency> currencies = currencyRepo.findAll();
        model.put("currencies", currencies);

        return "main";
    }

    @PostMapping
    public String add(@RequestParam String name, @RequestParam double course_to_rubble, Map<String, Object> model){
        Currency currency = new Currency(name, course_to_rubble);
        currencyRepo.save(currency);

        Iterable<Currency> currencies = currencyRepo.findAll();
        model.put("currencies", currencies);

        return "main";
    }
}