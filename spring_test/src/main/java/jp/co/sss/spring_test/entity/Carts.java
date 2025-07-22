package jp.co.sss.spring_test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "carts")
public class Carts {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_carts_gen")
	@SequenceGenerator(name = "seq_carts_gen", sequenceName = "seq_carts",allocationSize = 1)
	private Integer cartId;
	@Column(name = "userId")
	private Integer userId;
	@Column(name = "productId")
	private Integer productId;
	@Column
	private Integer quantity;
	@Column
	private String createdAt;
	@Column
	private String updatedAt;
	
	@ManyToOne
	@JoinColumn(name = "userId",insertable = false, updatable = false)
	private Users users;

	@ManyToOne
	@JoinColumn(name = "productId",insertable = false, updatable = false)
	private Products products;

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}
	    
	


}
