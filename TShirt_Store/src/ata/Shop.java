package ata;

import java.util.ArrayList;

public class Shop {

	private String name;
	private ArrayList<Product> products;
	private Cart cart;
    
    public Shop(String name, ArrayList<Product> products, Cart cart) {
    	this.name = name;
        this.products = products;
        this.cart = cart;
    }
    
    public void printProducts() {
    	String label = "--Products--";
    	System.out.println(label);
    	for (int i = 0; i < this.products.size(); i++) {
    		String message = String.format("ID %d: %s - $%.2f", products.get(i).getID(), products.get(i).getName(), products.get(i).getPrice());
    		System.out.println(message);
    	}
    }
  
    
    public int findProduct(String searchText) {
    	for (int i = 0; i < this.products.size(); i++) {
    		if (searchText.equals(this.products.get(i).getName())) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    public ArrayList<Product> getProducts() {
    	return this.products;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public Cart getCart() {
    	return this.cart;
    }
}
