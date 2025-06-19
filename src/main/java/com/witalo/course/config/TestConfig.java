package com.witalo.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.witalo.course.entities.Category;
import com.witalo.course.entities.Order;
import com.witalo.course.entities.User;
import com.witalo.course.entities.enums.OrderStatus;
import com.witalo.course.repositories.CategoryRepository;
import com.witalo.course.repositories.OrderRepository;
import com.witalo.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		User us1 = new User(null, "Maria Brown", "maria@gmail.com", "9282928292", "654321");
		User us2 = new User(null, "Andressa", "andressa@gmail.com", "40028922", "123456");
		
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID ,us1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT ,us2);
		
		
		userRepository.saveAll(Arrays.asList(us1,us2));
		orderRepository.saveAll(Arrays.asList(o1,o2));
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
	}

}
