package com.app.ecommerce.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cart")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Cart extends BaseEntity {
	@Column(name = "created_date")
	private Date createdDate;

	@Min(0)
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@JsonIgnore
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
}
