package com.jobportalapp.jobport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jobportalapp.jobport.service.CandidateService;

@Controller
@RequestMapping("/jobs")
public class CandidateController {
	private CandidateService candidateService;

	public CandidateController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	
//	@GetMapping("/candidateList")
//	public String listCandidate(Model theModel) {
//		List<Candidate> theCandi=candidateService.findAll();
//		
//		return "
//	}
}
