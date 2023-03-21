<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566913897/noticon/xbvewg1m3azbpnrzck1k.png" height="15%" width="15%"> <br/>

# 2023-03-20 / Generic,API

🗓️ 날짜           2023/03/17 

☁️ 날씨           🌫️ 안개 ( 2°C )

## 01. 자바 복습

### 1.1 데이터 타입

- 기본 타입 : 정수 타입, 실수 타입, 논리 타입
- 참조 타입 : 배열 타입, 열거 타입, 클래스, 인터페이스

### 1.2 null NullPointException

- **null값** : 참조 타입 변수는 아직 번지를 저장하고 있지 않다는 뜻
- **null**도 초기값으로 사용할 수 있기 때문에 null로 초기화 된 참조 변수는 스택 영역에 생성
- **NullPointerException**은 실제 값이 아닌 null을 가지고 있는 객체/변수를 호출할 때 발생하는 예외다.</br> —→참조 변수가 객체를 정확히 참조하도록 번지를 대입해 해결

### 1.3 String 타입

- 문자열은 String 객체로 생성
- 문자열 리터럴이 동일하다면 String 객체를 공유
- new 연산자로 직접 String 객체를 생성/대입 가능

```java
String name1 = "홍길동";      //주소 : 10
String name2 = "홍길동";     // 주소 10

String name1 = new String("홍길동"); // 주소 : 20
String name2 = new String("홍길동"); // 주소 : 30

System.out.println(name1 == name2);  //true
System.out.println(name3 == name4); //false
System.out.println(name3.equals(name4)); // true , 참조형의 값을 비교
```

- 문자열 대체(replace())
    - replace() 메소드는 기존 문자열을 그대로 두고, 대체한 새로운 문자열을 리턴
    - 자주 변경되는 문자열은 StringBuffer사용!
- 문자열 분리(split())
    - 구분자가 있는 여러 개의 문자열을 분리할 때 split() 메소드를 사용

### 1.4 Enum

💡 관련있는 값들끼리 묶어 특정 상수값들을 열거해 놓는 타입

- 열거체를 비교할때 실제 값 뿐만 아니라 타입까지도 체크
- 열거체의 상수값이 재정의 되더라도 다시 컴파일할 필요가 없다.

```
*정의*
enum 열거체 이름 { 상수1, 상수2,상수3,...}
EX) enum Rainbow {RED, ORANGE, YELLOW, GREEN}

*사용*
열거체이름.상수이름
EX) Rainbow.GREEN
```

## 02.  패키지(package)

- 클래스들을 묶는 단위,실제로는 폴더가 된다.
- 자바소스의 제일 위에 패키지 선언이 되어야 한다. (ex . package day1)
- 패키지화는 필수가 아니다.
- 클래스의 정식 명칭 :  패키지명.클래스명, 패키지명.서브패키지명.클래스명
- 특정 패키지의 클래스나 인터페이스 사용시 import 문으로 선언하여 사용하며,

      java.lang 패키지는 자동 import 된다.

## 03. Wrapper Class

- 포장 클래스 : 기본형 데이터를 객체로 만들때

```
type          Wrapper class
---------------------------
int            Integer
char           Character
double         Double
boolean        Boolean
```

## 04. 🌟Generic 

💡 제네릭 프로그래밍 - 프로그램에서 처리할 데이터의 타입을 일반화 시킨다.

- 재사용성을 높이는 결과가 된다.
- 클래스에서 처리할 데이터 타입을 클래스를 만들 때 정하는게 아니라 클래스를 객체 생성할 때 정하는 것이다.

```
class Value3<T> {
	T obj;
	void put(T obj) {
		this.obj = obj;
	}
	T get() {
		return obj;
	}
}
--------------
Value3<String> v3 = new Value3<>();
Value3<Date> v4 = new Value3<>();
```

- [ArrayList<E>](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html)
- [LinkedList<E>](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/LinkedList.html)
- [HashSet<E>](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashSet.html)
- [HashMap<K,V>](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashMap.html)

## 05. Collection

### 5.1 자료구조

💡 데이터를 효율적으로 사용할 수 있도록 구조를 만들어서 저장해둔 것

| 자료구조 | 클래스 기능 | 기능 |
| --- | --- | --- |
| 리스트(List) | array list, linked list, (Vector) | 데이터를 일렬로 늘어놓은 자료구조(크기 가변) |
| 스택 (stack)  | LinkedList, (Stack) | Last In First Out(LIFO) |
| 큐(queue)  | LinkedList | First In First Out(FIFO) |
| 해쉬 테이블(hashtable)  | HashMap, (Hashtable) | 키,값 형태를 가진 자료구조 |
| 집합(set)  | HashSet  | 데이터 순서 상관 없고, 중복되지 않은 값 |

> ⚠️ Vector,Stack,Hashtable 은 구버전 API, 사용 지양
> 

### 5.2 리스트(List)

💡 데이터를 일렬로 늘어놓은 자료구조

- **[ArrayList](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html)**
    - 조회가 많을때 사용, 배열
    - ArrayList<Type> list  = new ArrayList<Type>();
    - 추가 : list.add(data) , 조회 : list.get(index) , list.indexOf(data), list.lastIndexOf(data), 크기 :  list.size()
- **[LinkedList](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/LinkedList.html)**
    - 대용량의 데이터를 다룰때 편집이 빈번할때
    - add() →  node 객체 생성→link 연결(양뱡향 linked list)
    - 단점: 조회(index 접근)할때 첫번째 노드부터 돌기 때문에 성능이 좋지 않음 → for-each, iterator 사용
    - LinkedList<Type> list = new LinkedList<Type>();
    

### 5.3 Stack

💡 데이터를 넣은 순소의 역순으로 꺼낼 수 있는 자료구조

- Last In First Out(LIFO)
- LinkedList 로 사용 가능
- list.addLast(data) , list.getLast();

### 5.4 큐(Queue)

💡 데이터를 넣은 순서와 같은 순서로만 꺼낼 수 있는 구조

- First In First Out(FIFO)
- LikedList로 사용 가능
- 추가 : list.offer(data),  데이터 리턴(pop) : list.poll(), 데이터 조회 :  list.peek()

### [해쉬 테이블(hash table)](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashMap.html)

💡 여러 개의 통(bucket)을 만들어 두고 키 값을 이용하여 데이터를 넣을 통 번호를 계산하는 자료 구조

- 데이터를 찾을때 빠르게 찾을 수 있음
- HashMap<keyType, ValueType> hashtable = new HashMap<keyType, ValueType>();
- 추가 : hashtable.put(key,value); , 조회 : hashtable.get(key) ,

### [HashSet](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashSet.html)

💡 수학에서 말하는 집합처럼 데이터를 `중복 저장하지 않음`

- 순서대로 입력되지 않고, 일정하게 유지되지 않는다.
- null 도 허용함
- hashCode()와 equals() 메소드를 재정의 필요!! —> [자세히 보기](https://www.notion.so/f6ca99a9a9254cc8a11ada2bf64a939a)
- HashSet<Type> set = new HashSet<>();


## Exercise01 /API
<details>
<summary>Exercise01 펼쳐보기</summary>
<div markdown="1">

## Exercise01

1️⃣ **실습1 LinkedList**

  day7.FriendTest.java 를 찾아서 day11.LinkedListLab1.java 로 복사한다.</br>
  Friend 타입의 배열에 Friend 객체를 저장하는 부분을 </br>
  LinkedList 객체를 생성해서 저장하고 처리하는 소스로 변경하여 구현한다.</br>

```
class Person {
	private String name;
	
	Person(String name){
		this.name = name;
	}
	public String getInfo() {
		return name;
	}
}

class Friend extends Person {
	private String phoneNum;
	private String email;
	
	Friend(String name, String phoneNum, String email){
		super(name);
		this.phoneNum = phoneNum;
		this.email = email;
	}
	
	public String getInfo() {
		return "이름 : " + super.getInfo() + " 핸드폰 번호 : " + phoneNum 
				+ " 이메일 주소 : " + email;
	}
}

public class LinkedListLab1 {
	public static void main(String[] args)  {
	LinkedList<Friend> friends = new LinkedList<Friend>();
	friends.add(new Friend("짱구", "01010001000", "jjan12@kosa.net"));
	friends.add(new Friend("흰둥이", "01020001000", "white@kosa.net"));
	friends.add(new Friend("철수", "01030001000", "su100@kosa.net"));
	friends.add(new Friend("유리", "01040001000", "Yuree23@kosa.net"));
	friends.add(new Friend("맹구", "01050001000", "stone52@kosa.net"));
	
	for(Friend data :  friends) {
		System.out.println(data.getInfo());
	}
	
	}
}
```
</br>

2️⃣ **실습 2 HashSet**

   10 부터 30 까지의 숫자를 10개 추출하여 화면에 다음과 같이 출력하는</br>
   HashSetLab1 이라는 클래스를 구현한다.</br>
   중복 숫자는 허용하지 않으며 추출되는 숫자를 HashSet 에 저장하여 처리한다.</br>

 오늘의 로또 번호 : 10, 11, 25, 22, 20, 21, 15, 27, 28, 13</br>

```java
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
```
</br>

3️⃣ **실습 3 HashMap**

  표준입력으로 나라이름과 인구수를 입력받아</br>
  HashMap 객체에 5개까지 저장한 후에 출력하고 종료한다.</br>
  단, 입력되는 나라명은 모두 달라야 한다.</br>

  클래스명 : HashMapLab1</br>

  ❗실행 결과</br>

  나라이름을 입력하세요 :</br>
  인구 수를 입력하세요 :</br>
  *저장되었습니다.*</br>
  나라이름을 입력하세요 :</br>
  인구 수를 입력하세요 :</br>
  *나라명 xxx는 이미 저장되었습니다.*</br>
  :

  5개가 모두 입력되었습니다.
  입력된 데이터 : XX(nn), XX(nn)....

```java
public class HashMapLab1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String,Integer> map = new HashMap();
		String country ;
		int population;
		while(map.size()<5) {
			
			try {
				System.out.print("나라이름을 입력하세요 : ");
				country = sc.next();
				sc.nextLine();
				System.out.print("인구 수를 입력하세요 : ");
				population = sc.nextInt();	
				
				if(map.containsKey(country)) {
					System.out.printf("*나라명 %s는 이미 저장되었습니다.*\n",country);
				}else {
					map.put(country,population);
					System.out.println("*저장되었습니다.*");
				}
				
			}catch(InputMismatchException e) {
				System.out.println("다시 입력해 주세요.");
				sc.nextLine();
				continue;
			}
		}
	
		System.out.println("5개가 모두 입력되었습니다.");
		
		int cnt = 0;
		System.out.print("입력된 데이터 : ");
		for(String key : map.keySet()) {
			System.out.printf("%s(%d)", key, map.get(key));
			cnt++;
			if(cnt != map.size()) {
				System.out.print(",");
			}
		
		}		
	}

}
```
</div>
</details>
