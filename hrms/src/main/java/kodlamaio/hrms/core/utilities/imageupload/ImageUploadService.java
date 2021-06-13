package kodlamaio.hrms.core.utilities.imageupload;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface ImageUploadService {
	
	DataResult<Map<String, String>> uploadImageFile(MultipartFile imageFile);

}
