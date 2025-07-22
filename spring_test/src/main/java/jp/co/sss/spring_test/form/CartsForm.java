package jp.co.sss.spring_test.form;

public class CartsForm {
	    private Integer productId;
	    private String productName;
	    private String imgPath;
	    private Integer price;
	    private Integer quantity;
	    private Integer cartId;
		public Integer getProductId() {
			return productId;
		}
		public void setProductId(Integer productId) {
			this.productId = productId;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public String getImgPath() {
			return imgPath;
		}
		public void setImgPath(String imgPath) {
			this.imgPath = imgPath;
		}
		public Integer getPrice() {
			return price;
		}
		public void setPrice(Integer price) {
			this.price = price;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public Integer getCartId() {
			return cartId;
		}
		public void setCartId(Integer cartId) {
			this.cartId = cartId;
		}


}
