package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.School;

public interface SchoolService {
	   
	   DataResult<School> getById(int id);
	   DataResult<List<School>> getAllByJobseekerIdOrderByEndAtDesc(int id);
	   DataResult<List<School>> getAllByJobseeker_id(int id);
	   Result add(School school);

}
