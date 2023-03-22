package day3;

/*
1. ForLab9 라는 클래스를 생성한다.
2. 1 ~ 2 사이의 난수를 추출한다.
3. 추출한 난수가 1이면 홀수단의 구구단을 다음과 같이 출력한다.*/
public class ForLab9 {

	public static void main(String[] args) {

		int ran = (int) (Math.random() * 2) + 1;


		for(int i = ran; i <=9 ; i+=2) {
			for(int j=1; j<=9;j++) {
				System.out.print(i+"x"+j+"="+i*j);
				System.out.print("\t");
			}
			System.out.println();
		}

	}

}

