package jp.co.sss.spring_test.bean;

import java.io.Serializable;

public class OrdersBean implements Serializable {
	private Integer orderId;
	private Integer userId;
	private Integer totalAmount;
	private String status;
	private String createdAt;
	private String updatedAt;
	
public OrdersBean() {
		
	}

public Integer getOrderId() {
	return orderId;
}

public void setOrderId(Integer orderId) {
	this.orderId = orderId;
}

public Integer getUserId() {
	return userId;
}

public void setUserId(Integer userId) {
	this.userId = userId;
}

public Integer getTotalAmount() {
	return totalAmount;
}

public void setTotalAmount(Integer totalAmount) {
	this.totalAmount = totalAmount;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
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
