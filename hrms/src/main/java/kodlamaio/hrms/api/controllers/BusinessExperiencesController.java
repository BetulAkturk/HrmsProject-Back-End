package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.BusinessExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.BusinessExperience;

@RestController
@RequestMapping("/api/BusinessExperiences/")
public class BusinessExperiencesController {

	private BusinessExperienceService businessExperienceService;

	@Autowired
	public BusinessExperiencesController(BusinessExperienceService businessExperienceService) {
		super();
		this.businessExperienceService = businessExperienceService;
	}

	@GetMapping("/getbyid")
	public DataResult<BusinessExperience> getById(@RequestParam int id) {
		return this.businessExperienceService.getById(id);
	}

	@GetMapping("/getAllByJobseeker_iddOrderByEndAtDesc")
	public DataResult<List<BusinessExperience>> getAllByJobseeker_idOrderByEndAtDesc(@RequestParam int id) {
		return this.businessExperienceService.getAllByJobseeker_idOrderByEndAtDesc(id);
	}

	@GetMapping("/getAllByJobseeker_id")
	public DataResult<List<BusinessExperience>> getAllByJobseeker_id(@RequestParam int id) {
		return this.businessExperienceService.getAllByJobseeker_id(id);
	}

	@GetMapping("/getAll")
	public DataResult<List<BusinessExperience>> getAll() {
		return this.businessExperienceService.getAll();
	}
}
