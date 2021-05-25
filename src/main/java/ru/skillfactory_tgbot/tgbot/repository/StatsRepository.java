package ru.skillfactory_tgbot.tgbot.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class StatsRepository {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //public int getCountOfIncomesThatGreaterThan(BigDecimal amount) {
    //    return jdbcTemplate.queryForObject("SELECT count(*) FROM INCOME WHERE INCOME > ?", Integer.class, amount);
    //}

    public int getCountOfIncomesThatGreaterThan(BigDecimal amount) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("amount", amount);
        return namedParameterJdbcTemplate
                .queryForObject("SELECT count(*) FROM INCOME WHERE INCOME > :amount", parameters, new StatsRowMapper());
    }

    private static final class StatsRowMapper implements RowMapper<Integer> {
        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getInt("COUNT");
        }
    }
}
