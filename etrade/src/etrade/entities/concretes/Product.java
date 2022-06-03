package etrade.entities.concretes;

public class Product {
	private int id;
	private String productName;
	private double price;
	private int categoryId;
	
	
	public Product() {
		super();
	}
	
	
	public Product(int id, String productName, double price, int categoryId) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.categoryId = categoryId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int category) {
		this.categoryId = category;
	}
	
}
