package day3;
public class PrintfTest {
	public static void main(String[] args) {
		System.out.printf("테스트입니당%n");							//테스트입니당
		System.out.printf("테스트%d입니당\n",10);						//테스트10입니당
		System.out.printf("%d %x %o %c\n", 100, 100, 100, 100);		//100 64 144 d
		System.out.printf("%d %1$x %1$o %1$c\n", 100);				//100 64 144 d
		System.out.printf("0x%X 0x%x\n", (int)'가',(int)'각');       //0xAC00 0xac01  // 16진수-0x 
		System.out.printf("%c %c %c %c\n", '가', 'A', '!', '3');		//가 A ! 3
		System.out.printf("%b\n", true);							//true
		System.out.printf("%f %e\n", 100.0, 100.0);					//100.000000 1.000000e+02
		System.out.printf("%.2f\n", 123.5678);						//123.57
		System.out.printf("|%s|\n", "자바");							//|자바|
		System.out.printf("|%10s|\n", "자바");						//|        자바|
		System.out.printf("|%-10s|\n", "자바");						//|자바        |
		System.out.printf("%,d원\n", 1000000);						//1,000,000원
	}
}








