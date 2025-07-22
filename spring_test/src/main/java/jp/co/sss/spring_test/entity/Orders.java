package jp.co.sss.spring_test.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_orders_gen")
	@SequenceGenerator(name = "seq_orders_gen", sequenceName = "seq_orders",allocationSize = 1)
	private Integer orderId;
	@Column(name = "userId", insertable = false, updatable = false)
	private Integer userId;
	@Column
	private Integer totalAmount;
	@Column
	private String status;
	@Column
	private String createdAt;
	@Column
	private String updatedAt;
	
	@ManyToOne
    @JoinColumn(name = "userId")
    private Users users;

    @OneToMany(mappedBy = "orders")
    private List<Order_items> orderItems;

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

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<Order_items> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<Order_items> orderItems) {
		this.orderItems = orderItems;
	}
    
	

}
