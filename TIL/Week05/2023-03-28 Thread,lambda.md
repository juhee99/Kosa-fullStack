<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566913897/noticon/xbvewg1m3azbpnrzck1k.png" height="15%" width="15%"> <br/>

# 2023-03-28 / Thread,lambda

🗓️ 날짜           2023/03/28 

☁️ 날씨           🌞 맑음 ( 6°C )


## 01. 멀티스레드 프로그래밍

### 1.1 멀티 프로세스와 멀티 스레드

- 프로세스 :  실행 중인 프로그램
- 멀티 프로세스 : 실행 중인 프로그램이 2개 이상 / 운영체제 역할
- **스레드** : 프로세스 내에서 코드의 실행 흐름
    - 메인 스레드 - 메인 메소드 실행
- **멀티 스레드** :  두 개의 코드 실행 흐름. 두가지 이상의 작업을 처리
    - 메인 스레드 상에서 또 다른 작업 스레드 생성→ 작업 스레드, 자식 스레드
- 멀티 태스킹 : 두 가지 이상의 작업을 동시에 처리하는 것

![Thread)](https://user-images.githubusercontent.com/55836020/228478939-b08dc3df-6f24-4bb4-9216-659e1a87cd2a.png)

> 스레드 1개 프로세스 N개 보다 프로세스 1개 스레드 N개 가 성능이 좋다.
> 

> 스레드 == 일꾼 , 프로세스 == 공장
>

</br>

## 02. Thread

### 2.1. Thread 구현 방법(2가지)

**1. Thread class 상속**

💡 [java.lang.Thread](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Thread.html) class 를 상속받아 구현 - run()메소드 오버라이딩

```java
class ThreadA extends Thread{
	public void run() {
		//수행할 문장
	}
}

//실제 사용
Thread TA = new ThreadA();
TA.start();
```

**2. Runnable 인터페이스**

💡 [Runnable](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Runnable.html) 인터페이스를 상속받아 구현 - run() 메소드 오버라이딩

- 현재 클래스가 이미 다른 클래스로부터 상속 받고 있을때

```java
public class RunnableTest implements Runable {
	public void run(){
		//수행 할 문장
	}

//실제 사용
RunnableTest obj = new RunnableTest();
Thread th = new Thread(obj);
th.start();
```

### 2.2. Thread 상태

- 스레드가 일시정지 상태에서 다시 실행 상태로 가기 위해서는 실행 대기 상태로 가야함
    
 
![thread state](https://user-images.githubusercontent.com/55836020/228479435-854cc58c-a243-481e-95aa-afcf68c14d89.png)

| 구분 | 메소드 | 설명 |
| --- | --- | --- |
| 일시 정지로 보냄 | sleep(long millis) | 주어진 시간동안 스레드를 일시 정시 상태로 만든다.  |
|  | join() | 일시 정지 상태가 된다. 실행 대기 상태가 되려면 join()메소드를 가진 스레드가 종료되어야 한다. |
|  | wait() | 스레드를 일시 정지 상태로 만든다 |
| 일시 정시에서 벗어남 | interrupt() | interruptedException을 발생 시켜 대기 상태 또는 종료 상태로 만든다 |
|  | notify() , notifyAll() | wait()메소드로 인해 일시 정지 상태인 스레드를 실행 대기 상태로 만든다. |
| 실행 대기로 보냄 | yield() | 실행 상태에서 다른 스레드에게 실행을 양보하고 실행 대기 상태가 된다. |

### 2.3 Thread 종료 하기

- stop() 메소드 deprecated( 더 이상 사용하지 않음)
1. 스레드 스스로 안전하게 종료하게 구현  → 리소스를 정리하고 run()을 종료

```java
private boolean stop;

public void run(){
	while( !stop) {
		// 스레드가 반복 실행하는 코드;
	}
	// 자원 정리
}
```

1. interrupt() 메소드 이용 
    - 스레드가 일시 정지 상태 있을 때 interruptedException 예외 발생
    
    ```java
    public class ThreadEx14 {
    	public static void main(String[] args) {
    		Thread thread = new PrintThread2();
    		thread.start();
    
    		try {
    			Thread.sleep(1000);
    		} catch (InterruptedException e) {
    		}
    	
    		thread.interrupt(); 
    	}
    }
    
    class PrintThread2 extends Thread {
    	public void run() {
    		while (true) {                          //1초 동안 실행 중 출력
    			System.out.println("실행 중");
    			if (Thread.interrupted()) {           //interrupt() 호출되면 break
    				break;              
    			}
    		}
    		System.out.println("자원 정리");
    		System.out.println("실행 종료");
    	}
    }
    ```
    

### 2.4. 데몬 스레드

💡 주 스레드의 작업을 돕는 도우미 스레드

- 주 스레드가 종료되면 데몬 스레드도 같이 종료
- 기동 시키기 전에 (start 하기 전) 데몬화 해야함
- 사용 예 ) 동영상 및 음악 재생 , 워드프로세스 자동 저장
- 주 스레드가 데몬이 될 스레드의 SetDaemon(true)를 호출

```java
class ThreadEx15 implements Runnable {
	static boolean autoSave = false;

	public static void main(String[] args) {
		Thread t = new Thread(new ThreadEx15());
		t.setDaemon(true); // 이 부분이 없으면 종료되지 않는다.
		t.start();

		for (int i = 1; i <= 20; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			System.out.println(i);

			if (i == 5)
				autoSave = true;
		}

		System.out.println("프로그램을 종료합니다.");
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(3 * 1000); // 3초마다
			} catch (InterruptedException e) {
			}

			// autoSave의 값이 true이면 autoSave()를 호출한다.
			if (autoSave) {
				autoSave();
			}
		}
	}

	public void autoSave() {
		System.out.println("작업파일이 자동저장되었습니다.");
	}
}
```
</br>

## 03. 동기화

### 6.1  동기화 메서드 블록

💡 스레드 작업이 끝날 때까지 객체에 잠금을 걸어 스레드가 사용 중인 객체를 다른 스레드가 변경 할 수 없게 함

- 인스턴스와 정적 메소드에 synchronized 키워드를 붙임
- JVM이 알아서 스케쥴링 해서 순서를 정한다.

### 6.2 동기화된 컬렉션

💡 하나의 collection객체에 2개 이상의 스레드가 공유해서 사용하는 경우(데이터 손실 가능성 있음), 스레드 세이프 하게 만들 때 사용

- Vector, ArrayList(동기화 안함) , StringBuffer(동기화 함), StringBuilder(동기화 안함)
- 모든 컬렉션 API는 동기화를 하지 않음
- `Collections 의 synchronizedXXX()` 를 사용하여 동기화
- read 작업량 < write 작업량 : SynchronizedList(List 객체)
- read 작업량 > write 작업량 : CopyOnWriteList<>()

## 04. 람다

💡 메서드 정의를 하나의 식으로 표현한 것

- 함수적 프로그래밍을 지원 기법으로 `익명 클래스 객체`가 된다.
- abstract메소드가 한개있는 인터페이스
- **@Functionalnterface  어노테이션** → 함수형 인터페이스 체크 어노테이션/컴파일러에게 추상 메소드가 하나인지 검사해줘!
- 실행 문장에 return 문 하나만 있을때 return 키워드 생략가능

```java
MyLamda.pr((int n) -> {return n+100}); 
MyLamda.pr(n) -> {return n+100});       // 매개변수 타입 생략
MyLamda.pr( n -> {return n+100});       // 매개변수 1개 일때 타입, 괄호 생략 가능 
MyLamda.pr( n -> n+100;
```

### 정적 메소드와 인스턴스 메소드 참조

💡 **정적 메소드** :  람다식에서 정적 메소드를 참조할 경우 클래스 이름 뒤에 :: 기호를 붙이고 정적 메소드 이름을 기술

💡 **인스턴스 메소드** : 인스턴스 메소드 일 경우에는 객체를 생성한 다음 참조 변수 뒤에 :: 기호를 붙이고 인스턴스 메소드 이름을기술

```java
fi = (x, y) -> x + y;
fi = Math::addExact; //

fi = LambdaTest7::sum; // 정적 메소드 참조

	public static int sum(int x, int y) {
		return (x + y);
	}
```

### 생성자 참조

💡 객체를 생성하는 것. 람다식이 단순히 객체를 생성하고 리턴하도록 구성되면 람다식을 생성자 참조로 대치 가능

- (a,b) → {return new 클래스(a, b); }
- 클래스 이름 뒤에 :: 기호를 붙이고 new 연산자를 기술
- 생성자가 오버로딩 되어 여러 개가 있을 경우, 컴파일러는 함수형 인터페이스의 추상 메소드와 동일한 매개변수 타입과 개수를 가지고 있는 생성자를 찾아 호출한다.

## Exercise01 /Thread
<details>
<summary>Exercise01 펼쳐보기</summary>
<div markdown="1">

## Exercise01 /Thread

1️⃣ **[실습 1]**

구현 클래스명 : ThreadLab

다음의 기능을 수행하는 프로그램을 구현하여 제출한다.

main 스레드 : 자식 스레드 4개를 기동하고 수행이 끝날 때까지 대기하다가 "MAIN 수행 종료" 를 출력하고 끝낸다.

자식 스레드 1 : 알파벳 대문자 A 부터 L 을 2초에 한 번씩 출력한다.
자식 스레드 2 : 알파벳 소문자 a 부터 h 를 3초에 한 번씩 출력한다.
자식 스레드 3 : 1 부터 30 까지 1초에 한 번씩 출력한다.
자식 스레드 4 : "JAVA"라는 문자열을 10번 5초에 한 번씩 출력한다.

모든 출력은 행 단위로 출력한다.
스레드 클래스명은 임의로 한다.

```java
public class ThreadLab {

	public static void main(String[] args) {
		//Thread mainThread = Thread.currentThread();
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		Thread3 thread3 = new Thread3();
		Thread4 thread4 = new Thread4();
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("MAIN 수행 종료");
	}

}

class Thread1 extends Thread {
	
	public void run() {
		for(char c = 'A' ; c <= 'L' ; c++ ) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(c);
		}
	}
}

class Thread2 extends Thread {
	
	public void run() {
		for(char c= 'a' ; c<='h'; c++ ) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(c);
		}
	}
}

class Thread3 extends Thread {
	
	public void run() {
		for(int i=0; i<30 ; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
	
}

class Thread4 extends Thread {
	
	public void run() {
		for(int i=0; i<10 ; i++) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("JAVA");
		}
	}
	
}
```
</div>
</details>


## Exercise02 / lambda
<details>
<summary>Exercise02 펼쳐보기</summary>
<div markdown="1">

1️⃣ **[실습 1]**

구현 클래스명 : 제시된 패키지의 소스들을 수정하고 패키지를 압축하여 제출한다.
(소스는 3개)

소스를 보고 람다식으로 변경 가능하다고 판단되는 부분은 변경하여 제출한다.

1. **sort - compartor**

```java
public class AnnonyInnerLab {
	public static void main(String[] args) {
		ArrayList<Book> al = new ArrayList<>();
		al.add(new Book("자바의 정석", "남궁성", 27000));
		al.add(new Book("챗GPT", "반병현", 11700));
		al.add(new Book("스타트 스프링 부트", "남가람", 27000));
		al.add(new Book("Doit! 자바프로그래밍", "박은중", 22500));
		al.add(new Book("이것이 자바다", "신용권,임경균", 36000));

		for (Book el : al) {
			System.out.println(el.getBookInfo());
		}

//		Collections.sort(al, new Comparator<Book>() {
//				@Override
//				public int compare(Book o1, Book o2) {
//						return o1.getPrice() - o2.getPrice();					
//				}
//			}
//		);
		
	Collections.sort(al , (o1,o2) -> {
		return o1.getPrice() - o2.getPrice();
	});
		
		System.out.println("[소팅 후 ]");
		for (Book el : al) {
			System.out.println(el.getBookInfo());
		}
	}
}
```

1. **Day9의 DrawableTest 를 변경**

```java
public class DrawableTest {
	public static void main(String[] args) {
		Random rand = new Random(); // 원하는 타입의 난수를 구하는 객체
		int num = rand.nextInt(3); //0~2사이 난수
		Drawable d = null;         //객체 초기화
		
		if(num == 0)
			d = () -> { System.out.println("사각형을 그립니다."); };
		else if(num == 1)
			d = () -> {System.out.println("원을 그립니다."); };
		else if(num == 2)
			d = () -> { System.out.println("마름모를 그립니다.");};
		
		output(d);
	}
	
	public static void output(Drawable d){
		System.out.println("전달된 객체의 클래스명 : "+
	                        d.getClass().getName());
		d.draw();
	}
}
```

1. **Runnable 의 람다**

```java
class ThreadEx01 {
	public static void main(String args[]) {
		ThreadEx1_1 t1 = new ThreadEx1_1(); // class 는 람다로 바꿀수 없음

		Thread t2 = new Thread(() -> {
			for(int i=0 ; i< 5 ; i++) System.out.println(Thread.currentThread().getName());
		}); // 생성자 Thread(Runnable target)

		t1.start();
		t2.start();
	}
}

class ThreadEx1_1 extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(getName()); // 조상인 Thread의 getName()을 호출
		}
	}
}

class ThreadEx1_2 implements Runnable {
	public void run() {
		for (int i = 0; i < 5; i++) {
			// Thread.currentThread() - 현재 실행중인 Thread를 반환한다.
			System.out.println(Thread.currentThread().getName());
		}
	}
}
```

</div>
</details>
