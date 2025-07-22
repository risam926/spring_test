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
@Table(name = "products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_products_gen")
	@SequenceGenerator(name = "seq_products_gen", sequenceName = "seq_products",allocationSize = 1)
	
	private Integer productId;
	@Column(name = "companyId", insertable = false, updatable = false)
	private Integer companyId;
	@Column(name = "categoryId", insertable = false, updatable = false)
	private Integer categoryId;
	@Column
	private String productName;  
	@Column
	private Integer price; 
	@Column
	private Integer taxPrice;  
	@Column
	private Integer stock;  
	@Column
	private String comment;  
	@Column
	private String imgPath;
	@Column
	private Integer includeTax;  
	@Column
	private String  createdAt;  
	@Column
	private String updatedAt;
	
	
	 @ManyToOne
	 @JoinColumn(name = "companyId")
	 private Companies companies;

	 @ManyToOne
	 @JoinColumn(name = "categoryId")
	 private Categories categories;

	 @OneToMany(mappedBy = "products")
	 private List<Reviews> reviews;

	 @OneToMany(mappedBy = "products")
	 private List<Carts> carts;

	 @OneToMany(mappedBy = "products")
	 private List<Order_items> orderItems;

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

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getTaxPrice() {
		return taxPrice;
	}

	public void setTaxPrice(Integer taxPrice) {
		this.taxPrice = taxPrice;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Integer getIncludeTax() {
		return includeTax;
	}

	public void setIncludeTax(Integer includeTax) {
		this.includeTax = includeTax;
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

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public List<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}

	public List<Carts> getCarts() {
		return carts;
	}

	public void setCarts(List<Carts> carts) {
		this.carts = carts;
	}

	public List<Order_items> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<Order_items> orderItems) {
		this.orderItems = orderItems;
	}

	
	

	
}
