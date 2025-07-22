package jp.co.sss.spring_test.bean;

import java.io.Serializable;

public class CompaniesBean implements Serializable {
	private Integer companyId;
	private String companyName;  
	private String streetAddress;  
	private String representativeName;  
	private String updatedAt;
	
public CompaniesBean() {
		
	}

public Integer getCompanyId() {
	return companyId;
}

public void setCompanyId(Integer companyId) {
	this.companyId = companyId;
}

public String getCompanyName() {
	return companyName;
}

public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

public String getStreetAddress() {
	return streetAddress;
}

public void setStreetAddress(String streetAddress) {
	this.streetAddress = streetAddress;
}

public String getRepresentativeName() {
	return representativeName;
}

public void setRepresentativeName(String representativeName) {
	this.representativeName = representativeName;
}

public String getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(String updatedAt) {
	this.updatedAt = updatedAt;
}




}
