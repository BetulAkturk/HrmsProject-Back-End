package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.TypeOfWork;

public interface TypeOfWorkService {
	 DataResult<List<TypeOfWork>> getAll();
	 Result add(TypeOfWork typeOfWork);
	 DataResult<TypeOfWork> getByTitle(String title);
}
