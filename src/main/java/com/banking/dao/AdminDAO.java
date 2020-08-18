package com.banking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.model.Admin;

@Repository
public interface AdminDAO extends JpaRepository<Admin, Integer> {

	Admin findByUsername(String username);

}
