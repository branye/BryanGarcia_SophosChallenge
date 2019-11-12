package co.com.sophos.certification.challenge.util.datamanagement;

import java.util.List;

import co.com.sophos.certification.challenge.models.CurrentProduct;

public class DataManagement{
	
	private static CurrentProduct currentProduct;
	
	private DataManagement() {
		throw new IllegalStateException("Interaction class");
	}
	
	public static CurrentProduct getProductData() {
		return currentProduct;
	}

	public static void setProductData(List<String> data) {
		CurrentProduct product = new CurrentProduct();
		product.setId(data.get(0));
		product.setCategory(data.get(1));
		product.setProductName(data.get(2));
		product.setQuantity(data.get(3));
		product.setPrice(data.get(4));
		product.setExpectedResult(data.get(5));
		
		DataManagement.currentProduct = product;
	}

}
