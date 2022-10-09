package ata;

public class Product {

	private String name;
	private double price;
	private int id;
	
	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	public int getID() {
		return this.id;
	}
	
	
}
