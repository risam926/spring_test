package jp.co.sss.spring_test.bean;

import java.io.Serializable;

public class Order_itemsBean implements Serializable {
	private Integer orderItemId;
	private Integer orderId;
	private Integer productId;
	private Integer quantity;
	private Integer price;
	private String createdAt;
	private String updatedAt;
	
public Order_itemsBean() {
		
	}

public Integer getOrderItemId() {
	return orderItemId;
}

public void setOrderItemId(Integer orderItemId) {
	this.orderItemId = orderItemId;
}

public Integer getOrderId() {
	return orderId;
}

public void setOrderId(Integer orderId) {
	this.orderId = orderId;
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

public Integer getPrice() {
	return price;
}

public void setPrice(Integer price) {
	this.price = price;
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
