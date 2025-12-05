package com.pluralsight.NorthwindTraderSpringBoot.Data;

import com.pluralsight.NorthwindTradersSpringBoot.models.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    int add(Product product);
    List<Product> getAll() throws SQLException;

}