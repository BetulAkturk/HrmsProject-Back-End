package kodlamaio.hrms.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "verificationcodes")
@EqualsAndHashCode(callSuper=true)
public class VerificationCode extends Base{
 
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="code")
	private String code;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	
	public VerificationCode(int userId, String code, boolean isConfirmed) {
		super();
		this.userId = userId;
		this.code = code;
		this.isConfirmed = isConfirmed;
		
	}
	
}
