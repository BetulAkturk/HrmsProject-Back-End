package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;

import kodlamaio.hrms.entities.concretes.Language;
@RestController
@RequestMapping("/api/Languages/")

public class LanguagesController {
	
	private LanguageService languageService;
	@Autowired
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	 @GetMapping("/getbyid")
		public DataResult<Language> getById(@RequestParam int id){
			return this.languageService.getById(id);
		}
	 @GetMapping("/getAllByJobseekerId")
	    public DataResult<List<Language>> getAllByJobseekerId(@RequestParam int id){
	        return this.languageService.getAllByJobseekerId(id);

  }
}
