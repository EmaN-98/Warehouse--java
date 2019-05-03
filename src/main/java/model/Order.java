package model;

public class Order {
	private int id_o;
	private String name;
	public Order(int id_o, String name) {
		super();
		this.id_o = id_o;
		this.name=name;
	}

	public int getId_o() {
		return id_o;
	}

	public void setId_o(int id_o) {
		this.id_o = id_o;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Order [id_o=" + id_o + ", name=" + name + "]";
	}
	
	
	
}

