package com.externshipproject.FoodOrderingSystemTeam110;

import com.externshipproject.FoodOrderingSystemTeam110.model.RegisterUserRequest;
import com.externshipproject.FoodOrderingSystemTeam110.model.User;
import com.externshipproject.FoodOrderingSystemTeam110.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FoodOrderingSystemTeam110Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FoodOrderingSystemTeam110Application.class, args);
		initAdminUsers(context);
	}
	private static void initAdminUsers(ConfigurableApplicationContext context) {
		UserService userService = context.getBean(UserService.class);

		RegisterUserRequest admin1 = new RegisterUserRequest();
		admin1.setUsername("admin1");
		admin1.setPassword("admin123");
		admin1.setAdmin(true);
		userService.registerUser(admin1);

		RegisterUserRequest admin2 = new RegisterUserRequest();
		admin2.setUsername("admin2");
		admin2.setPassword("admin456");
		admin2.setAdmin(true);
		userService.registerUser(admin2);


	}
}
