package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "jobseekers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "user_id")

public class Jobseeker extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	// @Column(name="user_id")
	// private int userId;

	@Column(name = " type_of_works_id")
	private int typeofworksId;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Column(name = "nationality_id")
	private String nationalityId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "is_verified", columnDefinition = "boolean default false")
	private boolean isVerified = false;

	

	@ManyToOne
	@JoinColumn(name = "type_of_work_id")
	private TypeOfWork typeOfWork;

	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<School> schools;
}
