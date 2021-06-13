package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Link;
@RestController
@RequestMapping("/api/links")
public class LinksController {
		private LinkService linkService;
		@Autowired
		public LinksController(LinkService linkService) {
			super();
			this.linkService = linkService;
		}
		
		@PostMapping("/add")
		public Result add(@RequestBody Link link) {
			return this.linkService.add(link);
		}
		
		@GetMapping("/getById")
		public DataResult<Link> getById(@RequestParam int id){
			return this.getById(id);
		}
		
		@GetMapping("/getAllByJobseeker_id")
		public  DataResult<List<Link>> getAllByJobseeker_id(@RequestParam int id){
			return this.linkService.getAllByJobseeker_id(id);
		}
}
