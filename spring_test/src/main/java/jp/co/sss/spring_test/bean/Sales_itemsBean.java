package jp.co.sss.spring_test.bean;

import java.io.Serializable;

public class Sales_itemsBean implements Serializable {
	private Integer saleItemId;
	private Integer productId;
	private Integer companyId;
	private String saleName;
	private String description;
	private Integer discountRate;
	private String salesImgPath;
	private String startMonth;
	private String endMonth;
	private String createdAt;
	private String updatedAt;
	

	public Sales_itemsBean() {
		
	}


	public Integer getSaleItemId() {
		return saleItemId;
	}


	public void setSaleItemId(Integer saleItemId) {
		this.saleItemId = saleItemId;
	}


	public Integer getProductId() {
		return productId;
	}


	public void setProductId(Integer productId) {
		this.productId = productId;
	}


	public Integer getCompanyId() {
		return companyId;
	}


	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
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


	
}
