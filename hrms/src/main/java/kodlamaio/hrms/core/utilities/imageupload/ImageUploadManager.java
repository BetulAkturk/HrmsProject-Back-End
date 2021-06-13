package kodlamaio.hrms.core.utilities.imageupload;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Service
public class ImageUploadManager implements ImageUploadService {

	private Cloudinary cloudinary;

	@Autowired
	public ImageUploadManager() {
		this.cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "ddpj0l3m0", "api_key", "827182314816226",
				"api_secret", "806Leok1mI1D8Y922J2kY3-n3Ic"));
	}

	@Override
	public DataResult<Map<String, String>> uploadImageFile(MultipartFile imageFile) {
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap = (Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(),
					ObjectUtils.emptyMap());
			return new SuccessDataResult<Map<String, String>>(resultMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return new ErrorDataResult<Map<String, String>>();
	}

}
