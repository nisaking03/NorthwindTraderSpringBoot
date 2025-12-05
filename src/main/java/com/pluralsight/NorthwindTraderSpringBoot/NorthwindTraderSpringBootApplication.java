package com.pluralsight.NorthwindTraderSpringBoot;

import com.pluralsight.NorthwindTradersSpringBoot.data.ProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.data.SimpleProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import com.pluralsight.NorthwindTradersSpringBoot.userinterface.ConsoleHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class NorthwindTradersSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(NorthwindTradersSpringBootApplication.class, args);
	}


}
