package co.user.api.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "USERS")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@Column(unique = true)
	private String email;

	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date created;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date modified;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date lastLogin;

	private String token;

	private Boolean isActive;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "userPhone", joinColumns = {
			@JoinColumn(name = "idUser", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "idPhone", referencedColumnName = "id") })
	private List<PhoneEntity> phones;

}
