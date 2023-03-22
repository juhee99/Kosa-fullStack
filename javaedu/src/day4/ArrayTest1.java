package day4;

public class ArrayTest1 {
	public static void main(String[] args) {
		int[] score = new int[5];
		System.out.println(score);
		System.out.println(score.length);
		
		for (int i=0; i < score.length; i++)
			System.out.println(score[i]);  // 0,0,0,0,0
		
		for(int i=0; i < score.length; i++)
            score[i] = (i+1)*100;		 // 배열을 l-value로 사용
		
		for (int i=0; i < score.length; i++)
			System.out.println(score[i]);
	}
}
