package com.projeto.curso.config;

import java.util.Arrays;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projeto.curso.entities.Category;
import com.projeto.curso.entities.Order;
import com.projeto.curso.entities.Product;
import com.projeto.curso.entities.User;
import com.projeto.curso.entities.enums.OrderStatus;
import com.projeto.curso.repositories.CategoryRepository;
import com.projeto.curso.repositories.OrderRepository;
import com.projeto.curso.repositories.ProductRepository;
import com.projeto.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired // ** Obs abaixo
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        
        Category cat1 = new Category(null, "Books");
        Category cat2 = new Category(null, "Music");
        Category cat3 = new Category(null, "Games");

        Product product1 = new Product(null, "The Hobbit", "Lorem ipsum", 25.5, "");
        Product product2 = new Product(null, "Dark Souls Remastered", "Lorem ipsum", 29.9, "");
        Product product3 = new Product(null, "All Eyez on Me", "Lorem ipsum", 85.5, "");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(product1, product2, product3));

        product1.getCategories().add(cat1);
        product2.getCategories().add(cat3);
        product3.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(product1, product2, product3));

        User user1 = new User(null, "Walter White", "ww@email.com", "111222333");
        User user2 = new User(null, "Jack Black", "jb@email.com", "111222334");
    
        Order order1 = new Order(null, Instant.parse("2024-10-22T13:13:13Z"), user1, OrderStatus.PAID);
        Order order2 = new Order(null, Instant.parse("2024-10-22T14:14:14Z"), user2, OrderStatus.WAITING_PAYMENT);
        Order order3 = new Order(null, Instant.parse("2024-10-22T15:15:15Z"), user1, OrderStatus.WAITING_PAYMENT);


        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    }

    // ** Sem a anotação, a injeção deveria ser feita manualmente, 
    // via construtor; Exemplo:
        // private final UserRepository userRepository;
        // public TestConfig(UserRepository userRepository) {
        //     this.userRepository = userRepository;
        // }
    // pro: ideal para garantir imutabilidade 
}
