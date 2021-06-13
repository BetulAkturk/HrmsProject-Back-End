package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Jobseeker;

public interface JobseekerService {
	  DataResult<Jobseeker> getById(int id);
	  DataResult<List<Jobseeker>> getAll();
      Result add(Jobseeker jobseeker);
      DataResult<Jobseeker> getJobseekerByNationalityId(String nationalityId);
}
