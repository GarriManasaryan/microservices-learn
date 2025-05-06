//package com.example.m1.port.adapters.persistence;
//
//import com.example.m1.domain.Product;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import javax.sql.DataSource;
//import java.util.List;
//
//@Repository
//public class PostgresqlProducts {
//
//    private final NamedParameterJdbcOperations jdbcOperations;
//
//    public PostgresqlProducts(DataSource dataSource) {
//        this.jdbcOperations = new NamedParameterJdbcTemplate(dataSource) {
//        };
//    }
//
//    public void save(String name){
//        var sqlTemplate = """
//                insert into upper_products (name) values (:name)
//                """;
//        var params = new MapSqlParameterSource().addValue("name", name.toUpperCase());
//
//        jdbcOperations.update(sqlTemplate, params);
//    }
//
//    private static RowMapper<Product> asRowMapper(){
//        return (rs, rowNum) -> new Product(rs.getString("name"));
//    }
//
//    public List<Product> all(){
//        var sqlTemplate = """
//                select * from upper_products
//                """;
//        return jdbcOperations.query(sqlTemplate, new MapSqlParameterSource(), asRowMapper());
//    }
//
//}
