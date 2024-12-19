package com.bootjpa.dao;

import com.bootjpa.entities.UserJpa;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface UserRepository extends CrudRepository<UserJpa, Integer> {
    public List<UserJpa> findByName(String name);

    public List<UserJpa> findByNameAndCity(String name, String city);

    public List<UserJpa> findByNameOrCity(String name, String city);

    public List<UserJpa> findByNameOrderByName(String name);        // default ordering is ascending order
//    public List<UserJpa> findByAgeBelow(Integer age);
//    public List<UserJpa> findByAgeAtMost(Integer age);
//    public List<UserJpa> findTop5ByAgeAtMostAsc(Integer age);
//    public Page findByAgeGreaterThan(int age, Pageable pageable);

    // Executing JPQL and Native Queries with Spring Data JPA | @Query @Param Annotations
    @Query("Select u from UserJpa u")
    public List<UserJpa> getAllUsers();

    @Query("Select u from UserJpa u Where u.name =:n")
    public List<UserJpa> getUserByName(@Param("n") String name);

    // using native query
    @Query(value = "Select * from user_jpa order by id asc", nativeQuery = true)
    public List<UserJpa> getUsers();
}
