package fr.codox.azspringbootfun.repositories;

import static java.util.Collections.emptyMap;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public HelloRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addVisitor(String ip, LocalDateTime date) {
        String sql = "INSERT INTO visitors (ip, visit_date) VALUES (:ip, :vdate)";
        final Map<String, ? extends Serializable> values = Map.of("ip", ip, "vdate", date);

        jdbcTemplate.update(sql, values);
    }

    public List<String> findAllIps() {
        String sql = "SELECT ip FROM public.visitors";

        return jdbcTemplate.queryForList(sql, emptyMap(), String.class);
    }
}
