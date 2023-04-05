<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566913897/noticon/xbvewg1m3azbpnrzck1k.png" height="15%" width="15%"> <br/>

# 2023-03-22 / Serialzation

🗓️ 날짜           2023/03/23 

☁️ 날씨           🌤️ 부분적으로 맑음 ( 11°C )
</br>

## 01. 객체 직렬화(Serialzation)

💡 객체의 내용을 지속적으로 보관하고자 할 때 사용되는 기술(영구적으로 보관하기 위함)

- 메모리를 디스크에 저장하거나 네트워크 통신에 사용하기 위한 형식으로 변환하는 것
- **직렬화(Serialization)** : 객체를 구성하는 인스턴스 멤버 변수들을 바이트 스트림으로 변환하는 것
- **역 직렬화(Deserialzation)** : 바이트 스트림의 내용을 읽어 다시 객체를 만들어 내는 것
- Session 구성 할때 내부적으로 사용됨
- FileInputStream(파일 읽어들임) , FileOutputStream(파일로 내보내기)
- ObjectInputStream (객체 읽어들임) , ObjectOutputStream(객체 내보내기)

![Stream)](https://user-images.githubusercontent.com/55836020/227082375-fc640f44-3e94-4c81-831b-34fc18a8aa75.png)
</br>

### 1.1 직렬화 가능한 객체 구현

- 직렬화 할 수 있는 객체는 **java.io.Serializable** 인터페이스를 상속 받아야 한다.
- **serialVersionUID** : version을 관리하기 위한 유의미한 값
    - serialVersionUID를 지정하지 않으면 컴파일러가 계산한값 부여
    - Serializable class 또는 Outer class의 변경이 있으면 serialVersionUID값도 바뀐다.
    - serialize 할 때와 Deserialize 할 때의 serialVersionUID 값이 다르면 InvalidClassException 발생하여  restore 할 수 없다.
    - EX) private static final long serialVersionUID = 123583321231;
- **transient** 제어자 : 특정 인스턴스 멤버는 직렬화할때 제외하겠다.
    - EX) transient private String password;
    - 역정렬 할때에는 기본값을 가진다.

</br>

## 02. URL 프로그래밍

💡 URL 클래스를 이용하는 프로그래밍- java.net.URL

- I/O 프로그래밍 , Network프로그래밍
- URL(Uniform Resource Locator) : 어떠한 `자원의 위치`를 알리는 단일화된 형식의 문자열(주소)
- HTTP URL : 웹 사이트의 주소 문자열
- JDBC URL : 접속할 DB서버와 JDBC 드라이버 정보를 정해진 규격으로 작성한 문자열
- java.net.URL : 웹 서버에 접속하여 컨텐츠를 요청하는 프로그램을 개발할 때 사용
    - 객체 생성
    - openStream() : InputStream - GET방식

</br>

## 03. Enum

💡 특정한 의미를 가진 상수를 묶을때 열거하여 사용하는 열거형 타입

- 요일,계절,색상 등 한정된 값을 갖는 타입
- 열거 타입 이름은 캐멀 스타일(첫문자를 대문자)
    - ex ) public enum Season { SPRING, SUMMER, FALL, WINTER }
- 서로 다른 형태를 한 묶음으로 만들 수 있음 —> Y(”1”, true) , N(”0”, false)
    - ⚠️ 불규칙한 특정 값을 저장할 수 있는 인스턴스 변수와 생성자를 별도로 추가해야만 한다.
    - private final type 변수명 ; 생성자, 변수 접근 메서드
    - 일반적으로 사용되지 않음.
        
        ```java
        enum Rainbow {
            RED(3), ORANGE(10), YELLOW(21), GREEN(5), BLUE(1), INDIGO(-1), VIOLET(-11);
        
            private final int value;
            Rainbow(int value) { this.value = value; }
            public int getValue() { return value; }
        
        }
        ```

</br>

## Excersise01 / 직렬화

<details>
<summary>Exercise01 펼쳐보기</summary>
<div markdown="1">

1️⃣ 실습1

소스명 : ImageIOLab.java

(1) list.txt 파일의 내용을 읽는다.
파일 안에는 이미지 이름과 읽어올 이미지의 URL 문자열이 존재한다.
(2) 지정된 URL로 이미지 파일을 읽어와서 c:/iotest/myimage 폴더에
이미지 이름으로 저장한다.(10개)

- 생성되는 이미지 파일명은  cuteone.jpg, cutetwo.jpg .... cuteten.jpg 이다.

(3) 구현된 소스와 이미지 파일 10개를 압축하여 제출한다.

```java
public class ImageIOLab {

	public static void main(String[] args) {
		String path =  "c:/iotest/myimage";
		File isDir = new File(path);
		if(!isDir.exists()) {
			isDir.mkdirs();
		}
		
		try(FileReader reader = new FileReader("c:/iotest/list.txt");
				BufferedReader br = new BufferedReader(reader);){
			String data;
			String fileName;
			URL req = null;    
			InputStream is = null;
			FileOutputStream fos = null;
			String [] arr = new String[2];
			int input = 0;
			
			while(true) {
				data=br.readLine();
				if(data == null) break;
				arr= data.split(",");
				fileName = path+"/"+arr[0]+".jpg";
			
				req = new URL(arr[1]);
				is = req.openStream();
				fos = new FileOutputStream(fileName);
				
				input=0;
				while(true) {
					input = is.read();
					if(input == -1) break;
					fos.write(input);
				}
				
				fos.close();
				System.out.printf("%s가 성공적으로 저장되었습니다.\n",arr[0]+".jpg");
			}
			
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("파일이 존재하지 않습니다.");
		}catch(MalformedURLException e) {	
			System.out.println("URL문자열 오류 : " + e.getMessage());
		} catch (IOException ioe) {
			System.out.println("IO 오류 : " + ioe.getMessage());
		}

	}

}
```
</div>
</details>
