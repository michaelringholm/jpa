package com.opusmagus.jpa;

import java.io.File;

import javax.annotation.PostConstruct;

import org.aspectj.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import com.microsoft.


class Handler implements Thread.UncaughtExceptionHandler {	 
	public void uncaughtException(Thread t, Throwable e) {
		FileUtil.writeAsString(new File("c:\\data\\github\\jpa\\test.txt"), "hello");
		System.err.println("BUUUH!");
	}
}

@SpringBootApplication
public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {	
		Handler globalExceptionHandler = new Handler();
        Thread.setDefaultUncaughtExceptionHandler(globalExceptionHandler);	
		SpringApplication.run(App.class);
	}

	@PostConstruct
	public void init() {
		Handler globalExceptionHandler = new Handler();
        Thread.setDefaultUncaughtExceptionHandler(globalExceptionHandler);
        //new GlobalExceptionHandler().performArithmeticOperation(10, 0);
	}

	@Bean
	public CommandLineRunner demo(CarsRepo repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Car("BMW", "318"));
			repository.save(new Car("BMW", "320"));

			// fetch all customers
			log.info("Cars found with findAll():");
			log.info("-------------------------------");
			for (Car car : repository.findAll()) {
				log.info(String.format("Make=%s, Model=%s", car.Make, car.Model));
			}
			log.info("");

			// fetch an individual customer by ID
			Car car = repository.findById(1L).get();
			log.info("Cars found with findById(1):");
			log.info("--------------------------------");
			log.info(String.format("Make=%s, Model=%s", car.Make, car.Model));
			log.info("");

			
			//com.microsoft.sqlserver.jdbc.SQLServerDriver

			// fetch customers by last name
			/*log.info("Car found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});*/
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}
}