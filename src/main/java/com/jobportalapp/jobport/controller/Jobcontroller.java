package com.jobportalapp.jobport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jobportalapp.jobport.entities.Candidate;
import com.jobportalapp.jobport.entities.Jobs;
import com.jobportalapp.jobport.service.CandidateService;
import com.jobportalapp.jobport.service.JobsServices;


@Controller
@RequestMapping("/jobs")
public class Jobcontroller {
	
	private JobsServices jobService;
	@Autowired
	private CandidateService candidateService;
	
	public Jobcontroller(JobsServices thejobService) {
		jobService = thejobService;
	}
	
	@GetMapping("/list")
	public String listJobs(Model theModel) {
		
		// get jobs from db
		List<Jobs> theJobs = jobService.findAll();
		
		// add to the spring model
		theModel.addAttribute("theJobs", theJobs);
		
		return "JobApplicationPage";
	}
	
	@GetMapping("/appliedJobs")
	public String AppliedJobs(Model theModel) {
		
		// get applied jobs from db
		List<Jobs> theJobs = jobService.findAll();
		
		// add to the spring model
		theModel.addAttribute("theJobs", theJobs);
		
		return "AppliedJobsPage";
	}

	@GetMapping("/showFormForAddJob")
	public String showFormForAddJobs(Model theModel) {
		
		// create model attribute to bind form data
		 Jobs theJobs=new Jobs();
		
		theModel.addAttribute("job", theJobs);
		
		return "jobform";
	}
	
	@PostMapping("/save")
	public String saveJobs(@ModelAttribute("job")Jobs theJobs) {
		
		System.out.print(theJobs.toString());
		
		// save the job
		jobService.save(theJobs);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/jobs/list";
	}
	
	@GetMapping("/showFormForAddCandidate/{jid}")
	public String showFormForAddCandidate(Model theModel,@PathVariable("jid")int Id) {
		
		// create model attribute to bind form data
		 Jobs theJobs=jobService.job(Id);
		 System.out.println(theJobs.toString());
		 Candidate candidate=new Candidate();
		 theJobs.addCandidate(candidate);

		theModel.addAttribute("candi", candidate);
		
		return "CandidateForm";
	}
	
	@PostMapping("/saveCandi")
	public String applyCandidate(@ModelAttribute("candi")Candidate theCandidate) {
		candidateService.save(theCandidate);
		System.out.println(theCandidate.toString());
		
		return "redirect:/jobs/list";
	}
}
