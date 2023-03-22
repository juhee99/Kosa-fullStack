package day4;

/*1. LottoMachine1 이라는 클래스를  생성한다.
2. 1부터 45 사이의 난수 6개를 추출하여 다음 형식으로 출력한다.
    단, 6개 숫자는 중복을 허용하지 않는다.
        [ 출력형식 ]

    오늘의 로또 번호 - x, x, x, x, x, x*/
public class LottoMachin1 {

	public static void main(String[] args) {
		
		int [] lottoNum = new int[6];
		int size = lottoNum.length;
	
		for(int i=0 ; i< size; i++) {
			lottoNum[i] = (int)(Math.random()*45)+1;
			
			for(int j=0; j<i;j++) {	
				if(lottoNum[j] == lottoNum[i]) {
					i--;
					break;
				}
			}
		}
		
		System.out.print("오늘의 로또 번호 - ");
		for(int i = 0; i<size-1; i++) {
			System.out.print(lottoNum[i]+ ", ");
		}
		System.out.println(lottoNum[size-1]);
		
	}
}
