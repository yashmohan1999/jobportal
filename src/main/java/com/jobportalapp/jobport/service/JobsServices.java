package com.jobportalapp.jobport.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportalapp.jobport.DAO.JobsRepository;
import com.jobportalapp.jobport.entities.Jobs;

@Service
public class JobsServices {
	
	private JobsRepository jobrepository;
	
	
	@Autowired
	public JobsServices(JobsRepository jobrepository) {
		this.jobrepository = jobrepository;
	}

	public void save(Jobs theJobs) {
		jobrepository.save(theJobs);
	}
	
	public Jobs job(int Id) {
		Optional<Jobs> result = jobrepository.findById(Id);
		Jobs thejobs=null;
		if(result.isPresent()) {
			thejobs=result.get();
		}
		else {
			throw new RuntimeException("Did not find the id : "+Id);
		}
		return thejobs;
	}
	
	public List<Jobs> findAll() {
			return jobrepository.findAll();
	};
	
}
