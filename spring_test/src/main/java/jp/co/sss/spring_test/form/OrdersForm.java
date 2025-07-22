package jp.co.sss.spring_test.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class OrdersForm {
		private Integer userId;
		private String selectedLocation; 
		private String selectedCard;
		@NotBlank(message = "名前は必須です")
		private String name;
		@NotBlank(message = "住所は必須です")
	    private String address;
	    private String apartment;
	    @NotBlank(message = "カード番号は必須です")
	    @Size(min = 15, max = 15, message = "パスワードは15文字で入力してください")
	    private String cardNumber;
	    @NotBlank(message = "有効期限は必須です")
	    @Pattern(regexp = "^(0[1-9]|1[0-2])/\\d{2}$", message = "有効期限はMM/YY形式で入力してください")
	    private String expiryDate;
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public String getSelectedLocation() {
			return selectedLocation;
		}
		public void setSelectedLocation(String selectedLocation) {
			this.selectedLocation = selectedLocation;
		}
		public String getSelectedCard() {
			return selectedCard;
		}
		public void setSelectedCard(String selectedCard) {
			this.selectedCard = selectedCard;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getApartment() {
			return apartment;
		}
		public void setApartment(String apartment) {
			this.apartment = apartment;
		}
		public String getCardNumber() {
			return cardNumber;
		}
		public void setCardNumber(String cardNumber) {
			this.cardNumber = cardNumber;
		}
		public String getExpiryDate() {
			return expiryDate;
		}
		public void setExpiryDate(String expiryDate) {
			this.expiryDate = expiryDate;
		}
	   
	    
	 
	  

}
