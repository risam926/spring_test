package jp.co.sss.spring_test.bean;

import java.io.Serializable;

public class CartsBean implements Serializable {
	private Integer cartId;
	private Integer userId;
	private Integer productId;
	private Integer quantity;
	private String createdAt;
	private String updatedAt;
	

	public CartsBean() {
		
	}


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


	
}
