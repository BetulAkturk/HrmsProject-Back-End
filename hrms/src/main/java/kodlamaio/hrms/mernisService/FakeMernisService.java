package kodlamaio.hrms.mernisService;

public class FakeMernisService {

	public boolean ValidateByPersonalInfo(long nationalityId, String firstName, String lastName, int dateOfBirth)
	{
		System.out.println(firstName + " " + lastName + " is valid person." );
		return true;
	}
}
