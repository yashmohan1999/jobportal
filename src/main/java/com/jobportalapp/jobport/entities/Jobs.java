package com.jobportalapp.jobport.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Jobs")
public class Jobs {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String JobTitle;
	@Column(length = 5000)
	private String JobDescription;
	@Column(length = 500)
	private String keyResponsiblity;
	@Column(length = 200)
	private String EligblityCriteria;
	private String Experience;
	private String Location;
	private String postion;
	private String Education;
	@Column(length = 500)
	private String keySkills;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(	
				name="job_candidate",
				joinColumns = @JoinColumn(name="job_id"),
				inverseJoinColumns = @JoinColumn(name="candidate_id")
				)
	private List<Candidate> candidate;
	
	
	
	public List<Candidate> getCandidate() {
		return candidate;
	}


	public void setCandidate(List<Candidate> candidate) {
		this.candidate = candidate;
	}


	public Jobs() {
	}


	public Jobs(int id, String jobTitle, String jobDescription, String keyResponsiblity, String eligblityCriteria,
			String experience, String location, String postion, String education, String keySkills) {
		this.id = id;
		JobTitle = jobTitle;
		JobDescription = jobDescription;
		this.keyResponsiblity = keyResponsiblity;
		EligblityCriteria = eligblityCriteria;
		Experience = experience;
		Location = location;
		this.postion = postion;
		Education = education;
		this.keySkills = keySkills;
	}
	
	
	public Jobs(String jobTitle, String jobDescription, String keyResponsiblity, String eligblityCriteria,
			String experience, String location, String postion, String education, String keySkills) {
		JobTitle = jobTitle;
		JobDescription = jobDescription;
		this.keyResponsiblity = keyResponsiblity;
		EligblityCriteria = eligblityCriteria;
		Experience = experience;
		Location = location;
		this.postion = postion;
		Education = education;
		this.keySkills = keySkills;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobTitle() {
		return JobTitle;
	}
	public void setJobTitle(String jobTitle) {
		JobTitle = jobTitle;
	}
	public String getJobDescription() {
		return JobDescription;
	}
	public void setJobDescription(String jobDescription) {
		JobDescription = jobDescription;
	}
	public String getKeyResponsiblity() {
		return keyResponsiblity;
	}
	public void setKeyResponsiblity(String keyResponsiblity) {
		this.keyResponsiblity = keyResponsiblity;
	}
	public String getEligblityCriteria() {
		return EligblityCriteria;
	}
	public void setEligblityCriteria(String eligblityCriteria) {
		EligblityCriteria = eligblityCriteria;
	}
	public String getExperience() {
		return Experience;
	}
	public void setExperience(String experience) {
		Experience = experience;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getPostion() {
		return postion;
	}
	public void setPostion(String postion) {
		this.postion = postion;
	}
	public String getEducation() {
		return Education;
	}
	public void setEducation(String education) {
		Education = education;
	}
	public String getKeySkills() {
		return keySkills;
	}
	public void setKeySkills(String keySkills) {
		this.keySkills = keySkills;
	}
	public void addCandidate(Candidate theCandidate) {
		if(candidate==null) {
			candidate=new ArrayList<>();
		}
		candidate.add(theCandidate);
	}
	

	@Override
	public String toString() {
		return "jobs [id=" + id + ", JobTitle=" + JobTitle + ", JobDescription=" + JobDescription
				+ ", keyResponsiblity=" + keyResponsiblity + ", EligblityCriteria=" + EligblityCriteria
				+ ", Experience=" + Experience + ", Location=" + Location + ", postion=" + postion + ", Education="
				+ Education + ", keySkills=" + keySkills + "]";
	
	}
	
	
	
}
