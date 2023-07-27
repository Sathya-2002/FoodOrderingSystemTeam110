package com.externshipproject.FoodOrderingSystemTeam110;

import com.externshipproject.FoodOrderingSystemTeam110.model.FoodItem;
import com.externshipproject.FoodOrderingSystemTeam110.model.RegisterUserRequest;
import com.externshipproject.FoodOrderingSystemTeam110.model.Restaurant;
import com.externshipproject.FoodOrderingSystemTeam110.service.FoodItemService;
import com.externshipproject.FoodOrderingSystemTeam110.service.RestaurantService;
import com.externshipproject.FoodOrderingSystemTeam110.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FoodOrderingSystemTeam110Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FoodOrderingSystemTeam110Application.class, args);
//		initialValues(context);
	}
	private static void initialValues(ConfigurableApplicationContext context) {
		UserService userService = context.getBean(UserService.class);
		RegisterUserRequest admin1 = new RegisterUserRequest();
		RegisterUserRequest admin2 = new RegisterUserRequest();
		RegisterUserRequest user1 = new RegisterUserRequest();
		RegisterUserRequest user2 = new RegisterUserRequest();
		FoodItem idli = new FoodItem();
		FoodItem chapathi = new FoodItem();
		FoodItem dosa = new FoodItem();
		FoodItem pongal = new FoodItem();
		Restaurant restaurant1 = new Restaurant();
		Restaurant restaurant2 = new Restaurant();
		List<FoodItem> foodList1 = new ArrayList<>();
		List<FoodItem> foodList2=new ArrayList<>();
		List<Restaurant> resList1 = new ArrayList<>();
		List<Restaurant> resList2 = new ArrayList<>();
		List<Restaurant> resList3 = new ArrayList<>();

		admin1.setUsername("admin1");
		admin1.setPassword("admin123");
		admin1.setAdmin(true);
		admin1.setRestaurant(true);
		userService.registerUser(admin1);
		admin2.setUsername("admin2");
		admin2.setPassword("admin456");
		admin2.setAdmin(true);
		userService.registerUser(admin2);
		user1.setUsername("Vijay");
		user1.setPassword("vijay");
		userService.registerUser(user1);
		user2.setUsername("Sanjay");
		user2.setPassword("vijay");
		user2.setRestaurant(true);
		userService.registerUser(user2);
		idli.setId(234L);
		idli.setName("Idli");
		idli.setDesc("Idli is a traditional, savory Indian cake that is a popular breakfast item in numerous South Indian households, although it can be found throughout the country. It is made with a batter consisting of fermented lentils and rice, which is then steamed.");
		idli.setPrice(20);
		chapathi.setId(345L);
		chapathi.setName("Chapati");
		chapathi.setDesc("A round flat unleavened bread of India that is usually made of whole wheat flour and cooked on a griddle.");
		chapathi.setPrice(20);
		dosa.setId(567L);
		dosa.setName("Dosa");
		dosa.setDesc("A dosa is South Indian, fermented crepe made from rice batter and black lentils.");
		dosa.setPrice(20);
		pongal.setId(678L);
		pongal.setName("Pongal");
		pongal.setDesc("Popular South Indian breakfast made with rice and yellow moong lentils.");
		pongal.setPrice(20);
		restaurant1.setId(123L);
		restaurant1.setName("Darling Bakery");
		restaurant1.setLocation("75, Officers Lane, Vellore");
		restaurant2.setId(456L);
		restaurant1.setName("Shanthi Bakery");
		restaurant1.setLocation("75, VIT Road, Vellore");
		foodList1.add(idli);
		foodList1.add(pongal);
		foodList1.add(dosa);
		foodList2.add(pongal);
		foodList2.add(dosa);
		foodList2.add(chapathi);
		resList1.add(restaurant1);
		resList2.add(restaurant2);
		resList3.add(restaurant1);
		resList3.add(restaurant2);
		restaurant1.setFoodItems(foodList1);
		restaurant2.setFoodItems(foodList2);
		idli.setRestaurants(resList1);
		pongal.setRestaurants(resList3);
		dosa.setRestaurants(resList3);
		chapathi.setRestaurants(resList2);

		FoodItemService foodItemService = new FoodItemService();
		RestaurantService restaurantService = new RestaurantService();
		restaurantService.addRestaurant(restaurant1);
		restaurantService.addRestaurant(restaurant2);
		foodItemService.createFoodItem(idli);
		foodItemService.createFoodItem(dosa);
		foodItemService.createFoodItem(chapathi);
		foodItemService.createFoodItem(pongal);
	}
}
