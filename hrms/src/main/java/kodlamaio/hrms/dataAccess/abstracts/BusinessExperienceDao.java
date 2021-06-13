package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.BusinessExperience;

public interface BusinessExperienceDao extends JpaRepository<BusinessExperience, Integer> {
	BusinessExperience getById(int id);

	List<BusinessExperience> findAll();

	List<BusinessExperience> getAllByJobseeker_idOrderByEndAtDesc(int id);

	List<BusinessExperience> getAllByJobseeker_id(int id);

}
