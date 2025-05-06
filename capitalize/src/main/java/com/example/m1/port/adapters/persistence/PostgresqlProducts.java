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
//        name = name.toLowerCase();
//        var sqlTemplate = """
//                insert into capitalize_products (name) values (:name)
//                """;
//        var params = new MapSqlParameterSource().addValue("name", name.substring(0, 1).toUpperCase() + name.substring(1));
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
//                select * from capitalize_products
//                """;
//        return jdbcOperations.query(sqlTemplate, new MapSqlParameterSource(), asRowMapper());
//    }
//
//}
