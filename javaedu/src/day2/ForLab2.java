package day2;
/*
1. ForLab2 이라는 클래스를 만든다.
2. 다음과 같은 결과가 출력되도록 구현한다.

    9 : 홀수
    8 : 짝수
    7 : 홀수
    6 : 짝수
    5 : 홀수
    4 : 짝수
*/
public class ForLab2 {

	public static void main(String[] args) {
		
		for(int i = 9 ; i > 3 ; i--) {
			String result = i%2 == 0 ? "짝수" : "홀수";
			
			System.out.println(i+ " : " + result);
		}
	}

}
