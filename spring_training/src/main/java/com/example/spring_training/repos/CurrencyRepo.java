package com.example.spring_training.repos;

import com.example.spring_training.domain.Currency;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CurrencyRepo extends CrudRepository<Currency, Long> {
    List<Currency> findByName(String name);
}
