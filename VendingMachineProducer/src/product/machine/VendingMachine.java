package product.machine;

import java.util.Vector;

import product.Product;
import product.SmartPhoneProduct;
import product.SnackProduct;
import product.SoftDrinkProduct;

public class VendingMachine {
	private static VendingMachine vm;
	private String vendingMachineName;
	private int basePrice;
	private String vendingMachineProduct;
	
	private Vector<Product> products = new Vector<>();
	
	private VendingMachine() {
		
	}

	public VendingMachine(String vendingMachineName, int basePrice, String vendingMachineProduct) {
		
		this.vendingMachineName = vendingMachineName;
		this.basePrice = basePrice;
		this.vendingMachineProduct = vendingMachineProduct;
	}

	public String getVendingMachineName() {
		return vendingMachineName;
	}

	public void setVendingMachineName(String vendingMachineName) {
		this.vendingMachineName = vendingMachineName;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

	public String getVendingMachineProduct() {
		return vendingMachineProduct;
	}

	public void setVendingMachineProduct(String vendingMachineProduct) {
		this.vendingMachineProduct = vendingMachineProduct;
	}

	public Vector<Product> getProducts() {
		return products;
	}

	public void setProducts(Vector<Product> products) {
		this.products = products;
	}
	
	public void addProduct(String vendingType, String productName) {
		if(vendingType.equals("VendingMachineSnack")) {
			getProducts().add(new SnackProduct(productName));
		}
		else if(vendingType.equals("VendingMachineSoftDrink")) {
			getProducts().add(new SoftDrinkProduct(productName));
		}
		else if(vendingType.equals("VendingMachineSmartPhone")) {
			getProducts().add(new SmartPhoneProduct(productName));
		}
	}

	public synchronized static VendingMachine getInstance() {
		if(vm == null)
			vm = new VendingMachine();
		
		return vm;
	}
}
