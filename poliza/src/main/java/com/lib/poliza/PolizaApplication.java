package com.lib.poliza;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PolizaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolizaApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		var modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		return modelMapper;
	}

}
