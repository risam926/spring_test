package jp.co.sss.spring_test.form;

public class ReviewsForm {
	private Integer reviewId;
	private Integer userId;
	private String email;
	private Integer productId;
	private Integer rating;
	private String comment;
	private String dummyUserName;
	private String reviewImgPath;
	private String createdAt;
	private String updatedAt;
	
	public Integer getReviewId() {
		return reviewId;
	}
	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
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
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDummyUserName() {
		return dummyUserName;
	}
	public void setDummyUserName(String dummyUserName) {
		this.dummyUserName = dummyUserName;
	}
	public String getReviewImgPath() {
		return reviewImgPath;
	}
	public void setReviewImgPath(String reviewImgPath) {
		this.reviewImgPath = reviewImgPath;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
