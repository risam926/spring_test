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
@Table(name = "sales_items")
public class Sales_items {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sales_items_gen")
	@SequenceGenerator(name = "seq_sales_items_gen", sequenceName = "seq_sales_items",allocationSize = 1)
	private Integer saleItemId;
	@Column(name = "companyId", insertable = false, updatable = false)
	private Integer companyId;
	@Column(name = "productId", insertable = false, updatable = false)
	private Integer productId;
	@Column
	private String saleName;
	@Column
	private String description;
	@Column
	private Integer discountRate;
	@Column
	private String salesImgPath;
	@Column
	private String startMonth;
	@Column
	private String endMonth;
	@Column
	private String createdAt;
	@Column
	private String updatedAt;
	

	@ManyToOne
	@JoinColumn(name = "companyId")
	private Companies companies;

	@ManyToOne
	@JoinColumn(name = "productId")
	private Products products;

	public Integer getSaleItemId() {
		return saleItemId;
	}

	public void setSaleItemId(Integer saleItemId) {
		this.saleItemId = saleItemId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getSaleName() {
		return saleName;
	}

	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(Integer discountRate) {
		this.discountRate = discountRate;
	}

	public String getSalesImgPath() {
		return salesImgPath;
	}

	public void setSalesImgPath(String salesImgPath) {
		this.salesImgPath = salesImgPath;
	}

	public String getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	public String getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
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

	public Companies getCompanies() {
		return companies;
	}

	public void setCompanies(Companies companies) {
		this.companies = companies;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}
	
	

}
