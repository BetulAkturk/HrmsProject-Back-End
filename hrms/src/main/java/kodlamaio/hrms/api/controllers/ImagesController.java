package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.abstracts.JobseekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.Jobseeker;

@RestController
@RequestMapping("/api/İmages")
public class ImagesController {

	private ImageService imageService;
	private JobseekerService jobseekerService;

	public ImagesController(ImageService imageService, JobseekerService jobseekerService) {
		super();
		this.imageService = imageService;
		this.jobseekerService = jobseekerService;
	}

	@PostMapping(value = "/add")
	public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile) {
		Jobseeker jobseeker = this.jobseekerService.getById(id).getData();
		Image image = new Image();
		image.setJobseeker(jobseeker);
		return this.imageService.add(image, imageFile);

	}

	@GetMapping("/getById")
	public DataResult<Image> getById(@RequestParam("id") int id) {
		return this.imageService.getById(id);
	}

	@GetMapping("/getByJobseekerId")
	public DataResult<Image> getByJobseeker_id(@RequestParam int id) {
		return this.imageService.getByJobseekerId(id);
	}
}
