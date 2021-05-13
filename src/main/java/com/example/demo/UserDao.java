package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    Optional<Integer> findById(User user);
    List<User> findAll();
    User save(User user);
    void deleteById(Integer id);
}
