package com.pluralsight.NorthwindTraderSpringBoot.UserInterface;

import com.pluralsight.NorthwindTradersSpringBoot.data.ProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class CommandLineUI implements CommandLineRunner {


    private ProductDao productDao;


    @Autowired
    public CommandLineUI(ProductDao productDao){
        this.productDao = productDao;
    }



    @Override
    public void run(String... args) throws Exception {

        System.out.println("Hello World From CommandLineUI.run!");


        String prompt = """
				Please make a choice:
				1. List Products
				2. Add Product
				Choose a number""";

        while(true){
            int choice = ConsoleHelper.promptForInt(prompt);
            switch(choice){
                case 1:
                    doListProducts();
                    break;
                case 2:
                    doAddProduct();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid value please try again!");

            }
        }
    }


    private void doAddProduct() {
        String productName = ConsoleHelper.promptForString("Please enter a name for the product");
        String productCategory = ConsoleHelper.promptForString("Please enter the Category");
        double productPrice = ConsoleHelper.promptForDouble("Please enter the price");
        Product product = new Product(0, productName, productCategory, productPrice);
        productDao.add(product);
    }

    private void doListProducts() throws SQLException {
        List<Product> products = productDao.getAll();
        for(Product p : products){
            System.out.println(p);
        }
    }

}
