package com.geekbrains.ru.springproduct;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProductApplication {

	public static void main(String[] args) {
		Flyway flyway = Flyway.configure()
				.dataSource("jdbc:postgresql://localhost:5432/product-app", "postgres", "postgrespass").load();
		flyway.migrate();

		SpringApplication.run(SpringProductApplication.class, args);
	}

}
