<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566913897/noticon/xbvewg1m3azbpnrzck1k.png" height="15%" width="15%"> <br/>

# 2023-03-14 Inheritance

🗓️ 날짜            2023/03/14 

☁️ 날씨           🌞 맑음(5**°C)**

</br>

## **01. 변수와 메소드**

### 1.1 **선언위치에 따른 변수의 종류**

1. **인스턴스 변수**(instance variable)
    - None Static 변수, 클래스 영역
    - 각 인스턴스의 개별적인 저장 공간, 인스턴스 마다 다른 값 저장
    
    - 객체로 접근 가능  ⇒ ‘객체.변수명’
    - 참조변수가 없을 때 가비지 컬렉터에 의해 자동제거
2. **클래스 변수**(class variable)
    - **Static** 변수, 공유 변수 , 클래스 영역
    - 같은 클래스의 모든 인스턴스들이 공유하는 변수(`공통 속성`)
    - ‘클래스 이름.변수명’ 으로 접근
    - 클래스가 메모리에 올라갈 때 (JVM 영역에 class 로딩할때 한번 메모리에 올라감)
3. **지역변수** (local variable)
    - 메서드 영역 , 메서드의 종료와 함께 소멸

### **1.2 클래스 메서드 와 인스턴스 메서드**

1. **클래스 메서드(Static 메서드)**
    - 객체 생성 없이 ‘클래스.메서드 이름()’
    - 인스턴스 변수나 인스턴스 메서드와 관련 없는 작업하는 메서드
    - 메서드내 인스턴스 변수 사용 불가
2. **인스턴스 메서드**
    - 인스턴스 생성 후, ‘객체.메소드 이름()’ 으로 호출
    - 인스턴스변수나 인수턴스 메서드와 관련작업을 하는 메서드
    - 메서드 내에서 인스턴스 변수 사용가능

## **02. JVM 메모리 영역**

### **2.1 JVM 동작**

<aside>
💡 자바 프로그램 실행 → JVM 은 OS로 부터 메모리를 할당 → 컴파일러가 .java를 .class로 컴파일 → class Loader를 통해 JVM Runtime Data Area로 로딩 → 로딩된 .class들은 Execution Engine을 통해 해석

</aside>

### 2.2 런타임 데이터 영역

- **모든 스레드가 공유해서 사용(GC의 대상)**
    - 힙 영역(Heap Area) : 객체,배열이 생성되는 영역(new )
    - 메서드 영역(Method Area) : 클래스 멤버 변수의 정보, 메서드의 정보, `static` 변수
- **스레드 마다 하나씩 생성**
    - 스택 영역(Stack Area) : 지역변수, 파라미터, 리턴 값, 연산에 사용되는 임시 값 등
    - PC 레지스터(PC Register) : 스레드가 생성될때 마다 생성, 스레드 주소,명령
    - 네이티브 메서드 스택(Native Method Stack) : 자바 외 네이티브 코드

## **03. 변수 초기화**

💡 변수를 선언하고 처음으로 값을 지정하는것

- 초기화 생략 가능 - 멤버 변수와 배열은 각 타입의 기본값으로 자동 초기화됨
- 지역변수는 사용전 초기화를 해주어야 한다

### 3.1 멤버 변수의 초기화

- 명시적 초기화 : int a = 0;
- 생성자 초기화 : Car(String color, int a)
- 초기화 블럭 : 인스턴스 초기화 { } , 클래스 초기화 블럭 static { }
    - 클래스 초기화 블럭 - 클래스변수의 복잡한 초기화에 사용 , 클래스가 로딩 될때 실행
    - 인스턴스 초기화 블럭 - 생성자에서 공통적으로 사용되는 작업에 사용되며 인스턴스가 생성될 때 마다 실행(생성자 보다 먼저)
    
    ```java
    public class BlockTest {
    	static {
    		System.out.println("static 블럭 수행");
    	}
    	{
    		System.out.println("instance 블럭 수행");
    	}
    	public BlockTest() {     
    		System.out.println("생성자 수행");
    	}
    	public static void main(String args[]) {
    		System.out.println("BlockTest bt = new BlockTest(); ");
    		BlockTest bt = new BlockTest();
    		System.out.println(bt);
    		System.out.println("BlockTest bt2 = new BlockTest(); ");
    		BlockTest bt2 = new BlockTest();
    		System.out.println(bt2);
    	}
    }
    ```
    
    ```
    static 블럭 수행
    BlockTest bt = new BlockTest(); 
    instance 블럭 수행
    생성자 수행
    day7.BlockTest@59f95c5d
    BlockTest bt2 = new BlockTest(); 
    instance 블럭 수행
    생성자 수행
    day7.BlockTest@5ccd43c2
    ```
    

## 04. 상속

💡기존 클래스를 재사용해서 새로운 클래스를 작성하는것.

- 자바는 기본으로 `단일 상속`을 지원한다.
- 하위 클래스는 상위 클래스의 모든 멤버를 상속 받는다.(생성자,초기화 블럭 제외)
- 새로운 클래스 생성시 부모 클래스를 1개 지정해야 하나 생략하면 java.lang.Object 클래스를 상속하게 된다. [extends Object] - 생략됨.
    - `java.lang.Oject` 클래스는 자바로 만들어지는 모든 클래스들의 `최상위 클래스`이다.
- 어떤 클래스든 객체를 생성하게 되면 조상 클래스의 객체가 함께 생성된다. → 최적의 상속 필요
    - 객체 생성시 호출되는 생성자 메서드는 호출되자마자 부모 클래스의 생성자를 호출하는 특징을 가지고 있다.
    - 호출되는 부모 클래스의 생성자는 `아규먼트 없는 생성자`
    - 부모클래스에 아규먼트를 받지 않는 생성자가 없는 경우엔 super() 메서드를 이용해서 부모가 가지고 있는 생성자를 직접 호출해야 한다.
    - this(), super() 호출 문장이 있을때, 컴파일러 시, super() 메소드를 호출하지 않음.
    
    ```
    class A{
    	A() {		
    		System.out.println("A클래스의 객체 생성!");
    	}
    }
    class B extends A{
    	B(int num) {		
    		System.out.println("B클래스의 객체 생성!");
    	}
    }
    class C extends B{
    	C() {	
    		super(10);
    		System.out.println("C클래스의 객체 생성!");
    	}
    }
    
    public class ABCTest {
    	public static void main(String[] args) {
    		new C();
    	}
    }
    ```
    

## 05. 클래스 간의 관계

### 5.1 포함 관계란?

💡 한 클래스의 멤버변수로 다른 클래스를 선언하는 것

- 작은 단위의 클래스를 먼저 만들고, 이 들을 조합해서 하나의 커다란 클래스를 만든다.

### 5.2 상속VS 포함

- 상속 : ‘is-a’ = ‘~은 ~이다’
- 포함 : ‘has-a’ = ‘~은 ~을 가지고 있다’

## 오버라이딩(Overriding)

- 조상클래스로 부터 상속받은 메서드의 내용을 상속받는 클래스에 맞게 변경하는 것
- 선언부가 같아야 한다(이름, 매개변수, 리턴 타입)
- 접근제어자를 좁은 범위로 변경할 수 없다.
    - 상위:protected ⇒ 하위 : public ,protected

## Exercise01 / **Inheritance**

<details>
<summary>Exercise01 펼쳐보기</summary>
<div markdown="1">
1️⃣ Exercise01

```java
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

public class FriendTest {

	public static void main(String[] args) {
		
		Friend [] friends = new Friend[5];
		
		friends[0] = new Friend("짱구", "01010001000", "jjan12@kosa.net");
		friends[1] = new Friend("흰둥이", "01020001000", "white@kosa.net");
		friends[2] = new Friend("철수", "01030001000", "su100@kosa.net");
		friends[3] = new Friend("유리", "01040001000", "Yuree23@kosa.net");
		friends[4] = new Friend("맹구", "01050001000", "stone52@kosa.net");
		
		for(Friend data :  friends) {
			System.out.println(data.getInfo());
		}

	}
}
```

</br>

1️⃣ Exercise02

```java
class GuGuDanExpr extends Multiplication {
	
	GuGuDanExpr(){}
	
	GuGuDanExpr(int dan){
		super(dan);
	}
	
	GuGuDanExpr(int dan,int number){
		super(dan,number);
	}
	
	public static void printAll() {
		for(int dan = 1 ; dan<=9 ; dan++) {
			for(int num=1; num<=9; num++) {
				System.out.printf("%d*%d = %d  ",dan,num,dan*num);
			}
			System.out.println();
		}
	}
}

public class GuGuDanApp {

	public static void main(String[] args) {
		int dan = MethodLab5.getRandom(20);
		int number = MethodLab5.getRandom(20);
		GuGuDanExpr gugudan;
		
		System.out.println("dan : "+dan+"\tnumber : "+number);
		
		if(dan<10) {
			if(number <10) {
				gugudan = new GuGuDanExpr(dan,number);
				System.out.printf("%d * %d = ",dan , number);
				gugudan.printPart();
			}else {
				gugudan = new GuGuDanExpr(dan);
				System.out.printf("%d 단 : ",dan);
				gugudan.printPart();
			}	
		}else  {
			GuGuDanExpr.printAll();
		}

	}
}
```

</br>

1️⃣ Exercise03

```java
public class Human {
	private String name;
	private int age;
	private int height;
	private int weight;
	
	public Human() {
		
	}
	
	public Human(String name, int age, int height, int weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	public String printInformation() {
		return name+"\t"+age+"\t"+height+"\t"+weight;
	}
}
```

```java
public class Student extends Human{
	private String number;
	private String major;
	
	public Student() {}
	
	public Student(String name, int age, int height, int weight, String number, String major) {
		super(name,age,height,weight);
		this.number = number;
		this.major = major;
	}
	
	@Override
	public String printInformation() {
		return super.printInformation()+"\t"+number+"\t"+major;
	}
}
```

```java
public class StudentTest {
	public static void main(String[] args) {
		Student [] arrays = new Student[3];
		
		arrays[0]=new Student("홍길동",20,171,81,"201101","영문");
		arrays[1]=new Student("고길동",21,183,72,"201102","건축");
		arrays[2]=new Student("박길동",22,175,65,"201103","컴공");
		
		for(Student data : arrays) {
			System.out.println(data.printInformation());
		}
	}
}
```

</div>
</details>
