package com.jobportalapp.jobport.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportalapp.jobport.entities.Jobs;

public interface JobsRepository extends JpaRepository<Jobs, Integer>{
	
	
}
