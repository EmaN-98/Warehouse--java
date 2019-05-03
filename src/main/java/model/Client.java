package model;

public class Client {

	private int id;
	private String name;
	private String address;
	private String email;

	public Client(int id, String name, String address, String email) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + "]";
	}

/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client c1=new Client(1,"Pop Iulia","Trandafirului 7","popiulia@gmail.com");
		System.out.println(c1);
	}*/

}