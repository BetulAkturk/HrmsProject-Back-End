package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.BusinessExperience;

public interface BusinessExperienceService {

	DataResult<BusinessExperience> getById(int id);
	DataResult<List<BusinessExperience>> getAllByJobseeker_idOrderByEndAtDesc(int id);
    Result add(BusinessExperience businessExperience);
	DataResult<List<BusinessExperience>> getAllByJobseeker_id(int id);
}
