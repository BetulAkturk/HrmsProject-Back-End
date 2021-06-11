package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Language;



public interface LanguageService {
	 DataResult<Language> getById(int id);
	 DataResult<List<Language>> getAllByJobseekerId(int id);
	 Result add(Language language);
}
