package com.multidb;

import com.multidb.mongodb.entities.ProductMongo;
import com.multidb.mongodb.entities.User;
import com.multidb.mongodb.repositories.ProductRepositoryMongo;
import com.multidb.mongodb.repositories.UserRepository;
import com.multidb.postgres.entities.Product;
import com.multidb.postgres.entities.UserPostgres;
import com.multidb.postgres.repositories.ProductRepository;
import com.multidb.postgres.repositories.UserRepositoryPostgres;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MultipleDatabaseConfigApplicationTests {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepositoryMongo productRepositoryMongo;
    @Autowired
    private UserRepositoryPostgres userRepositoryPostgres;

    @Test
    public void dbTest() {
        System.out.println("Testing!!");
//        Product product = new Product(1,"Bottle","For drinking water",true,200.00);

        Product product = Product.builder().
                id(1).name("Bottle").description("For drinking water").live(true).price(200.00)
                .build();
        productRepository.save(product);

        User user = new User(1,"Digvijay","Bakare","mnoxyx31@gmail.com");
        userRepository.save(user);

        System.out.println("Both data's saved in the resp databases");
    }

    @Test
    public void getData() {
        productRepository.findAll().forEach(System.out::println);
        userRepository.findAll().forEach(System.out::println);
    }

    @Test
    public void swappingData() {
        Product product = productRepository.findById(1).orElse(new Product());
        ProductMongo mongo = new ProductMongo(product.getId(), product.getName(), product.getDescription(), product.isLive(), product.getPrice());
//        productRepositoryMongo.save(mongo);

        User user = userRepository.findById(1).orElse(new User());
        UserPostgres postgres = new UserPostgres(user.getId(), user.getfName(), user.getlName(), user.getEmail());
        userRepositoryPostgres.save(postgres);

        System.out.println("Data saved from postgres to Mongodb!");
    }
}
