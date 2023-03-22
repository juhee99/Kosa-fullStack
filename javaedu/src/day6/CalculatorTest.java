package day6;

import java.util.Scanner;

class CalculatorExpr {
	private int num1;
	private int num2;
		
	CalculatorExpr(int num1 , int num2){
		this.num1= num1;
		this.num2 = num2;
	}
	
	int getAddition() {
		return num1 + num2;
	}
	int getSubtraction() {
		if(num2>num1) return num2-num1;
		return num1-num2;
	}
	
	int getMultiplication() {
		return num1 * num2;
	}
	
	double getDivision() {
		if(num2 == 0 || num1 == 0) return 0;
		return num1/(double)num2;
	}
}
public class CalculatorTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CalculatorExpr cal ;
		int num1=0 , num2=0;
		char check = 'y';
		
		while(true) {
			System.out.print("두개 숫자를 입력하세요 : ");
			num1 =  sc.nextInt();
			num2 = sc.nextInt();
		
			cal = new CalculatorExpr(num1,num2);
			
			System.out.println("덧셈 : "+cal.getAddition());
			System.out.println("뺄셈 : "+cal.getSubtraction());
			System.out.println("곱셈 : "+cal.getMultiplication());
			System.out.println("나눗셈 : "+cal.getDivision());
			
			sc.nextLine();
			System.out.println("계속 하시겠습니까?(y/n)");
			check = sc.next().charAt(0);
			
			
			if(check == 'n') {
				System.out.println("종료하겠습니다.");
				sc.close();
				break;
			}	
		}
	}
}
