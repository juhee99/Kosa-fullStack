<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566778017/noticon/ytjm1rralodyhvuggrpu.png" height="15%" width="15%"> <br/>


🗓️ 날짜            2023/05/19

☁️ 날씨           ☀️ 맑음 (21°C)


## 01. REST

💡사용자가 어떠한 요청을 했을 때 HTML을 리턴하지 않고 **필요한 결과 만 리턴**해 주는 방식이다.

- REpresentational State Transfer 의 약어로, 자원을 이름으로 구분하여 해당 자원의 상태(정보)를 주고받는 모든 것을 의미한다,
- HTTP URL를 통해 자원을 명명하고, HTTP Method(POST, GET, PUT, DELETE)를 통해 해당 자원에 대한 CRUD 작업을 적용한다.
- 사용자가 어떤 요청을 했을 때 HTML을 리턴하지 않고, 사용자가 필요로 하는 결과만을 리턴해주는 방식(JSON,XML)이다.

### 1.1 REST 가 필요한 이유

- 애플리케이션 분리 및 통합
- Web 을 기반으로 하는 C&S 환경의 다양한 프로그램 개발
- 다양한 클라이언트의 등장

⇒ 서버 하나로 다양한 클라이언트를 처리 할 수 있다. 

## 02. Rest 특징

1. **Server-Client(서버 클라이언트 구조)**
    - Server : API 제공 +  비지니스 로직 처리 (자원 제공)
    - Client : 사용자 인증, context(세션, 로그인 정보)
2. Stateless(비연결성)
3. Cacheable(캐시 처리 기능)
4. Layered System(계층화)
5. Code-On-Demand 
6. `Uniform Interface(인터페이스 일관성)`
    - 자원을 URL로 식별되게 한다.
    - 응답 메세지만 봐도 해당 메세지가 무엇을 제공하는지 알 수 있어야 한다.
    - hal 규약으로 작성되는 응답 메시지를 통해 상태 전이 와 Hyperlink를 이용한다.

## 03. REST API 설계 기본 규칙

💡 URI는 자원을 표현하는 데에 집중하고 행위에 대한 정의는 HTTP METHOD를 통해 하는 것이 REST한 API를 설계하는 중심 규칙이다

### 3.1 URL는 정보의 자원을 표현해야 한다.

- 동사보다는 명사, 대문자 보다는 소문자 사용
- 하이픈(-)은 불가피 하게 긴 경로를 사용해야 할 때
- 파일 확장자는 URL에 포함시키지 않는다.
- Rest 리소스 간에 연관 관계가 있을 때, /리소스명/리소스 ID/관계 있는 다른 리소스 명

### 3.2 HTTP Method(CRUD)

**GET**

- 쿼리 스트링 으로 데이터를 받는다.
- @RequestParm
- 응답 시 default로 text/plain
    
    다른 형태로 응답 받기 위해 헤더에 응답 받고 싶은 형태를 담아 전달해야 한다.
    

**POST**

- 요청 body로 데이터를 받는다 → json형태
- @RequestBody
    - body로 받을 때 꼭 어노테이션 사용해야함!

**PUT**

- 요청 body 안에 요청 파라미터를 받는다.
- 기존에 있던 데이터를 변경하는 기능

**DELETE**

- 데이터를 삭제 하는 기능

### 자원을 표현하는 Collection과 Document

- Doucment :문서 한개 또는 한개의 객체
- Collection : 문서들의 집합, 객체의 집합
- ex) http://restapi.example.com/sports/soccer/players/13
    - sports :**collection** / soccer: **document** , players : **collection** , 13 : **document**

<img src="https://github.com/juhee99/Kosa-fullStack/assets/55836020/e118a0ed-93fb-452e-b6ae-9513ab4ce6c3" width="80%" />

## Response Code

- 200 : OK,  요청 성공
- 201 : Created , 요청을 성공했고 , 새로운 리소스 생성되었다(post, put)
- 205 : Reset Content, 응답을 완료 했고, view를 reset해라 → update
- 401 : unauthenticated
- 405 : 요청한 방식이 잘못 되었을 때
- 404 : resource 가 없을 때
- 500 : 서버에 error가 있을 때

## ResponseEntity

💡 ResponseEntity 는 http 응답을 빠르게 만들어주기 위한 객체이다. 권장되는 방법

- @ResponseBody와 달라 객체로 사용 된다.
- 응답의 상태, 헤더, body 정보를 지정 가능하다.
- Constructor보다는 Builder패턴 사용이 권장 된다.

```java
@GetMapping("/example")
public ResponseEntity<String> example(){
	String obj = "{\"name\" : \"홍길동 \"}; 
	HttpHeader header = new HttpHeader();
	header.add("Content-type", "application/json; charset=UTF-8");
	
	return ResponseEntity.OK()
					.headers(headers)
					.body(obj);						
}
```

## 기타

- api test → Talend API Tester → 브라우저에 설치

## 🤷‍♀️ **today’s feeling**

- 인턴 당시, 한 서버를 가지고 웹.모바일 클라이언트를 개발했던 경험이 있었다. Rest API의 편리성을 느낄 수 있었다.
