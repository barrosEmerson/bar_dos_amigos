package br.com.barrostech.bar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackages= {"br.*"})
public class BarApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarApplication.class, args);
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String res = encoder.encode("1234");
		System.out.println(res);
	}
}
