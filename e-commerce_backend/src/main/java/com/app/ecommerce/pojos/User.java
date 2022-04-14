package com.app.ecommerce.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class User extends BaseEntity {

	@NotBlank(message = "First name required")
	@Length(min = 3, max = 29, message = "First name must have length greater than 3")
	@Column(length = 30, name = "first_name") // DB column name : first_name
	@JsonProperty("firstName") // name in front-end : firstName
	// pojo property name : firstName
	private String firstName;

	@Length(min = 3, max = 29, message = "Last name must have length greater than 3")
	@Column(length = 30, name = "last_name")
	@JsonProperty("lastName")
	private String lastName;

	@Column(length = 30, unique = true)
	@NotBlank(message = "Email can't be blank") // for string data members
	@Email(message = "Invalid Email format")
	private String email;

	@NotBlank(message = "Invalid password")
	private String password;

	@Transient // skips from persistence
	private String confirmPassword;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", 
						joinColumns = @JoinColumn(name = "user_id"), 
						inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	@Column(length = 10, name = "phone_no")
	@NotBlank(message = "Phone number required")
	@Pattern(regexp = "(^[0-9]{10}$)", message = "Invalid phone number")
	private String phone;

	@NotBlank(message = "Category name is required")
	@Column(name = "category_name")
	private String categoryName;


	@JsonIgnore
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, 
						orphanRemoval = true, fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private Address address;
}
