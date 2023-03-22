package day7;

import day5.MethodLab5;

class GuGuDanExpr extends Multiplication {
	
	GuGuDanExpr(){
		
	}
	
	GuGuDanExpr(int dan){
		super(dan);
	}
	
	GuGuDanExpr(int dan,int number){
		super(dan,number);
	}
	
	public static void printAll() {
		for(int dan = 1 ; dan<=9 ; dan++) {
			for(int num=1; num<=9; num++) {
				System.out.printf("%d*%d = %d  ",dan,num,dan*num);
			}
			System.out.println();
		}
	}
}

public class GuGuDanApp {

	public static void main(String[] args) {
		int dan = MethodLab5.getRandom(20);
		int number = MethodLab5.getRandom(20);
		GuGuDanExpr gugudan;
		
		System.out.println("dan : "+dan+"\tnumber : "+number);
		
		if(dan<10) {
			if(number <10) {
				gugudan = new GuGuDanExpr(dan,number);
				System.out.printf("%d * %d = ",dan , number);
				gugudan.printPart();
			}else {
				gugudan = new GuGuDanExpr(dan);
				System.out.printf("%d 단 : ",dan);
				gugudan.printPart();
			}	
		}else  {
			GuGuDanExpr.printAll();
		}

	}
}
