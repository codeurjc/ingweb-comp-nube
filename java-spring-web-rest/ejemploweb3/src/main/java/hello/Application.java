package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Application {
	
	@Bean
	public UsersService usersService(){
		return new FakeUsersService();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}