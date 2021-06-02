package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "typeofworks")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdverts", "jobseekers" })

public class TypeOfWork {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	private LocalDate createdDate = LocalDate.now();

	@Column(name = "is_active", columnDefinition = "boolean default true")
	private boolean isActive = true;

	@Column(name = "is_deleted", columnDefinition = "boolean default false")
	private boolean isDeleted = false;

	@OneToMany(mappedBy = "typeOfWork")
	private List<Jobseeker> jobseekers;

	@OneToMany(mappedBy = "typeOfWork")
	private List<JobAdvert> jobAdverts;
}
