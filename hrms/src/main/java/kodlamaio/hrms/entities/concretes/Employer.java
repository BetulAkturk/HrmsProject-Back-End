package kodlamaio.hrms.entities.concretes;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdverts" })
@PrimaryKeyJoinColumn(name = "userId")

public class Employer extends User {

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name = "id")
	// private int id;
	// @Column(name = "user_id")
	// private int userId;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "web_site_domain_name")
	private String websitedomainName;

	@Column(name = "is_verified", columnDefinition = "boolean default false")
	private boolean isVerified = false;

	// @ManyToOne
	// @JoinColumn(name = "user_id")
	// private User user;

	@OneToMany(mappedBy = "employer")
	private List<JobAdvert> jobAdverts;

}
