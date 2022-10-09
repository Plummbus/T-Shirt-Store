package ata;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Menu class is responsible for greeting the user, showing a menu
 * to the user for interaction with the application.
 * The class maintains a String[] array of menu options, which it
 * uses for printing the menu to standard out.
 * The class is also responsible for responding to user interaction
 * with respect to its menu.
 */
public class Menu {
    private String[] menuOptions = {
    		"Exit", "List Products", "Buy Product", "Find Product", "Show Cart", "Checkout"
    };
    
    private Scanner scanner;
    private Shop shop;

    /**
     * Class constructor, which expects a Scanner object
     * It allows for the user to specify how a Scanner is to
     * be configured outside this class and for basic inversion of control.
     * @param scanner takes in a Scanner object to initialize
     */
    public Menu(Shop shop, Scanner scanner) {
    	this.shop = shop;
        this.scanner = scanner;
    }


    /**
     * Prints the menu to standard output, using the class's menuOptions array.
     * It accepts user input using the encapsulated Scanner instance.
     * All output is printed to standard out.
     * All input is collected from standard in.
     */
    public void executeMenu() {
        
        
        boolean menuOptionValid = false;
        
        while (!menuOptionValid) {
        	
        	printMenu();
        	int choice = scanner.nextInt();
        	
        	if (choice == MenuEnum.EXIT.label) {
        		exit();
            	menuOptionValid = true;
        	} else if (choice == MenuEnum.LIST.label) {
        		shop.printProducts();
        	} else if (choice == MenuEnum.BUY.label) {
        		System.out.println("Please enter the ID of the product you would like to purchase:");
        		int targetID = scanner.nextInt();
            	if (targetID >= 0 && targetID < shop.getProducts().size()) {
            		shop.getCart().addItem(shop.getProducts().get(targetID));
            	} else {
            		System.out.println("That item ID is invalid and could not be added to the cart.");
            	}
        	} else if (choice == MenuEnum.FIND.label) {
        		String target = askForProduct();
            	int index = shop.findProduct(target);
            	
            	if (index < 0) {
            		System.out.println("That product was not found.");
            	} else {
            		String message = String.format("%s was found and its product id is %d", shop.getProducts().get(index).getName(), shop.getProducts().get(index).getID());
            		System.out.println(message);
            	}
        	} else if (choice == MenuEnum.CART.label) {
        		shop.getCart().showDetails();
        	} else if (choice == MenuEnum.COUT.label) {
        		shop.getCart().checkout();
        	} else {
        		System.out.println("Input must be an integer between 0-5. Returning to menu.");
        	}
        	/*
        	switch (choice) {
        	case 0:
            	exit();
            	menuOptionValid = true;
            	break;
        	case 1:
            	shop.printProducts();
            	break;
        	case 2:
        		System.out.println("Please enter the ID of the product you would like to purchase:");
        		int targetID = scanner.nextInt();
            	if (targetID >= 0 && targetID < shop.getProducts().size()) {
            		shop.getCart().addItem(shop.getProducts().get(targetID));
            	} else {
            		System.out.println("That item ID is invalid and could not be added to the cart.");
            	}
            	break;
        	case 3:
            	String target = askForProduct();
            	int index = shop.findProduct(target);
            	
            	if (index < 0) {
            		System.out.println("That product was not found.");
            	} else {
            		String message = String.format("%s was found and its product id is %d", shop.getProducts().get(index).getName(), shop.getProducts().get(index).getID());
            		System.out.println(message);
            	}
            	break;
        	case 4:
            	shop.getCart().showDetails();
            	break;
        	case 5:
            	shop.getCart().checkout();
            	break;
            default:
            	System.out.println("Input must be an integer between 0-5. Returning to menu.");
            	printMenu();
            	
            	break;
        	}
        	
        	/*/
        }
        
        
    }
    
    private String askForProduct() {
    	System.out.println("Enter the item to search for:");
    	String itemToFind = getNextStringLineFromUser();
    	return itemToFind;
    }

    /**
     * Asks the user to enter their name.
     * After the user provides their name, it outputs a greeting to the user to standard out.
     */
    public void greet() {
    	System.out.println("Hello. Please enter your name:");
    	
        String name = scanner.nextLine();

        System.out.println("Welcome " + name + " to " + shop.getName());
    }

    /**
     * Prints the menu header and menu options.
     */
    private void printMenu() {
        System.out.println();
        System.out.println("--Main Menu--");
        System.out.println("Select an option using one of the numbers shown");
        System.out.println();

        for (int i = 0; i < menuOptions.length; i++) {
            System.out.print(i + ": ");
            System.out.println(menuOptions[i]);
        }
    }

    /**
     * Prints an exit statement and closes the scanner object.
     */
    private void exit() {
    	System.out.println("Exiting now. Goodbye.");
        scanner.close();
    }

    /**
     * Collects next user-entered int.
     * @return integer value denoting the user selection
     */
    private int getNextIntFromUser() {
        return scanner.nextInt();
    }

    /**
     * Skips a line of empty input from the scanner's input stream
     * and then returns the next available line.
     * @return string representing the line of input typed by the user
     */
    private String getNextStringLineFromUser() {
        scanner.nextLine();
        return scanner.nextLine();
    }
}
