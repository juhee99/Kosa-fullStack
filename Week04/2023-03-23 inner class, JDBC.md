<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566913897/noticon/xbvewg1m3azbpnrzck1k.png" height="15%" width="15%"> <br/>

# 2023-03-23 / inner class , JDBC

🗓️ 날짜            2023/03/23 

☁️ 날씨           ☁️  흐림(15**°C)**


## **01. 내부 클래스**

💡 클래스 내부에 정의되는 클래스로서 특정 클래스의 내에서만 주로 사용되는 클래스

- 다른 클래스 안에 정의된 클래스
- 자신을 감싼 outer class에서만 쓰여야 하고, 그 외 쓰임이 있다면 클래스 파일을 새로 생성해야함
- outer class 와 inner class 를 구분하기 위해 ‘$’ 사용

### **1.1 멤버 클래스 VS 로컬 클래스**

- 멤버 클래스 : 클래스의 멤버로 정의
- 로컬 클래스 :  메서드 내에 정의

![Inner class](https://user-images.githubusercontent.com/55836020/227394229-8f337006-7bac-4fa4-99c1-7dc615d2a44b.png)


### 1.2 내부 클래스 종류

| **내부 클래스의 종류 | 생성되는 클래스명 규칙** |
| --- | --- |
| 인스턴스 클래스   (멤버 클래스) | 외부클래스$내부클래스.class |
| 스태틱 클래스       (멤버 클래스) | 외부클래스$내부클래스.class |
| 이름있는 로컬 클래스 (로컬 클래스) | 외부 클래스$N내부클래스.class |
| 이름없는 로컬 클래스 (로컬 클래스) | 외부클래스$N.class |

</br>

### 1.2.1 멤버 클래스

- 동일 클래스에서 뿐만 아니라 다른 클래스에서도 이 클래스들을 사용 할 수 있다.
- **인스턴스 클래스** : outer class의 인스턴스 멤버처럼 다루어 지며 주로 외부 클래스의 인스턴스 멤버들과 관련된 작업 목적으로 사용된다.
    - 사용법 : A(outer).B(inner) b = a(outer 객체).new();
    
- **Static 클래스** : 외부 클래스의 static 멤버 처럼 다루어 지며 주로 외부 클래스의 클래스 메서드내에서 사용될 목적으로 정의된다.
    - Static  클래스 내 멤버들은 Static
    - 사용법 :  A(outer).C(inner).멤버
    
    ```java
    class Outer {
    	void pr() {
    		System.out.println("Outer's pr() Method !!");
    	}
    
    	class Inner { // 인스턴스 클래스
    		void pr() {
    			System.out.println("Inner's pr() Method !!");
    		}
    	}
    
    	static class Static_Inner { // static 클래스
    		static void pr() {
    			System.out.println("Static_Inner's pr() Method !!");
    		}
    	}
    }
    
    public class InnerTest1 {
    	public static void main(String args[]) {
    		Outer.Static_Inner.pr(); // Static: outer.inner.method
    		Outer o = new Outer();   // outer class 객체 생성
    		o.pr(); 
    		Outer.Inner i = o.new Inner(); // inner class 객체 생성
    		i.pr();
    	}
    }
    ```
    


### 1.2.2 이름 있는 로컬 클래스

- 메서드 내에 정의되는 클래스
- 활용 범위가 정의되어 있는 메서드 블록 내부로 제한된다.
- outer class의 멤버 변수, 정의되어 있는 final 로컬 변수, final 매개 변수 사용 가능
- 잘 사용 안함

### 1.2.3 이름이 없는 로컬 클래스(anonymous)

💡 한번만 사용 될 클래스가 필요한 경우, 새로운 클래스를 만들지 않고 사용하기 위함

- 클래스 정의와 객체 생성을 동시에 하는 `1회용 클래스`
- new 키워드 뒤의 생성자 메서드의 명칭이 기존 클래스 명인 경우, 자동적으로 이 클래스의 자손 클래스(상속 받은 클래스)가 되며, 인터페이스 명인 경우에는 이 인터페이스를  구현하여 추가 상속하는 클래스로서 부모 클래스 Object
- 메서드 호출시 *매개변수 타입이 추상 클래스 형이거나 인터페이스 형이어서 가볍게 자손 클래스를 만들고 객체를 생성해서 전달하려는 경우* 유용하게 사용될 수 있는 구문

```java
class A {

	void pr(Test t) {

	}

	void sam() {
		pr(new Test() {  // 클래스 정의와 생성, Test class의 자손 class
			멤버들...
		});
```
</br>

## 02. JDBC

💡 Java 프로그램에서 DB 서버를 접속하여 데이터를 처리하는 기능을 구현하고 할 때 사용되는 java 기술

- JDBC의 경우 대부분 API가 인터페이스 이다.
- 이 API들의 객체를 생성하기 위해서 이 API 들을 상속하여 구현하고 있는 자식 클래스를 `JDBC 드라이버`가 제공한다.
- **JDBC API** : 모든 DB 서버에 대해 공통이다.
- **JDBC 드라이버** :  JDBC에서 인터페이스를 설계되어 있는 API 들의 자식 클래스를 제공하는 프로그램. → DB 서버 마다 달라진다.(DB 서버에 맞게 자식 클래스의 수행 코드가 다르게 만들어 진다.)

### 2.1 데이터 읽기

> 💡 DriverManager → Connection  —> Statement —> ResultSet
> 
1. **Driver** 로드
    - DriverManager로 어떤 DB를 사용할 것인지 드라이버를 로드한다.
    - 각 DB마다 고유 드라이버 이름이 있다
        - Class.forName(”com.mysql.cj.jdbc.Driver”);
2. **Connection** 얻기
    - DB 결정 후, 연결을 위해 연결 정보(DB 서버 url, ID, PW) 입력한다.
    - Connection con = DriverManager.getConnection( url , user, password);
3. **Statement** 작성
    - DB 서버에 SQL 명령을 전달하여 실행시키기 위한 객체를 생성한다.
    - Statement stmt = conn.createStatement(); //Statment 팩토리 매소드
4. 실행결과를 **ResultSet**에 담기
    - Select 명령을 실행한 결과를 ResultSet이라는 객체로 반환한다.
    - ResultSet rs = stmt.executeQuery(”쿼리문”);
5. ResultSet 객체에서 값 꺼내오기
    - rs.read(); // 한 행씩 읽음
    - rs.getString(”colNm”); , rs.getInt(”colNm”); //select 순서대로 숫자 부여
6. 커넥션 반환하기
    - rs.colse(); , stmt.close(); , conn.close()

**2.1.1 Result Set**

💡 Query의 실행 결과를 담는 객체

- 최초에는 결과 집합에서 **0번째 줄**을 가르키고 있다.
- 다음 줄(행)을 옮기기 위해서는 next() 메서드 사용 —> `포인터 이동`
    - while(rs.next())
- select 된 결과가 없을 때 , 내용이 비어 있는 ResultSet ⇒ 한번이라도 next()를 호출해야함.

### 기타

- Query 짤 때 가독성을 위해 * 은 가급적 피하기!

</br>

## Exercise01 / anonymous inner class

<details>
<summary> 📜inner class 실습 펼쳐보기 </summary>
<div markdown="1">
  
1️⃣ **[실습 1]**
  
소스명 : AnonyInnerLab.java, Book.java

(1) day5 패키지 폴더나 day6 패키지 폴더에 가면 BookTest.java 가 있으며
이중에서 Book 클래스를 public 클래스로 변경하고
생성자와 getBookInfo() 도 public 으로 변경한다.
또한 price 정보를 리턴하는 getter 메서드를 추가한다.

(2) AnonyInnerLab 클래스의 main() 메서드에 구현할 내용

- ArrayList 객체에 Book 객체를 5개 저장한다.(BookTest.java 를 활용해도 됨)
Book 객체들의 정보를 행단위로 출력한다.
Collections.sort(list, Comparator<Book>)
을 호출하여 ArrayList 에 저장된 Book 객체들을 소팅한다.
이 때
Comparator<Book> 객체를 구현하고 생성하여 전달해야 하는데
Comparator<Book> 객체 생성 부분에서 Anonymous Inner 클래스로 해결한다.
compare() 메서드 오버라이딩시 책 가격을 가지고 오름차순이 되도록 구현한다.

```java
public class AnonyInnerLab {

	public static void main(String[] args) {
		ArrayList<Book> bookList = new ArrayList<>();

		bookList.add(new Book("자바의 정석", "남궁성", 27000));
		bookList.add(new Book("챗GPT", "반병현", 11700));
		bookList.add(new Book("스타트 스프링 부트", "남가람", 27000));
		bookList.add(new Book("Doit! 자바프로그래밍", "박은중", 22500));
		bookList.add(new Book());

		for (Book b : bookList) {
			System.out.println(b.getBookInfo());
		}

		Collections.sort(bookList, new Comparator<Book>() {
			public int compare(Book o1, Book o2) {
				return o1.getPrice() - o2.getPrice();
			}
		});

		System.out.println("[소팅 후]");
		for (Book b : bookList) {
			System.out.println(b.getBookInfo());
		}
	}
}
```

</div>
</details>

## Exercise02 / JDBC

<details >
 <summary> 📜JDBC 실습 펼쳐보기</summary>
<div markdown="1">

1️⃣ **[실습 1]**

작성 클래스명 : SelectEmpLab

- main() 메서드에 구현할 내용
1. DB 서버로 접속한다.
2. Random 클래스의 객체를 생성하여 true 와 false 랜덤값을 추출한다.
3. true 이면
emp 테이블에서 모든 직원들의 이름과 월급, 두 개의 컬럼을 추출하여
다음 형식으로 표준 출력한다.
    
    XXX 직원의 월급은 x,xxx달러입니다.
    XXX 직원의 월급은 x,xxx달러입니다.
    XXX 직원의 월급은 xx,xxx달러입니다.
    :
    
1. false 이면
emp 테이블에서 모든 직원들의 이름과 입사 날짜를 입사한지 오래된 순으로 추출하여
다음 형식으로 표준 출력한다.
    
    XXX 직원은 xxxx년 xx월 xx일에 입사하였습니다.
    XXX 직원은 xxxx년 xx월 xx일에 입사하였습니다.
    XXX 직원은 xxxx년 xx월 xx일에 입사하였습니다.
    

```java
public class SelectEmpLab {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";				
		Random random = new Random();

		String sql = "SELECT ENAME, SAL, DATE_FORMAT(HIREDATE, '%Y년 %m월 %d일') HIREDATE FROM EMP ORDER BY HIREDATE ";
		
		try(Connection conn = DriverManager.getConnection(url, user, passwd);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			
			if(rs.next()) {
				do {  
					if(random.nextBoolean())System.out.printf("%s 직원의 월급은 %,d달러 입니다.\n",rs.getString("ENAME"), rs.getInt("SAL")) ;
					else System.out.printf("%s 직원은 %s에 입사하였습니다.\n", rs.getString("ENAME"), rs.getString("HIREDATE")); 
				} while (rs.next());
				
			}else {
				System.out.println("데이터가 없습니다.");
			}
			
		}catch(Exception e) {
			System.err.println("오류 발생 : " + e);
		}

	}
}
```

</br>

2️⃣ **[실습 2]**

작성 클래스명 : SelectEmpLab

- main() 메서드에 구현할 내용
1. DB 서버로 접속한다.
2. Random 클래스의 객체를 생성하여 true 와 false 랜덤값을 추출한다.
3. true 이면
emp 테이블에서 모든 직원들의 이름과 월급, 두 개의 컬럼을 추출하여
다음 형식으로 표준 출력한다.
    
    XXX 직원의 월급은 x,xxx달러입니다.
    XXX 직원의 월급은 x,xxx달러입니다.
    XXX 직원의 월급은 xx,xxx달러입니다.
    :
    
1. false 이면
emp 테이블에서 모든 직원들의 이름과 입사 날짜를 입사한지 오래된 순으로 추출하여
다음 형식으로 표준 출력한다.
    
    XXX 직원은 xxxx년 xx월 xx일에 입사하였습니다.
    XXX 직원은 xxxx년 xx월 xx일에 입사하였습니다.
    XXX 직원은 xxxx년 xx월 xx일에 입사하였습니다.
    

작성 클래스명 : CheckEmpLab

1. DB 서버로 접속한다.
2. 검색하려는 직원의 이름을 표준입력 받는다.
3. 해당 직원의 정보를 다음과 같이 출력한다.
(이름 비교시 대소문자 구분 없이 처리하게 한다.)
- 직원이 존재하면
xxx 직원은 근무중입니다.
xxxx년 xx월에 입사했고 현재 xx 번부서에서 근무하고 있습니다.
- 직원이 존재하지 않으면
xxx 직원은 근무하지 않습니다.
1. 계속 검토하려고 하는지 프롬프트하고 종료하거나 2번부터 반복한다.

```java
public class CheckEmpLab {

	public static void main(String[] args)  {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		String sql =  "SELECT ENAME,DATE_FORMAT(HIREDATE, '%Y년 %m월') HIREDATE, DEPTNO FROM EMP";
		
		
		
		try(Connection conn = DriverManager.getConnection(url, user, passwd);
				Statement stmt = conn.createStatement();
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				ResultSet rs = stmt.executeQuery(sql)){
			
			char check;
			
			while(true) {
				System.out.print("직원 이름 검색 : ");
				String name = br.readLine();
				
				if(rs.next() && rs.getString("ENAME").equals(name)) {
					System.out.println(name + "직원은 근무중입니다.");
					System.out.printf("%s에 입사했고 현재 %d 번부서에서 근무하고 있습니다.\n", rs.getString("HIREDATE"), rs.getInt("DEPTNO"));	
				}else {
					System.out.println(name + " 직원은 근무하지 않습니다.");
				}
	
				System.out.print("\n계속 진행하시겠습니까?(y/n) :  ");
				check =br.readLine().charAt(0);
				
				if(check == 'n') break;
			}	
			System.out.println("종료하였습니다.");
		}catch(Exception e) {
			System.err.println("오류 발생 : " + e);
		}
	}
}
```

</div>
</details>
