import java.util.Scanner;
import java.util.Vector;

import adapter.Currency;
import product.machine.VendingMachine;

public class Main {
	int countVM = 0;
	Scanner scan = new Scanner(System.in);
	Vector<VendingMachine> vendingMachine = new Vector<>();
	
	public void insertNewVendingMachine() {
		String vendingType;
		boolean vendingTypeValidation = false;
		String vendingMachineProduct = null;
		
		do {
			System.out.print("Input product[Snack|Soft Drink|Smart Phone](Case insensitive): ");
			vendingType = scan.nextLine();
			
			if(vendingType.equals("Snack") || vendingType.equals("Soft Drink") || vendingType.equals("Smart Phone")) {
				vendingTypeValidation = true;
			}
			
		} while(vendingTypeValidation == false);
		
		if(vendingType.equals("Snack")) {
			vendingMachineProduct = "VendingMachineSnack";
		}
		else if(vendingType.equals("Soft Drink")) {
			vendingMachineProduct = "VendingMachineSoftDrink";
		}
		else if(vendingType.equals("Smart Phone")) {
			vendingMachineProduct = "VendingMachineSmartPhone";
		}
		
		int basePrice = 0;
		
		do {
			try {
				System.out.print("Input product base price [Price Between:(1000-120000000)]: ");
				basePrice = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.next();
				basePrice = 0;
			}
		} while(basePrice < 1000 || basePrice > 120000000);
		
		String machineName = null;
		
		do {
			System.out.print("Input machine name [Length between 6 and 16]: ");
			machineName = scan.nextLine();
		
		} while(machineName.length() < 6 || machineName.length() > 16);
		
		vendingMachine.add(new VendingMachine(machineName, basePrice, vendingMachineProduct));
	
		int quantity = 0;
		
		do {
			try {
				System.out.print("Input product quantity[Quantity between 1-10]: ");
				quantity = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.next();
				quantity = 0;
			}
		} while(quantity < 1 || quantity > 10);
		
		String productName;
		
		for(int i = 1; i <= quantity; i++) {
			System.out.print("Insert Product name ["+i+"]: ");
			productName = scan.nextLine();
			vendingMachine.get(countVM).addProduct(vendingMachineProduct, productName);
		}
		
		countVM++;
	}
	
	public void buyVendingMachineProduct() {
		if(vendingMachine.isEmpty()) {
			System.out.println("No data");
		}
		else {
			String currency;
			boolean currencyValidation = false;
			Currency curr = new Currency();
			
			do {
				System.out.print("Input your currency [IDR|USD|YEN]: ");
				currency = scan.nextLine();
				
				if(currency.equals("IDR") || currency.equals("USD") || currency.equals("YEN")) {
					if(currency.equals("USD")) {
						
					}
					else if(currency.equals("YEN")) {
						
					}
					currencyValidation = true;
				}
			} while(currencyValidation == false);
			
			
			
			int inputNumber = 0;
			
			System.out.println("No	 VM Name		Base Price			VM Product");
			System.out.println("==========================================================");
			for(int j = 0; j < countVM; j++) {
			System.out.println((j+1)+"	 "+vendingMachine.get(j).getVendingMachineName()+" 		"+vendingMachine.get(j).getBasePrice()+" 		"+vendingMachine.get(j).getVendingMachineProduct());
			}
			do {
				try {
					System.out.print("Input by number[1-"+countVM+"]: ");
					inputNumber = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					scan.next();
					inputNumber = 0;
				}
			} while(inputNumber < 1 || inputNumber > countVM);
			
			inputNumber = inputNumber - 1;
			
			System.out.println("List Product :");
			System.out.println("No 		Product Name 		Base Price");
			System.out.println("======================================");
			for(int j = 0; j < vendingMachine.get(inputNumber).getProducts().size(); j++) {
			System.out.println((j+1)+" 		"+vendingMachine.get(inputNumber).getProducts().get(j).getProductName()+" 		"+vendingMachine.get(inputNumber).getBasePrice());
			System.out.println("Press Enter to continue");
			scan.nextLine();
			}
		}
	}
	
	public void printMenu() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Vending Machine Manager");
		System.out.println("=======================");
		System.out.println("1. Insert Vending Machine");
		System.out.println("2. Buy Vending Machine Product");
		System.out.println("3. Exit");
		System.out.print(">> ");
	}
	
	public Main() {
		int choose = 0;
		
		do {
			printMenu();
			try {
				choose = scan.nextInt();
			} catch (Exception e) {
				scan.next();
				choose = 0;
			}
			scan.nextLine();
			
			switch(choose) {
				case 1 : insertNewVendingMachine(); break;
				case 2 : buyVendingMachineProduct(); break;
				case 3 : break;
			}
			
		} while(choose != 3);
	}

	public static void main(String[] args) {
		new Main();

	}
	
	

}
