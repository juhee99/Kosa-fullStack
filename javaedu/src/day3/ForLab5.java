package day3;
/*
1. ForLab5 이라는 클래스를 만든다.
2. 3부터 10사이의 난수를 추출한다.(첫 번째 난수)
3. 1부터 3사이의 난수를 추출한다.(두 번째 난수)
4. 두 번째 난수값이 1이면 "*"을 첫 번째 난수값의 갯수로 하나의 행에 출력한다.
    두 번째 난수값이 2이면 "$"을 첫 번째 난수값의 갯수로 하나의 행에 출력한다.
    두 번째 난수값이 3이면 "#"을 첫 번째 난수값의 갯수로 하나의 행에 출력한다.
*/
public class ForLab5 {

	public static void main(String[] args) {
		int ran1 = (int)(Math.random()*8)+3;
		int ran2 = (int)(Math.random()*3)+1;
		
		
		char c = '*';
		if(ran2 == 2) c='$';
		if (ran2 ==3 ) c = '#' ;
		
		for(int i=0; i<ran1; i++) {
			System.out.print(c);
		}

		
	}
}
