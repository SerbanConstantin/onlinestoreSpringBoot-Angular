package com.rosu.onlinestore;

import com.rosu.onlinestore.model.ProductCategory;
import com.rosu.onlinestore.model.User;
import com.rosu.onlinestore.repository.ProductCategoryRepository;
import com.rosu.onlinestore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;




@SpringBootApplication
public class OnlinestoreApplication implements CommandLineRunner {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(OnlinestoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User user = new User();
		user.setActive(true);
		user.setEmail("admin");
		user.setPassword(passwordEncoder().encode("admin"));

		userRepository.save(user);

		ProductCategory productCategory = new ProductCategory();
		productCategory.setCategoryName("Caramida");
		productCategory.setCategoryType(10);

		ProductCategory productCategory2 = new ProductCategory();
		productCategory2.setCategoryName("Tencuieli");
		productCategory2.setCategoryType(20);

		ProductCategory productCategory3 = new ProductCategory();
		productCategory3.setCategoryName("Vopseluri");
		productCategory3.setCategoryType(30);

		ProductCategory productCategory4 = new ProductCategory();
		productCategory4.setCategoryName("Sanitare");
		productCategory4.setCategoryType(40);


		productCategoryRepository.save(productCategory);
		productCategoryRepository.save(productCategory2);
		productCategoryRepository.save(productCategory3);
		productCategoryRepository.save(productCategory4);

	}
}