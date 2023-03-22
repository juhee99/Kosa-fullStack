package day12.collection;


import java.util.Collections;
import java.util.LinkedList;

public class ProductTest2 {

	public static void main(String[] args) {
		
		LinkedList<Product2> list = new LinkedList<>();
		Product2[] products = new Product2[4];

		products[0] = new Product2("p100", "TV", "20000");
		products[1] = new Product2("p200", "Computer", "10000");
		products[2] = new Product2("p100", "MP3", "700");
		products[3] = new Product2("p300", "Audio", "1000");
		
		Collections.addAll(list, products);
		
		Collections.sort(list);
		Collections.reverse(list);
		
		System.out.println("제품 ID\t제품명\t\t가격");
		System.out.println("-------------------------------");
		for (Product2 p : list) {
			System.out.println(p);
		}

	}
}
