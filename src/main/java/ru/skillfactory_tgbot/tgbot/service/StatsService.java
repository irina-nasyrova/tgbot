package ru.skillfactory_tgbot.tgbot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skillfactory_tgbot.tgbot.repository.StatsRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class StatsService {

    private final StatsRepository statsRepository;

    public int getCountOfIncomesThatGreater(BigDecimal amount) {
        return statsRepository.getCountOfIncomesThatGreaterThan(amount);
    }
}
