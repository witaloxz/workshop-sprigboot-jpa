package com.witalo.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.witalo.course.entities.Category;
import com.witalo.course.entities.Order;
import com.witalo.course.entities.OrderItem;
import com.witalo.course.entities.Product;
import com.witalo.course.entities.User;
import com.witalo.course.entities.enums.OrderStatus;
import com.witalo.course.repositories.CategoryRepository;
import com.witalo.course.repositories.OrderItemRepository;
import com.witalo.course.repositories.OrderRepository;
import com.witalo.course.repositories.ProductRepository;
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

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		Product p1 = new Product(null, "The lord of the Rings", "Lorem ipsum dolor sit amet, consectetur", 90.5, "");
		Product p2 = new Product(null, "Smart Tv", "Nulla eu imperdiet purus. Maecenas ante", 2190.0, "");
		Product p3 = new Product(null, "Macbook", "Nam eleifend maximus tortor, at mollis", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus", 9000.0, "");

		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat3);
		p3.getCategories().add(cat1);
		p4.getCategories().add(cat3);
		p4.getCategories().add(cat1);

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

		User us1 = new User(null, "Maria Brown", "maria@gmail.com", "9282928292", "654321");
		User us2 = new User(null, "Andressa", "andressa@gmail.com", "40028922", "123456");

		userRepository.saveAll(Arrays.asList(us1, us2));

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, us1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, us2);

		orderRepository.saveAll(Arrays.asList(o1, o2));

		OrderItem or1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem or2 = new OrderItem(o2, p2, 1, p3.getPrice());
		OrderItem or3 = new OrderItem(o2, p3, 2, p3.getPrice());

		orderItemRepository.saveAll(Arrays.asList(or1, or2, or3));

	}

}
