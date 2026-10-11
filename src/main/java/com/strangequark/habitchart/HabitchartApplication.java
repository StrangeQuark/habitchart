package com.strangequark.habitchart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HabitchartApplication {

	public static void main(String[] args) {
		System.setProperty("debug", System.getProperty("debug", "false"));
		SpringApplication.run(HabitchartApplication.class, args);
	}

}
