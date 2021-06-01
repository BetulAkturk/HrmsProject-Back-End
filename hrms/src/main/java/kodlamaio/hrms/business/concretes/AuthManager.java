package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobseekerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.adapters.ValidationService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verification.VerificationService;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.Jobseeker;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service
public class AuthManager implements AuthService {
	private UserService userService;
	private EmployerService employerService;
	private JobseekerService jobseekerService;
	private VerificationService verificationService;
	private ValidationService validationService;
	private VerificationCodeService verificationCodeService;

	@Autowired
	public AuthManager(UserService userService, EmployerService employerService, JobseekerService jobseekerService,
			VerificationService verificationService, ValidationService validationService,
			VerificationCodeService verificationCodeService) {
		super();
		this.userService = userService;
		this.employerService = employerService;
		this.jobseekerService = jobseekerService;
		this.verificationService = verificationService;
		this.validationService = validationService;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {

		if (!checkIfNullInfoForEmployer(employer)) {

			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}

		if (!checkIfEqualEmailAndDomain(employer.getEmailAddress(), employer.getWebsitedomainName())) {

			return new ErrorResult("Invalid email address.");
		}

		if (!checkIfEmailExists(employer.getEmailAddress())) {

			return new ErrorResult(employer.getEmailAddress() + " already exists.");
		}

		if (!checkIfEqualPasswordAndConfirmPassword(employer.getPassword(), confirmPassword)) {

			return new ErrorResult("Passwords do not match.");
		}

		employerService.add(employer);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, employer.getId(), employer.getEmailAddress());
		return new SuccessResult("Registration has been successfully completed");

	}

	@Override
	public Result registerJobseeker(Jobseeker jobseeker, String confirmPassword) {

		if (checkIfRealPerson(Long.parseLong(jobseeker.getNationalityId()), jobseeker.getFirstName(),
				jobseeker.getLastName(), jobseeker.getDateOfBirth().getYear()) == false) {
			return new ErrorResult("TCKN could not be verified.");
		}

		if (!checkIfNullInfoForJobseeker(jobseeker, confirmPassword)) {

			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}

		if (!checkIfExistsTcNo(jobseeker.getNationalityId())) {

			return new ErrorResult(jobseeker.getNationalityId() + " already exists.");
		}

		if (!checkIfEmailExists(jobseeker.getEmailAddress())) {

			return new ErrorResult(jobseeker.getEmailAddress() + " already exists.");
		}

		jobseekerService.add(jobseeker);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, jobseeker.getId(), jobseeker.getEmailAddress());
		return new SuccessResult("Registration has been successfully completed");
	}

	// Validation for employer register ---START---

	private boolean checkIfNullInfoForEmployer(Employer employer) {

		if (employer.getCompanyName() != null && employer.getWebsitedomainName() != null && employer.getEmailAddress() != null
				&& employer.getPhoneNumber() != null && employer.getPassword() != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfEqualEmailAndDomain(String emailAddress, String websiteDomainName) {
		String[] emailArr = emailAddress.split("@", 2);
		String domain = websiteDomainName.substring(4, websiteDomainName.length());

		if (emailArr[1].equals(domain)) {

			return true;
		}

		return false;
	}

	// Validation for employer register ---END---

	// Validation for jobseeker register ---START---

	private boolean checkIfNullInfoForJobseeker(Jobseeker jobseeker, String confirmPassword) {

		if (jobseeker.getFirstName() != null && jobseeker.getLastName() != null && jobseeker.getNationalityId() != null
				&& jobseeker.getDateOfBirth() != null && jobseeker.getPassword() != null && jobseeker.getEmailAddress() != null
				&& confirmPassword != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfExistsTcNo(String nationalityId) {

		if (this.jobseekerService.getJobseekerByNationalityId(nationalityId).getData() == null) {
			return true;
		}
		return false;
	}

	private boolean checkIfRealPerson(long nationalityId, String firstName, String lastName, int dateOfBirth) {

		if (validationService.validateByMernis(nationalityId, firstName, lastName, dateOfBirth)) {
			return true;
		}
		return false;
	}

	// Validation for jobseeker register ---END---

	// Common Validation

	private boolean checkIfEmailExists(String emailAddress) {

		if (this.userService.getByUserEmailAddress(emailAddress).getData() == null) {

			return true;
		}

		return false;
	}

	private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {

		if (!password.equals(confirmPassword)) {
			return false;
		}

		return true;
	}

	private void verificationCodeRecord(String code, int id, String emailAddress) {

		VerificationCode verificationCode = new VerificationCode(id, code, false, LocalDate.now());
		this.verificationCodeService.add(verificationCode);
		System.out.println("Verification code has been sent to " + emailAddress);

	}


}
