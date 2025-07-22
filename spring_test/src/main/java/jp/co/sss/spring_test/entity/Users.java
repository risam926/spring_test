package jp.co.sss.spring_test.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_users_gen")
	@SequenceGenerator(name = "seq_users_gen", sequenceName = "seq_users",allocationSize = 1)
	private Integer userId;
	@Column
	private String userName;
	@Column
	private String email;
	@Column
	private String phone;
	@Column
	private String userAddress;  
	@Column
	private String passwords;
	@Column
	private String createdAt; 
	@Column
	private String updatedAt;
	
	@OneToMany(mappedBy = "users")
    private List<Orders> orders;

    @OneToMany(mappedBy = "users")
    private List<Reviews> reviews;

    @OneToMany(mappedBy = "users")
    private List<Carts> carts;
    
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserAdress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getPasswords() {
		return passwords;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
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
