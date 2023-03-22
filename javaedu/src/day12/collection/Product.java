package day12.collection;

import java.util.Objects;

public class Product {
	private String productID;
	private String productName;
	private String productPrice;
	
	public Product(String productID, String productName, String productPrice) {
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean result = false;
		if (this == o)
			result= true;
		if(o !=null && o instanceof Product) {
			Product p = (Product)o;
			if(productID.equals(p.productID)) 
				result = true;	
		}
		return result;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(productID);
	}
	
	@Override
	public String toString() {
		return productID +"\t"+ productName+
				(productName.length() < 6 ?  "\t\t" : "\t" ) +productPrice;	
	}	
}
