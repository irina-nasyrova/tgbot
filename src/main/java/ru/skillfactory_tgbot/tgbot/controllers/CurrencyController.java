package ru.skillfactory_tgbot.tgbot.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skillfactory_tgbot.tgbot.dto.ValuteCursOnDate;
import ru.skillfactory_tgbot.tgbot.entity.Spend;
import ru.skillfactory_tgbot.tgbot.service.CentralRussianBankService;
import ru.skillfactory_tgbot.tgbot.service.StatsService;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final CentralRussianBankService centralRussianBankService;
    private final StatsService statsService;

    @GetMapping("/getCurrencies")
    @ApiOperation(value = "Получение курса всех валют на текущий день")
    public List<ValuteCursOnDate> getValuteCursOnDate() throws Exception {
        return centralRussianBankService.getCurrenciesFromCbr();
    }

    @GetMapping("/getCurrency/{code}")
    @ApiOperation(value = "Получение курса определенно валюты на текущий день")
    public ValuteCursOnDate getCourseForCurrency(@PathVariable String code) throws Exception {
        return centralRussianBankService.getCourseForCurrency(code);
    }

    @GetMapping("/getStats")
    @ApiOperation(value = "Получение количества пополнений, которые превышают определенную сумму")
    public int getStatsAboutIncomesThatGreater(@RequestParam(value = "amount") BigDecimal amount) {
        return statsService.getCountOfIncomesThatGreater(amount);
    }

    @GetMapping("/getSpendStats")
    @ApiOperation(value = "Получение трат, которые превышают определенную сумму")
    public List<Spend> getSpendsThatGreater(@RequestParam(value = "amount") Long amount) {
        return statsService.getSpendsThatGreaterThan(amount);
    }
}