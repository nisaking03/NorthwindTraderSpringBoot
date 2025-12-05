package com.pluralsight.NorthwindTraderSpringBoot.Data;

import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlProductDao implements ProductDao {

    DataSource dataSource;

    @Autowired
    public MySqlProductDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public int add(Product product) {
        return 0;
    }

    @Override
    public List<Product> getAll() throws SQLException {

        System.out.println("From the MySQLProductDao" + dataSource.getConnection().toString());

        List<Product> products = new ArrayList<>();

        String query = """
                SELECT
                ProductId,
                ProductName as name,
                Categories.CategoryName as category,
                UnitPrice as price
                
                FROM products
                JOIN Categories ON products.categoryId = Categories.CategoryId;""";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet results = statement.executeQuery()){
            while(results.next()){
                int productid = results.getInt(1);
                String productname = results.getString(2);
                String categoryname = results.getString(3);
                double price = results.getDouble(4);
                products.add(new Product(productid, productname, categoryname, price));
            }


        }

        return products;




    }
}