package com.jobportalapp.jobport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportalapp.jobport.DAO.CandidateRepository;
import com.jobportalapp.jobport.entities.Candidate;

@Service
public class CandidateService {
	
	private CandidateRepository candidateRepository;
	
	@Autowired
	public CandidateService(CandidateRepository candidateRepository) {
		this.candidateRepository = candidateRepository;
	}
	
	public void save(Candidate candidate) {
		candidateRepository.save(candidate);
	}
	
	public List<Candidate> findAll(){
		return candidateRepository.findAll();
	}
}
