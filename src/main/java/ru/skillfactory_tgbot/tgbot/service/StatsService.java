package ru.skillfactory_tgbot.tgbot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skillfactory_tgbot.tgbot.entity.Spend;
import ru.skillfactory_tgbot.tgbot.repository.StatsRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatsService {

    private final StatsRepository statsRepository;

    public int getCountOfIncomesThatGreater(BigDecimal amount) {
        return statsRepository.getCountOfIncomesThatGreaterThan(amount);
    }

    public List<Spend> getSpendsThatGreaterThan(Long amount) {
        return statsRepository.getSpendsThatGreaterThan(amount);
    }
}
