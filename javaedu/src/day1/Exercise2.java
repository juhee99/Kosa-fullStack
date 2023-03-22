package day1;
/*
 * (1) int 타입의 변수 2개를 선언하고 각각 35, 10 으로 초기화 한다. 
	(2) 나눈 몫과 나머지를 구하여 제시된 출력 형식과 같이 출력하는 프로그램을 작성하시오. 

	- 출력 결과 

	35 를 10 으로 나눈 결과 몫은 3 이고 나머지는 5 입니다.   */

public class Exercise2 {
	public static void main(String [] args) {
		
		int num1 = 35;
		int num2 = 10;
		
		System.out.printf("%d 를 %d 으로 나눈 결과 몱은 %d 이고 나머지는 %d 입니다.",num1,num2, num1/num2,num1%num2);
	}
}
