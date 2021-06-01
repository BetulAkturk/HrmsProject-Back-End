package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "systemWorkers", "jobseekers","employers" })
public class User {
	      @Id
	      @GeneratedValue(strategy = GenerationType.IDENTITY)//id nin tek tek arttıgını belirtir
	      
	      @Column(name="id")
          private int id;
	      @Column(name="email_address")
          private String emailAddress;
	      @Column(name="password")
          private String password;
	      @Column(name="verify_code")
          private String verifyCode;
	      @Column(name="verified")
          private boolean verified;
	      
	      //@OneToMany(mappedBy = "user")
	      //private List<SystemWorker> systemWorkers;
	      
	      //@OneToMany(mappedBy = "user")
	      //private List<Jobseeker>  jobseekers;
	      
	      //@OneToMany(mappedBy = "user")
	      //private List<Employer>  employers;
	      
	      
}