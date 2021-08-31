package com.jobportalapp.jobport.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Candidate")
public class Candidate {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	private String name;
	private String email;
	private String workExp;
	private String expectedSal;
	private String noticePeriod;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(	
				name="job_candidate",
				joinColumns = @JoinColumn(name="candidate_id"),
				inverseJoinColumns = @JoinColumn(name="job_id")
				)
	private List<Jobs> jobs;
	
	public Candidate() {
	}
	
	public Candidate(int id, String name, String email, String workExp, String expectedSal, String noticePeriod) {
		Id = id;
		this.name = name;
		this.email = email;
		this.workExp = workExp;
		this.expectedSal = expectedSal;
		this.noticePeriod = noticePeriod;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWorkExp() {
		return workExp;
	}

	public void setWorkExp(String workExp) {
		this.workExp = workExp;
	}

	public String getExpectedSal() {
		return expectedSal;
	}

	public void setExpectedSal(String expectedSal) {
		this.expectedSal = expectedSal;
	}

	public String getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(String noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	@Override
	public String toString() {
		return "Candidate [Id=" + Id + ","
				+ " name=" + name 
				+ ", email=" + email 
				+ ", workExp=" + workExp 
				+ ", expectedSal="+ expectedSal +
				", noticePeriod=" + noticePeriod 
				+ "]";
	}

	public List<Jobs> getJobs() {
		return jobs;
	}

	public void setJobs(List<Jobs> jobs) {
		this.jobs = jobs;
	}
	
	
	
}
