package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coverletters")
@EqualsAndHashCode(callSuper = true)
public class CoverLetter extends Base{
	
			@Column(name ="self_promotion")
			private String selfPromotion;
	
			@ManyToOne()
			@JoinColumn(name = "jobseeker_id")
			private Jobseeker jobseeker;
		

}
