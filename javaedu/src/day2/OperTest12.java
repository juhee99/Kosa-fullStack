package day2;

public class OperTest12 {

	public static void main(String[] args) {
		int num = 100;
		
		System.out.println(num > 100 && ++num == 101); // 첫항 : false => 두번째 식 수행 x
		System.out.println(num);  //  100
		
		System.out.println(num > 100 || ++num == 101); // 첫항 : false => 두번째 식 수행 o
		System.out.println(num);  // 101
	}

}
