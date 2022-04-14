
package com.app.ecommerce.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_address")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Address extends BaseEntity {
	@Column(length = 30)
	@NotBlank(message = "City is required")
	private String city;

	@Column(length = 30)
	@NotBlank(message = "State should not be blank")
	private String state;

	@Column(length = 30)
	@NotBlank(message = "Country should not be blank")
	private String country;

	@Column(length = 10, name = "zip_code")
	@NotBlank(message = "ZipCode should not be blank")
	private String zipCode;

	@OneToOne
	@JoinColumn(name = "user_id", nullable = false) // FK
	@MapsId // to specify shared PK approach
	private User user;
}
