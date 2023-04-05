<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566913897/noticon/xbvewg1m3azbpnrzck1k.png" height="15%" width="15%"> <br/>

# 2023-03-17 / Exception

🗓️ 날짜            2023/03/14 

☁️ 날씨           🌞 맑음(2**°C)**


## 01. 예외 처리

💡 비정상적인 동작을 일으키며 프로그램이 종료되는 상황을 예측하여 막을 수 있는 처리를 하는 것

### 오류

- 컴파일 오류 : 구문에 위배된 구현 → 프로그래밍시 바로 알려줌!
- 실행 오류 : 프로그램 실행 후 알 수 있음 → 오류 잡기 까다로움!
    - **에러( Error )** : 자바 프로그램이 실행 하는 동안 JVM 영역에서 발생되는 오류, 심각한 오류. ex) outOfMemoryError(메모리 부족) , StackOverFlowError
    - **예외 (Exception)** : 자바 프로그램이 실행하는 동안 자바 프로그램 영역에서 발생하는 오류, 가벼운 오류, 예외에 대한 대처코드를 구현하여 적용 가능→ `예외처리구문`
        - 런타임 예외 : 발생 원인이 프로그램 내부 —> 발생할 수도 있는 예외에 대한 처리 코드 구현이 선택
        - 일반 예외 : 발생 원인이 프로그램 외부 —> 발생할 수도 있는 예외에 대한 처리코드 구현이 필수!

> **Integer.parseIng** → [NumberFormatException](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/NumberFormatException.html) →RuntimeExceptin → 선택적
> 
> 
> ![exception1](https://user-images.githubusercontent.com/55836020/225856203-208c0234-9abb-4ebf-951d-fbc4012198a1.png)
> 

> **Thread.sleep**  → [InterruptException](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/InterruptedException.html) → RuntimeExeption (x) —> 필수!
> 
> 
> ![exception](https://user-images.githubusercontent.com/55836020/225856219-2d45bebe-7812-48df-9c56-e4ae314e0eb7.png)
>

</br>

## 02. 예외 처리 구문관련 키워드

 💡  `try, catch, finally / throw / throws`

- JVM 예외 처리 매커니즘 - 프로그램 실행 종료, 콜백 메스드 정보, 에러 메시지

### 2.1 try,catch,finally

- 예외 발생 → catch블럭 → finally 블록 / 예외 발생 이후 코드는 실행하지 않음.
- catch문은 첫번째 catch문 부터 마지막 catch문까지 걸치면서 발생한 exception을 찾는다.
- 상위 클래스의 exception은 catch문 아래쪽으로 배치. (최상위  클래스는 Exception 마지막 catch블럭에 배치)
- return, break, continue 을 하더라도 finally 구문은 실행
- e.printStackTrace(); → 콜백 함수 출력하는 메소드

```
try {
	예외가 발생할 수도 있는 코드...
}catch(처리하려는 예외클래스 타입의 변수선언) {
	예외발생시 처리코드
}catch(처리하려는 예외클래스 타입의 변수선언) {
	예외발생시 처리코드
}
	:
}finally{
	예외 발생 여부와 관계없이 수행하려는 코드
}
```

### 2.2 예외 발생 - throw, throws
- **throw** : 예외를 발생
    - throw 예외 객체
    - ex) throw new IOException(”erro message”);
- **throws** : 예외를 알린다 . 예외를 넘긴다.

## Exercise 01

<details>
<summary>Exercise01 펼쳐보기</summary>
<div markdown="1">

<img src="https://user-images.githubusercontent.com/55836020/226284298-8ef32796-c8c9-4a6c-9961-c08f63ef4914.png" height="70%" width="70%"> <br/>

- **DuplicateException**

```java
public class DuplicateException extends Exception {
	public DuplicateException() {
		super("중복된 로또 번호가 발생했습니다.");
	}
}
```

- **LottoMachine**

```java
import java.util.Random;

public class LottoMachine {
	private int [] nums;
	
	public LottoMachine() {
		nums = new int[6];
	}
	
	public void createLottoNums() {
		Random random = new Random();
		for(int i=0  ; i<nums.length;i++) {
			nums[i]=  random.nextInt(20)+1;
		}
	}
	
	public void checkLottoNums() throws DuplicateException {
		
		for(int i=0; i<nums.length; i++) {
			for(int j=0 ; j<i; j++) {
				if(nums[i] == nums[j]) {
					throw new DuplicateException();
				}
			}
		}
	}

	public int[] getNums() {
		return nums;
	}
}
```

- **LottoGame**

```java
import day5.MethodLab7;

public class LottoGame {
	public static void main(String[] args) {
		LottoMachine lotto = new LottoMachine();
		
		lotto.createLottoNums();
		
		try {
			lotto.checkLottoNums();
		}catch(DuplicateException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		day5.MethodLab7.printArray(lotto.getNums());

	}
}
```

</div>
</details>
