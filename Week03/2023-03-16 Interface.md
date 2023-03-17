<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566913897/noticon/xbvewg1m3azbpnrzck1k.png" height="15%" width="15%"> <br/>

#2023-03-16 / Interface

🗓️ 날짜            2023/03/14 

☁️ 날씨           🌞 맑음(2**°C)**

## 01. 인터페이스

### 1.1 인터페이스란?

- 클래스의 특별한 형태 , 어떠한 클래스가 가져야할 스펙을 정의한 기본 설계도
- 추상클래스와 많은 부분이 비슷 : 객체생성불가, 상속만 가능( `implements` )
- 다중 상속이 가능
    - 인터페이스 생성시 2개 이상의 인터페이스 상속
    - 인터페이스를 상속하는 클래스 구현시 여러 인터페이스 설정 가능
- Has - a “~ 할 수 있는”  , 인터페이스명 - ~able
- 인터페이스를 활용함으로써 코드간의 `결합도`를 낮출 수 있다

### 1.2 인터페이스 생성

```
interface 인터페이스명 [extends 부모인터페이스, …] {

				명시적 초기화를 하고 있는 상수(public static final)      //일반 변수(x)
				abstract 메서드;   (public abstract)
				----------------------- 자바 8
				static 메서드        // 메소드 구현 가능
				default 메서드       // 메소드 구현 가능
}

class 클래스명 implements 부모인터페이스,...{

}
```

### 1.3 interface 메소드

- **abstract 메소드**  - interface의 기본형 메소드 형태
    - public abstract 생략 가능
- **default 메소드** - 자식 클래스에서 오버라이딩을 선택적으로 할 수 있는 메소드
    - 구현체 가능하다.
- **static 메서드** - interface의 메소드
    - 오버라이딩 불가능
    - 구현체가 있어야 한다.

## 02. 싱글톤 패턴

💡 객체 인스턴스는 오직 하나만 생성, 프로그램 어디서나 접근 가능하여 사용할 수 있도록 하는 패턴

- 생성자 메서드는 호출을 막아 놓고 객체를 생성할 수 있는 메서드를 만든다 = `팩토리 메소드`
- 목적! : 정보를 보관하고 공유하기 위한 클래스가 한번의 메모리만 할당하고 할당한 메모리에 대해 객체를 관리하기 위함

```java
class MySingleton {
	private static MySingleton obj = null;
	private MySingleton() {		 // 생성자 막음
	}
	static MySingleton getMy() { // 팩토리 메소드
		if(obj == null)
			obj = new MySingleton();
		return obj;
	}
	void printMyName() {
		System.out.println("유니코");	
	}
	void printFavoriteFood() {
		System.out.println("떡볶이");	
	}
}
public class MySingletonTest {
	public static void main(String[] args) {
		//MySingleton my = new MySingleton();
		MySingleton my = MySingleton.getMy();
		my.printMyName();
		my.printFavoriteFood();
		System.out.println(my);                    //day9.MySingleton@5ccd43c2
		System.out.println(MySingleton.getMy());   // day9.MySingleton@5ccd43c2
		System.out.println(MySingleton.getMy());   //day9.MySingleton@5ccd43c2    
	}
}
```

## Exercise 01 / iterface,ingeritance

<details>
<summary>Exercise01 펼쳐보기</summary>
<div markdown="1">

![image.jpg1](https://user-images.githubusercontent.com/55836020/225849015-bedb9e02-f6b0-4d1a-98ba-1fbd3f722e51.png) |![image.jpg2](https://user-images.githubusercontent.com/55836020/225849031-ccbef8f2-e1b0-4c1f-92ba-58f29dafbdd6.png)
--- | --- | 



```java
public abstract class Employee {
	private String name;
	private int number;
	private String department;
	private int salary;
	
	public Employee(){}
	
	public Employee(String name, int number, String department, int salary) {
		this.name = name;
		this.number = number;
		this.department = department;
		setSalary(salary);
	}
	
	public abstract double tax();

	public String getName() {
		return name;
	}

 //getter,setter 생략	
}

public interface Bonus {
	public void incentive(int pay);
}
```

```java
public class Sales extends Employee implements Bonus {

	public Sales() {}
	
	public Sales(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}

	
	public double tax() {
		return getSalary() * 0.13;
	}
	
	public void incentive(int pay) {
		int incen =  (int) Math.round(pay*1.2);
		setSalary(getSalary()+incen);
	}
	
	
	public double getExtraPay() {
		return getSalary()*0.03;
	}

}

```

```java
public class Secretary extends Employee implements Bonus {

	public Secretary() {
	}

	public Secretary(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}

	public double tax() {
		return getSalary() * 0.1;
	}

	public void incentive(int pay) {
		int incen =  (int) Math.round(pay*0.8);
		setSalary(getSalary()+incen);
	}
}

```

```java
public class Company {
	public static void main(String[] args) {

		Employee[] emp = new Employee[2];

		emp[0] = new Secretary("Duke", 1, "Secretary", 800);
		emp[1] = new Sales("Tuxi", 2, "Sales", 1200);

		printEmployee(emp, false);

		System.out.println("\n[인센티브 100 지급]");
		((Secretary) emp[0]).incentive(100);  //((Bonus) emp[0]).incentive(100);
		((Sales) emp[1]).incentive(100);       // ((Bonus) emp[0]).incentive(100);
		printEmployee(emp, true);
	}

	public static void printEmployee(Employee[] emp, boolean isTax) {
		System.out.println("name\tdepartment\tsalary\t" + (isTax ? "tax\t" : "") + "extra pay");
		System.out.println("-----------------------------------------------------");

		String str = "";
		for (Employee data : emp) {
			str = data.getName() + "\t" + data.getDepartment() + (data.getDepartment().length() > 6 ? "" : "\t")+"\t" + data.getSalary() + "\t";

			if (isTax)
				str += data.tax() + "\t";

			if (data instanceof  Sales) {
				str += ((Sales) data).getExtraPay();
			}

			System.out.println(str);
		}

	}
}

```
</div>
</details>



## Exercise 02

<details>
<summary>Exercise02 펼쳐보기</summary>
<div markdown="1">

![image.jpg1](https://user-images.githubusercontent.com/55836020/225852096-9a4b2291-9761-427b-a888-5467ffb7bb48.png) |![image.jpg2](https://user-images.githubusercontent.com/55836020/225852082-97bf2fea-9953-482f-8bc2-246ad2af7c5f.png)
--- | --- | 

```java
public class TV {
	private String model;
	private int size;
	private int channel;
	
	public TV() {}
	
	public TV(String model, int size, int channel) {
		this.model = model;
		setSize(size);
		setChannel(channel);
	}
	
	public void channelUp() {
		if(channel > 10) 
			setChannel(1);
		else channel++; 
	}
	
	public void channelDown() {
		if(channel < 1) 
			setChannel(10);
		else channel--;
	}

	//getter,setter 생략
}
```

```java
public interface Rentable {
	public void rent();
}
```

```java
public class SaleTV extends TV{
	private int price;
	
	public SaleTV() {}
	
	public SaleTV(int price, String model, int size, int channel) {
		super(model, size, channel);
		setPrice(price);
	}
	
	public void play() {
		System.out.printf("판매 TV 채널 %d번의 프로를 플레이 합니다.\n", getChannel());
	}
	
	public void sale() {
		System.out.printf("%s 모델의 상품을 판매합니다. %,d 을 지불해 주세요.\n", getModel(), getPrice());
	}
	
	public String toString() {
		return String.format("판매상품정보 : 모델명(%s), 가격(%,d), 크기(%d)", getModel(), getPrice(), getSize());
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
		if(price < 0) this.price = 0;
	}

}
```

```java
public class RentalTV extends TV implements Rentable {
	private int price;
	
	public RentalTV() {}
	
	public RentalTV(int price, String model, int size, int channel) {
		super(model, size, channel);
		setPrice(price);
	}
	
	public void play() {
		System.out.printf("대여 TV 채널 %d번의 프로를 플레이 합니다.\n", getChannel());
	}
	

	public void rent() {
		System.out.printf("%s 모델의 상품을 대여합니다. %,d 을 지불해 주세요.\n", getModel(), getPrice());
	}
	
	public String toString() {
		return String.format("대여상품정보 : 모델명(%s), 가격(%,d), 크기(%d)", getModel(), getPrice(), getSize());
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
		if(price < 0) this.price = 0;
	}
}
```

```java
public class TVTest {

	public static void main(String[] args) {
		SaleTV sale = new SaleTV(300000, "SALERV-1", 40, 1);
		RentalTV rent = new RentalTV(100000, "RENTALTV-10", 42, 1);
		
		sale.channelUp();
		sale.channelUp();
		
		rent.channelDown();
		rent.channelDown();
		
		printAllTV(sale);
		printAllTV(rent);
		printRentalTV(rent);

	}
	
	static void printAllTV(TV tv) {
		System.out.println(tv);
		
		if(tv instanceof SaleTV) {
			((SaleTV)tv).play();
			((SaleTV) tv).sale();
		}else if(tv instanceof RentalTV) {
			((RentalTV)tv).play();
		}
	}
	
	static void printRentalTV(Rentable tv) {
		tv.rent();
	}

}
```
</div>
</details>

## 기타

- **toString() -** Object (최상위 객체)객체가 가지고 있기 때문에 언제나 toString()호출이 가능하다, 또한 오버라이딩을 해서 커스텀 가능하다.
    - toString() 을 호출할때 생략 가능하다. ex) tv = tv.toString()
- `instanceof` - 객체의 type 이거나 type의 하위 type이면 true
- 상위클래스로 객체를 담았을 때, 하위 클래스의 고유 메소드를 접근하고 싶다면 `명시적 형변환`이 필요하다.
- ~Factory, ~Bilder ⇒ 객체를 생성해 주는 클래스 이름
- interface,abstract, 상속 부분은 예제 위주로 공부..!
