package day3;

/*
1. ForLab8 라는 클래스를 생성한다.
2. 다음과 같은 결과가 되도록 구현한다.

    ********** 
	 ********** 
  	  ********** 
 	   ********** 
	    **********
*/
public class ForLab8 {
	public static void main(String[] args) {
		final char STAR = '*';

		for(int i=0; i<6; i++) {
			for(int j=0; j<i;j++) {
				System.out.print(' ');
			}
			for(int x=0;x<11;x++) {
				System.out.print(STAR);
			}
			System.out.println();
		}
	}
}
