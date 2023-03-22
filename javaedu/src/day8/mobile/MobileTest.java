package day8.mobile;

public class MobileTest {

	public static void main(String[] args) {
		Ltab l = new Ltab("Ltab",500,"ABC-01");
		Otab o = new Otab("Otab",1000,"XYZ-20");
		
		printTitle();
		printMobile(l);
		printMobile(o);
		
		System.out.println("\n[ 10분 충전 ]");
		l.charge(10);
		o.charge(10);
		
		printTitle();
		printMobile(l);
		printMobile(o);
		
		System.out.println("\n[5분 통화]");
		l.operate(5);
		o.operate(5);
		
		printTitle();
		printMobile(l);
		printMobile(o);
		
	}

	public static void printMobile(Mobile mobile) {
		System.out.println(mobile.getMobileName()+"\t"+mobile.getBatterySize()+"\t"+mobile.getOsType());
	}
	
	public static void printTitle() {
		System.out.println("Mobile"+"\t"+"Battery"+"\t"+" OS");
		System.out.println("---------------------------------");
	}
}
