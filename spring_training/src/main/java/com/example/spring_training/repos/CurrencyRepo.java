package com.example.spring_training.repos;

import com.example.spring_training.domain.Currency;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepo extends CrudRepository<Currency, Long> {
}
