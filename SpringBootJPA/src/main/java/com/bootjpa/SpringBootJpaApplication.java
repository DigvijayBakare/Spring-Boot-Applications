package com.bootjpa;

import com.bootjpa.dao.UserRepository;
import com.bootjpa.entities.UserJpa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringBootJpaApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootJpaApplication.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);

        // creating UserJpa object
        UserJpa user1 = new UserJpa();
        user1.setName("Rohit Mane");
        user1.setCity("Delhi");
        user1.setStatus("I am Java Programmer");

        UserJpa user2 = new UserJpa();
        user2.setName("Hari Pethkar");
        user2.setCity("Sangli");
        user2.setStatus("I am a photographer");

        UserJpa user3 = new UserJpa();
        user3.setName("Swaraj Akhade");
        user3.setCity("Mumbai");
        user3.setStatus("I am a Software developer");

        // creating list to store or save all the objects at the same time
//        List<UserJpa> userList = List.of(user2, user3);

        // saving single object into database
//        UserJpa user = userRepository.save(user1);
//        System.out.println(user);

        // saving multiple objects into database
//        Iterable<UserJpa> result = userRepository.saveAll(userList);
//        result.forEach(System.out::println);

        // updating a user of specific id
//        Optional<UserJpa> update = userRepository.findById(1);
//        UserJpa update1 = update.get();
//        update1.setName("Rohit Patil");
//        userRepository.save(update1);
//        System.out.println("User updated successfully ");

        // retrieving the data from the database
        // findById() - returns an optional containing the object
//        Optional<UserJpa> userJpa = userRepository.findById(1);
//        System.out.println("The user with id 1 found \n" + userJpa.get());

        // findAll() - returns all the data in the iterable object
//        System.out.println("Retrieving all the user data: ");
//        Iterable<UserJpa> iterable = userRepository.findAll();
//        iterable.forEach(System.out::println);

        // deleting the user data from the database
//        userRepository.deleteById(3);
//        System.out.println("User deleted successfully...");

        // there are total 4 methods to delete the user. First one we have seen above
        // now deleteAll() - it will delete all the data from the database table
        // deleteAll(Iterable<?>) - it will take a iterable and delete only those user data from the database
        // delete(User u) - it will take the user object and delete the user by its object

        // accessing the derived methods
//        List<UserJpa> userByName = userRepository.findByName("Rohit Patil");
//        userByName.forEach(System.out::println);
//
//        List<UserJpa> userByNameAndCity = userRepository.findByNameAndCity("Rohit Patil", "Delhi");
//        userByNameAndCity.forEach(System.out::println);

        // JPQL And @Query annotation
//        List<UserJpa> list = userRepository.getAllUsers();
//        list.forEach(System.out::println);

//        List<UserJpa> list = userRepository.getUserByName("Tushar Sheri");
//        list.forEach(System.out::println);

        // executing native query
        List<UserJpa> list = userRepository.getUsers();
        list.forEach(System.out::println);
    }
}
