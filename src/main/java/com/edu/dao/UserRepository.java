package com.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edu.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
   User findByEmail(String email);
   User findByUsername(String username);
   @Query(nativeQuery = true, value = "SELECT role FROM users WHERE user_name = :username")
   String getRoleByUsername(@Param("username") String username);
   @Query("SELECT CASE WHEN COUNT(u) > 0 THEN TRUE ELSE FALSE END FROM User u WHERE u.username = :username")
   boolean existsByUsername(@Param("username") String username);
   
   User findByToken(String token);
}
