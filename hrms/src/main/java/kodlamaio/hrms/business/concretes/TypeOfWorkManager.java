package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.TypeOfWorkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.TypeOfWorkDao;
import kodlamaio.hrms.entities.concretes.TypeOfWork;
@Service
public class TypeOfWorkManager implements TypeOfWorkService{

	     private TypeOfWorkDao typeOfWorkDao;
         @Autowired
		public TypeOfWorkManager(TypeOfWorkDao typeOfWorkDao) {
			super();
			this.typeOfWorkDao = typeOfWorkDao;
		}
         @Override
         public DataResult<List<TypeOfWork>> getAll(){
        	 return new SuccessDataResult<List<TypeOfWork>>( this.typeOfWorkDao.findAll(),"Data listelendi");
        			       }
		@Override
		public Result add(TypeOfWork typeOfWork) {
			this.typeOfWorkDao.save(typeOfWork);
			return new SuccessResult("Kullanıcı eklendi");
		}
		@Override
		public DataResult<TypeOfWork> getByTitle(String title) {
			return new SuccessDataResult<TypeOfWork>(this.typeOfWorkDao.getByTitle(title));
		}
}
