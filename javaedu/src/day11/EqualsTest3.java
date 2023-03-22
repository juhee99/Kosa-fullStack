package day11;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

class Value {
	int value;

	Value(int value) {
		this.value = value;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public boolean equals(Object o) {
		boolean result = false;
		if( o != null && o instanceof Value) {
			if(value == ((Value)o).value) result = true;
		}
		return result;
	}

	@Override
	public String toString() {
		return "Value [value=" + value + "]";
	}
	
}

public class EqualsTest3 {
	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		Value v3 = new Value(20);
		System.out.println(v1.equals(null));    // false
		System.out.println(v1.equals(v3));      // false
		System.out.println(v1.equals(v2));     // false Object의 equals -> 등가 연산과 같다 (참조가 같냐)
		System.out.println(v1.equals(new Date()));  //false
		
		System.out.println(v1.hashCode());
		System.out.println(v2.hashCode());
		System.out.println(v3.hashCode());

		//HashSet 객체에 v1,v2,v3를 저장, 저장된 객체 출력
		HashSet<Value> set = new HashSet<>();
		set.add(v1);
		set.add(v2);
		set.add(v3);
		
		System.out.println(set);
		
		for(Value v : set) {
			System.out.println(v);
		} // hash코드가 다르기 때문에 동일한 value값이 나옴
		
		
		/*if (v1.equals(v2))
			System.out.println("v1과 v2는 같습니다.");
		else
			System.out.println("v1과 v2는 다릅니다.");
		v2 = v1;
		if (v1.equals(v2))
			System.out.println("v1과 v2는 같습니다.");
		else
			System.out.println("v1과 v2는 다릅니다.");*/
	}
}
