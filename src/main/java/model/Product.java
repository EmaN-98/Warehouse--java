package model;

public class Product {
	private int id_p;
	private String name;
	private float price;
	private int number;
	
	public Product(int id_p, String name, float price, int number) {
		super();
		this.id_p = id_p;
		this.name = name;
		this.price = price;
		this.number = number;
	}

	public int getId_p() {
		return id_p;
	}

	public void setId_p(int id_p) {
		this.id_p = id_p;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Product [id_p=" + id_p + ", name=" + name + ", price=" + price + ", number=" + number + "]";
	}
	
	
	
}
