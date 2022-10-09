package ata;

import java.util.ArrayList;

public class Cart {

	
	private ArrayList<Product> items;
	private double total;
	private double taxRate;
	
	public Cart() {
		this.items = new ArrayList<Product>();
		this.total = 0.00;
		taxRate = 1.1;	//10%
	}
	
	public void addItem(Product p) {
		items.add(p);
		total += p.getPrice();
		System.out.printf("%s has been added to your cart.\n", p.getName());
	}
	
	public void showDetails() {
		if (items.size() == 0) {
			System.out.println("The cart is empty. Please add at least one product to see it in the cart.");
		} else {
			System.out.printf("--Cart--"
					+ "\nItem Count: %d"
					+ "\nItems:", items.size());
			for (int i = 0; i < items.size(); i++) {
				System.out.printf("\n%s: $%.2f", items.get(i).getName(), items.get(i).getPrice());
			}
			System.out.printf("\n\nPre-Tax Total: $%.2f"
					+ "\nPost-Tax Total (10.00%% Tax): $%.2f\n", total, total * taxRate);
		}
	}
	
	public void checkout() {
		if (items.size() == 0) {
			System.out.println("Your cart is currently empty. Please add at least one product to check out.");
		} else {
			empty();
		}
		
	}
	
	private void empty() {
		System.out.printf("Your total is $%.2f"
				+ "\nThank you for shopping at T-Shirt Mart.\n", total * taxRate);
		total = 0.0;
		items.clear();

	}
}
