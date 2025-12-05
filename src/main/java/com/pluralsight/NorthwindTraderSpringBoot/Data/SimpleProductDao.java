package com.pluralsight.NorthwindTraderSpringBoot.Data;

import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
public class SimpleProductDao implements ProductDao {

    public SimpleProductDao(){
        add(new Product(1, "Apple", "Fruit", 1.99f));
        add(new Product(2, "Blueberries", "Fruit", 2.99f));
        add(new Product(3, "Banana", "Fruit", 0.99f));
        add(new Product(4, "Beef", "Meat", 9.99f));

    }

    List<Product> products = new ArrayList<>();

    int counter = 1;

    @Override
    public int add(Product product) {
        product.setProductId(counter++);
        products.add(product);
        return product.getProductId();
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}
