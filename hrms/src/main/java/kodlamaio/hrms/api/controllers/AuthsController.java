package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.Jobseeker;

@RestController
@RequestMapping("/api/auths")
public class AuthsController { 
	
	  
	private AuthService authService;
    @Autowired
	public AuthsController(AuthService authService) {
		super();
		this.authService = authService;
	}
    
    @PostMapping("/registerEmployer")
	public Result registerEmployer(Employer employer, String confirmPassword) {
		return this.authService.registerEmployer(employer, confirmPassword);
    	 
    	
    }
	
    @PostMapping("/registerJobseeker")
	public Result registerJobseeker(Jobseeker jobseeker, String confirmPassword) {
		return this.authService.registerJobseeker(jobseeker, confirmPassword);
				
	}
	

}
