package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobseekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobseekerDao;
import kodlamaio.hrms.entities.concretes.Jobseeker;
@Service
public class JobseekerManager implements JobseekerService {

	   private JobseekerDao JobseekerDao;
	   @Autowired
	public JobseekerManager(kodlamaio.hrms.dataAccess.abstracts.JobseekerDao jobseekerDao) {
		super();
		JobseekerDao = jobseekerDao;
	}
	@Override
	public  DataResult<List<Jobseeker>> getAll() {
	
		return new SuccessDataResult<List<Jobseeker>>(this.JobseekerDao.findAll(), "Data listelendi");
				
	}
	@Override
	public Result add(Jobseeker jobseeker) {
		this.JobseekerDao.save(jobseeker);
		return new SuccessResult("Kullanıcı eklendi");
	}
	@Override
	public DataResult<Jobseeker> getJobseekerByNationalityId(String nationalityId) {
		return new SuccessDataResult<Jobseeker>(this.JobseekerDao.getByNationalityId(nationalityId),
				"İş arayan kimlik id'ye göre getirildi");
	}

}
