package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
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
	 @GetMapping("/getAllByJobseeker_id")
	    public DataResult<List<Language>> getAllByJobseeker_id(@RequestParam int id){
	        return this.languageService.getAllByJobseeker_id(id);

  }
	 @PostMapping("/add")
	 public Result add(@RequestBody Language language) {
		 return this.languageService.add(language);
	 }
}
