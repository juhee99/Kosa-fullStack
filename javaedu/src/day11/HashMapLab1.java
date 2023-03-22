package day11;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;


public class HashMapLab1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String,Integer> map = new HashMap();
		String country ;
		int population;
		while(map.size()<5) {
			
			try {
				System.out.print("나라이름을 입력하세요 : ");
				country = sc.next();
				sc.nextLine();
				System.out.print("인구 수를 입력하세요 : ");
				population = sc.nextInt();	
				
				if(map.containsKey(country)) {
					System.out.printf("*나라명 %s는 이미 저장되었습니다.*\n",country);
				}else {
					map.put(country,population);
					System.out.println("*저장되었습니다.*");
				}
				
			}catch(InputMismatchException e) {
				System.out.println("다시 입력해 주세요.");
				sc.nextLine();
				continue;
			}
		}
	
		System.out.println("5개가 모두 입력되었습니다.");
		
		int cnt = 0;
		System.out.print("입력된 데이터 : ");
		for(String key : map.keySet()) {
			System.out.printf("%s(%d)", key, map.get(key));
			cnt++;
			if(cnt != map.size()) {
				System.out.print(",");
			}
		
		}		
	}

}
