package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Jobseeker;



public interface JobseekerDao  extends JpaRepository<Jobseeker, Integer> { 
        Jobseeker getByNationalityId(String nationalityId);
        Jobseeker getById(int id);

}
