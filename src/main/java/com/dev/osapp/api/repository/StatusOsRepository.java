package com.dev.osapp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.osapp.api.model.StatusOs;

public interface StatusOsRepository extends JpaRepository<StatusOs, Long>{
	
	
}
