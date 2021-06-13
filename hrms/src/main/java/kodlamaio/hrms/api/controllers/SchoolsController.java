package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.School;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {
	
	 private SchoolService schoolService;

	public SchoolsController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	 
	@GetMapping("/getbyid")
	  public DataResult<School> getById(@RequestParam int id){
		  return this.schoolService.getById(id);
	  }
	
	@GetMapping("/getAllByJobseeker_idOrderByEndAtDesc")
	     public DataResult<List<School>> getAllByJobseeker_idOrderByEndAtDesc(@RequestParam int id){
		   return this.schoolService.getAllByJobseekerIdOrderByEndAtDesc(id);
	}
	
	@GetMapping("/getAllByJobseeker_id")
	     public DataResult<List<School>> getAllByJobseeker_id(@RequestParam int id){
		   return this.schoolService.getAllByJobseeker_id(id);
	}
	 

}
