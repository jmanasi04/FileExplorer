package com.assess.FileExplorer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FileExplorerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileExplorerApplication.class, args);
	}
	
	 @Bean
	  public CommandLineRunner demo(FileDetailScheduler fileDetailScheduler) {
	    return (args) -> {
	      System.out.println("This is the beginning.");
	      fileDetailScheduler.process();
	    };
	  }

}
