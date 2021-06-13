package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.BusinessExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.BusinessExperienceDao;
import kodlamaio.hrms.entities.concretes.BusinessExperience;

@Service
public class BusinessExperienceManager implements BusinessExperienceService {
	BusinessExperienceDao businessExperienceDao;

	@Autowired
	public BusinessExperienceManager(BusinessExperienceDao businessExperienceDao) {
		super();
		this.businessExperienceDao = businessExperienceDao;
	}

	public DataResult<BusinessExperience> getById(int id) {
		return new SuccessDataResult<BusinessExperience>(this.businessExperienceDao.getById(id));
	}

	@Override
	public DataResult<List<BusinessExperience>> getAllByJobseeker_idOrderByEndAtDesc(int id) {
		return new SuccessDataResult<List<BusinessExperience>>(
				this.businessExperienceDao.getAllByJobseeker_idOrderByEndAtDesc(id));

	}

	@Override
	public DataResult<List<BusinessExperience>> getAllByJobseeker_id(int id) {
		return new SuccessDataResult<List<BusinessExperience>>(this.businessExperienceDao.getAllByJobseeker_id(id));
	}

	@Override
	public Result add(BusinessExperience businessExperience) {
		this.businessExperienceDao.save(businessExperience);
		return new SuccessResult("İş tecrübesi eklendi");

	}

	@Override
	public DataResult<List<BusinessExperience>> getAll() {

		return new SuccessDataResult<List<BusinessExperience>>(this.businessExperienceDao.findAll());
	}
}
