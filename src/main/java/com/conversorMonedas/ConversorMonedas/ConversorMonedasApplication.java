package com.conversorMonedas.ConversorMonedas;

import com.conversorMonedas.ConversorMonedas.principal.Principal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConversorMonedasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConversorMonedasApplication.class, args);
		Principal principal = new Principal();
		principal.muestraMenu();
	}

}
