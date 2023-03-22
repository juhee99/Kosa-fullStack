package day11;
import java.util.HashSet;
import day5.MethodLab5;

public class HashSetLab1 {
	public static void main(String[] args) {
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		while(set.size() <10) {
			set.add( MethodLab5.getRandom(10,30));
		}
		
		System.out.println("오늘의 로또 번호 : "+set );
	}
}
