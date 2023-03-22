package day12.collection;

import java.util.Collections;
import java.util.HashSet;

public class ProductTest {

	public static void main(String[] args) {
		HashSet<Product> set = new HashSet<>();
		Product[] products = new Product[4];

		products[0] = new Product("p100", "TV", "20000");
		products[1] = new Product("p200", "Computer", "700");
		products[2] = new Product("p100", "MP3", "700");
		products[3] = new Product("p300", "Audio", "1000");

		for(Product p : products) {
			if(set.add(p)) {
				System.out.println("성공적으로 저장되었습니다.");
			}else {
				System.out.println("동일한 ID의 제품이 이미 저장되어 있습니다.");
			}
		}
		

		System.out.println("제품 ID\t제품명\t\t가격");
		System.out.println("-------------------------------");
		for (Product p : set) {
			System.out.println(p);
		}

	}

}
