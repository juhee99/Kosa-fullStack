package day6;

import java.util.Scanner;

class GradeExpr {
	private int[] jumsu;

	GradeExpr() {

	}

	GradeExpr(int[] jumsu) {
		this.jumsu = jumsu;
	}

	double getAverage() {
		return getTotal() / (double)jumsu.length;

	}

	int getTotal() {
		int sum = 0;
		for (int data : jumsu) {
			sum += data;
		}
		return sum;
	}

	int getGoodScore() {
		int max = jumsu[0];

		for (int data : jumsu) {
			if (max < data)
				max = data;
		}

		return max;
	}

	int getBadScore() {
		int min = jumsu[0];

		for (int data : jumsu) {
			if (min > data)
				min = data;
		}
		return min;
	}
}

public class GradeTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int size = sc.nextInt();
		int [] jumsu = new int[size];
		
		sc.nextLine();
		System.out.print("점수들 : ");
		String input = sc.nextLine(); 
		
		sc.close();
		
		input = input.replaceAll(" ", "");// 공백 제거 처리
		String [] inputArr = input.split(","); //,를 기준으로 문자열 잘라서 배열에 저장
		
		for(int i=0 ; i<inputArr.length ; i++) { // int 배열에 삽입
			jumsu[i] = Integer.parseInt(inputArr[i]);
		}
		
		GradeExpr grade = new GradeExpr(jumsu);
		
		System.out.println("총점 : " + grade.getTotal());
		System.out.println("평균 : " + grade.getAverage());
		System.out.println("최고 점수 : " + grade.getGoodScore());
		System.out.println("최저 점수 : " + grade.getBadScore());

	}

}
