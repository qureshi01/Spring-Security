package com.excelr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.model.AppUser;
@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Integer> {
	public AppUser findByUsername(String username);
}
