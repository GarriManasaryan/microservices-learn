package com.example.m2.port.adapters.persistence;

import com.example.m2.domain.Product;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PostgresqlProducts {

    private final NamedParameterJdbcOperations jdbcOperations;

    public PostgresqlProducts(DataSource dataSource) {
        this.jdbcOperations = new NamedParameterJdbcTemplate(dataSource) {
        };
    }

    public void save(String name){
        var sqlTemplate = """
                insert into lower_products (name) values (:name)
                """;
        var params = new MapSqlParameterSource().addValue("name", name.toLowerCase());

        jdbcOperations.update(sqlTemplate, params);
    }

    private static RowMapper<Product> asRowMapper(){
        return (rs, rowNum) -> new Product(rs.getString("name"));
    }

    public List<Product> all(){
        var sqlTemplate = """
                select * from lower_products
                """;
        return jdbcOperations.query(sqlTemplate, new MapSqlParameterSource(), asRowMapper());
    }

}
