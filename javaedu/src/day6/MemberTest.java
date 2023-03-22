package day6;

class Member {
	String name;
	String account ;
	String password;
	int birthyear ;
	
}

public class MemberTest {
	public static void main(String[] args) {
		
		Member mem1 = new Member();
		Member mem2 = new Member();
		Member mem3 = new Member();
		
		mem1.name="또치";
		mem1.account = "bbb";
		mem1.password= "test";
		mem1.birthyear = 2000;
		
		mem2.name="울라프";
		mem2.account = "aaa";
		mem2.password= "kosa";
		mem2.birthyear = 2010;
		
		mem3.name="짱구";
		mem3.account = "aaa";
		mem3.password= "kosa";
		mem3.birthyear = 2005;
		
		System.out.printf("회원%d :  %s(%s,%s,%d)\n", 1, mem1.name,mem1.account,mem1.password,mem1.birthyear);
		System.out.printf("회원%d :  %s(%s,%s,%d)\n", 2, mem2.name,mem2.account,mem2.password,mem2.birthyear);
		System.out.printf("회원%d :  %s(%s,%s,%d)\n", 3, mem3.name,mem3.account,mem3.password,mem3.birthyear);

	}
}
