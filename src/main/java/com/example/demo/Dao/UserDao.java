package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.User;

public interface UserDao extends JpaRepository<User, Long>{
	User findByEmail(String email);
}
