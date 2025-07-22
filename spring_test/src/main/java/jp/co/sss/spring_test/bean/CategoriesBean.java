package jp.co.sss.spring_test.bean;

import java.io.Serializable;

public class CategoriesBean implements Serializable {
	private Integer categoryId;
	private String categoryName;
	private String description;
	private Integer parentId;
	private String createdAt;
	private String updatedAt;
	
public CategoriesBean() {
		
	}

public Integer getCategoryId() {
	return categoryId;
}

public void setCategoryId(Integer categoryId) {
	this.categoryId = categoryId;
}

public String getCategoryName() {
	return categoryName;
}

public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Integer getParentId() {
	return parentId;
}

public void setParentId(Integer parentId) {
	this.parentId = parentId;
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
