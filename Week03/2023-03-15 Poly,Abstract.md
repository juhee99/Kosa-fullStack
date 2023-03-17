<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566913897/noticon/xbvewg1m3azbpnrzck1k.png" height="15%" width="15%"> <br/>

# 2023-03-15 / Poly,Abstract

📆 날짜           2023/03/15  </br>
☁️ 날씨       ⛅ 부분 흐림 (8°C)


## 01. 다형성

### 1.1 다형성이란?

💡하나의 객체가 여러가지 타입을 가질 수 있는 것

- 상위 클래스 타입의 참조 변수로 하위 클래스 타입의 객체를 참조할 수 있는것이 다형성
- 반대로 자손타입의 참조변수로 조상타입의 인스턴스를 참조할 수 없다.

```java
Date d1 = new Date();
Object d2 = new Date(); //상위 = 하위
String d3 = new Date(); //(x)

```

- 상위 클래스 타입의 참조 변수로 객체를 담으면 접근할 수 있는 멤버 사양이 달라짐
    - 상위 클래스 사양까지만 접근 가능
    - 자손에서 추가된 멤버는 접근 불가능
        - 자손 멤버에 접근하고 싶으면 자손객체로 형변환 해줘야함

### 1.2참조변수의 형변환

- 자손 타입 —> 조상타입 (Up-casting) : 형변환 생략가능
- 조상타입 —→ 자손타입 (Down-casting) : 형변환 생략불가

### 1.3 매개변수의 다형성

- 참조형 매개변수는 메서드 호출시, 자신과 같은 타입 또는 자손타입의 인스턴스를 넘겨 줄 수 있다.

![다형성](https://user-images.githubusercontent.com/55836020/225837414-3b247c81-fc27-48e0-a465-08e659186174.png)

[참조 :자바의 정석]

## 02. 제어자 (modifier)

💡 클래스, 변수, 메서드의 선언부에 사용되어 부가적인 의미 부여

### 2.1 접근 제어자

- public(전체) → protected(상속,같은 패키지) → default(같은 패키지) → private(클래스 내)

![제어자](https://user-images.githubusercontent.com/55836020/225837106-90eda20f-82ce-407a-8ebe-4b0331d7b4d8.png)

- 클래스 : public ,(default)
- 멤버변수, 메서드, 생성자메서드 : public, protected, default, private

### 2.2 활용 제어자

- static, final, abstract
- stactic - 정적,고정 , 멤버 변수, 메소드, 블록
- final - 마지막의 변경할 수 없는 변수,멤버 변수, 메서드, 지역 변수/상수 변수, 오버라이딩 불가능 메소드, 상속 불가능 클래스
- abstract - 추상적인, 미완성의 클래스

### 제어자 사용할 때 주의점

- 클래스가 public이면 일반적으로 생성자도 public
- 멤버변수는 private으로 선언하고, getter,setter를 통해 접근
- 생성자 private 인 경우
    - 객체를 만들어 주는 메서드 = `팩토리 메서드`
    - 생성자 호출을 통해 객체 생성을 못하고 팩토리 메서드로 객체 생성을 대신
    - `싱글톤 패턴`인 경우 팩토리 메서드 사용 ⇒ 자바 프로그램에서 객체가 하나가 만들게 설정 하고 싶을 경우 사용
    - ex) [Runtime](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Runtime.html) → Runtime.getRuntime();
    - [InetAddress](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/net/InetAddress.html)  ****—> ****InetAddress.getLocalHost();

> 싱글톤 패턴? 객체의 인스턴스가 오직 1개만 생성되는 패턴
> 
> 
> 장점 : 메모리 측면, 데이터 공유가 쉬움
> 

## 03. Abstract

### abstract 메서드

💡 메서드의 헤더(선언부)만 정하고 코드 블록(구현부)을 생략한 메서드

- abstract 메서드를 1개 이상 정의한 클래스는 반드시 abstract 클래스로 정의해야한다.
- 자손에 의해 오버라이딩 해야하는 메서드(꼭 필요하지만 자손마다 다르게 구현해야 할 경우)

### abstract 클래스

- 미완성 클래스로서 객체 생성은 불가하며 상속으로만 사용 가능한 클래스
- 0개 이상의 abstract 메서드가 존재할 수 있다.
- 여러 클래스에 공통적으로 사용될 수 있는 추상클래스를 바로 작성하거나 기존 클래스의 공통 부분을 뽑아서 추상클래스를 만든다.

## 04. Exercise / abstract

<details>
<summary>Exercise01 펼쳐보기</summary>
<div markdown="1">

1️⃣ Exercise
  
  ![image](https://user-images.githubusercontent.com/55836020/225838296-efc15be5-bfb5-4d19-b9b5-a48981d6e712.png)

```java
public abstract class Mobile {
	private String mobileName;
	private int batterySize;
	private String osType;
	
	public Mobile() {}
	
	public Mobile(String mobileName,int batterySize,String osType) {
		this.mobileName = mobileName;
		this.batterySize = batterySize;
		this.osType = osType;
	}
	
	
	public abstract void operate(int time);
	
	public abstract void charge(int time);

	//getter,setter 생략
}
```

```java
public class Ltab extends Mobile {
	
	public Ltab() {}
	
	public Ltab(String mobileName,int batterySize,String osType) {
		super(mobileName,batterySize,osType);
	}
	
	public void operate(int time) {
		setBatterySize(getBatterySize()-(time*10));
	}
	
	public void charge(int time) {
		setBatterySize(getBatterySize()+(time*10));
	}

public class Otab extends Mobile{
	
	Otab() {}
	
	Otab(String mobileName, int batterySize, String osType ){
		super(mobileName, batterySize, osType);		
	}
	
	public void operate(int time) {
		setBatterySize(getBatterySize()-(time*12));
		
	}

	public void charge(int time) {
		setBatterySize(getBatterySize()-(time*8));
	}	
}
```

```java
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
```

</div>
</details>


## 05. 기타

- `object instanceOf type` ⇒ object가 type이거나 type을 상속받는 클래스면 true
- object.getClass().getName() ⇒ object의 클래스 이름;
- [자바 API 17.V 공식문서](https://docs.oracle.com/en/java/javase/17/docs/api/index.html)
