package day12.collection;

import java.util.Objects;

public class Product2 implements Comparable<Product2> {
	
	private String productID;
	private String productName;
	private String productPrice;
	
	public Product2(String productID, String productName, String productPrice) {
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean result = false;
		if (this == o)
			result= true;
		if(o !=null && o instanceof Product2) {
			Product2 p = (Product2)o;
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
				(productName.length() < 6 ?  "\t\t" : "\t" ) +String.format("%,d원", Integer.parseInt(productPrice));	
	}

	@Override
	public int compareTo(Product2 o) {
		if(Integer.parseInt(productPrice) <Integer.parseInt(o.productPrice)) return -1;
		else if(productPrice == o.productPrice) return 0;
		return 1;
	}	
}
