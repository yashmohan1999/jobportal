package com.jobportalapp.jobport.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportalapp.jobport.entities.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer>{
	
}
