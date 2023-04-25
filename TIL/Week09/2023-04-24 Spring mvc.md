<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566778017/noticon/ytjm1rralodyhvuggrpu.png" height="15%" width="15%"> <br/>

# 2023-04-24 / Spring mvc

🗓️ 날짜           2023/04/ 24

☁️ 날씨           🌥️ 대체로 흐림  (9°C)

</br>

## 다른 패키지 인식 방법

1. com.example.패키지 명 ⇒ 이 패키지 밑에 하위 폴더들은 어노테이션을 인식함. 
2. 다른 패키지도 인식하고 싶으면 → Application 클래스@ComponetScan(basePackages={”com.example.패키지명”,”추가하고 싶은 패키지”}) 를 추가
- com.example.~~ → 기본 패키지

## 웹 어플리케이션

💡 웹 어플리케이션은 클라이언트와 서버 사이에 HTTP 프로토콜을 이용하여 데이터를 주고 받으면서 동작하는 소프트웨어 프로그램이다.

![web architecture](https://user-images.githubusercontent.com/55836020/234234404-5cd74788-9b44-44b3-a212-a0043f92cb1b.png)

- jsp,servlet을 구분하여 스레드를 기동한다.
- spring은 dispatcherServlet을 사용하는데 service() 메소드를 호출한다.
    - service()메소드는 get,post방식을 구분하지 않고 호출되면 실행된다.

### 웹 어플리케이션 구조

- 티어 : 어플리케이션의 구조를 물리적으로 나눈 것
- 레이어 : 어플리케이션의 구조를 논리적으로 나눈 것
    - 피리젠테이션 레이어 : 컨트롤러, 뷰
    - 비지니스 로직 : 서비스, 도메인
    - 데이터 엑세스 레이어 : DAO

> 최대한 레이어 간에 의존 관계를 줄여야 유지보수성(확장성, 재사용성)이 좋은 애플리케이션이 된다.
> 

## 스프링 MVC 처리 흐름

💡 스프링 MVC는 프론트 컨트롤러 패턴을 적용한다. 프론트 컨트롤러 패턴이란 하나의 핸들러 객체를 통해서 요청을 할당하고, 일관된 처리를 작성할 수 있게 하는 개발 패턴이다.

- 스프링은  프론트 컨들롤러를 제공하는데 DispatcherServlet이다.

![dispatcherServlet](https://user-images.githubusercontent.com/55836020/234234410-fb1d9db1-ddab-4eef-9fec-68d3aecdbc2b.png)

### DispatcherServlet

- FrontController라고 불린다.
1. 모든 요청을 받는다.
2. 요청을 HandlerMapping 에서 받는다.
3. 매칭 되는 컨트롤러를 찾아 HandlerAdapter을 통해 컨트롤러를 실행한다.
4. controller 실행 결과를 리턴하여 view를 검색하여 응답

## Controller

💡@Controller로 등록된 클래스 파일에 대한 Bean객체를 자동으로 생상한다. component-scan 으로 자동 등록된다.

### 컨트롤러 메서드의 파라미터 타입

- HttpServletRequest, HttpServletResponse, HttpSession
- java.util.Locale : 요청한 지역 정보
- @RequestParam : HTTP요청 파라미터를 매핑
- @RequestHeader : HTTP 요청 헤더를 매핑
- @RequestBody : HTTP 요청의 몸체 내용에 접근
- @CookieValue : HTTP 쿠키 매핑

### 컨트롤러 메서드의 리턴 타입

- ModelAndView : 뷰 정보 및 모델 정보(데이터)를 담고 있는 ModelAndView객체
- Model : 뷰에 전달할 데이터를 담고 있는 Model객체 리턴, 이 때 뷰 이름은 요청 URL로부터 결정된다. (RequestToViewNameTranslator를 통해 뷰 결정)
- String :  뷰 이름을 리턴

### 컨트롤러 예제1 - 기본형 파라미터

```java
// requestMapping에 메소드 없으면 get,post 둘다 처리
@RequestMapping("/querystring4") 
	public ModelAndView proc(
	@RequestParam(value="name", required=false) String name2,
	@RequestParam(defaultValue="10") int number1,  
	@RequestParam(value="NUM2", defaultValue="100")int number2){
		ModelAndView mav = new ModelAndView();
		mav.addObject("spring", name1+":"+(number1 + number2) 
				+":"+name2);
		mav.setViewName("queryView1");
		return mav;
	}
```

- 파라미터에 값이 없을 때 String타입이면 오류가 안나지만  int는 오류 발생함
- 매개변수 명과 쿼리스트링 명을 다르게 하고 싶을 때@RequestParam()으로 쿼리스트링을 바꿀 수 있음→ 대신 다른 쿼리스트링으로 올때 오류 → 엄격해진다.

### 컨트롤러 예제 - 객체형 파라미터

```java
@PostMapping("/member2")
	public String proc2(@ModelAttribute("member") MemberDTO vo) {
		if( vo.getName() == null || vo.getName().equals("")) 			
			vo.setName("없음"); 
		if( vo.getPhone() == null || vo.getPhone().equals("")) 
			vo.setPhone("없음");
		if( vo.getId() == null || vo.getId().equals("")) 
			vo.setId("없음");
		if( vo.getPassword() == null || vo.getPassword().equals("")) 
			vo.setPassword("없음");				
		return "memberView";
	}
```

- @ModelAttribute() → 객체로 쿼리스트링을 받을 때 파라미터의 변수명과 model 변수명을 다르게 하고 싶을때

## Thymeleaf

💡 View Template Engine으로 컨트롤러에서 전달받은 데이터를 추출해 동적인 페이지를 만들 수 있다.

- 내츄럴 템플릿을 사용해 개발한다.
    - 내츄럴 템플릿 : 순수 HTML으로 유지 하는 것
    - thymeleaf는 순수 HTML로 구성되는 정적인 페이지를 서버 구동을 하면 동적으로 페이지가 생성된다.

### Thymeleaf 문법

1. ${…} : 변수 표현식
    - 속성으로 ⇒ th:text = “${name}+’안녕’ ”
    - contents에 표현할 때 ⇒ [[${name}]]
2. @{…} : URL 표현식
3. |…| : js백틱 사용법 동일
    - th:text = “|${name} 안녕|”
4. th:with=”${}” : 새로운 변수값을 생성
   

## Exercise01 / Spring thymeleaf

<details>
<summary>📜redirect,forward 실습 펼쳐보기</summary>
<div markdown="1">


1️⃣ 실습 
[4월24일_1.pdf](https://github.com/juhee99/Msa-Dkteckin-fullstack/files/11321012/4.24._1.pdf)

- eduForm.html

```html
<body>
	<form action="/educontroller" method="post">
		<h2>성적을 입력하시오.</h2>
		<hr>
		이름 : <input type="text" size="30" name="name"><br/>
		평균 점수 : <input type="number" name="avgScore"><br/>
		<button type="submit">전송</button>
		<button type="reset">재작성</button>
	</form>
</body>
```

- eduController.java

```java
@Controller
public class EduController {

    @PostMapping("/educontroller")
    public String edu( int avgScore){
        String result;

        if(avgScore >89){
            result = "gradeA";
        }else if (avgScore >79) {
            result = "gradeB";
        }else if(avgScore > 69){
            result="gradeC";
        }else{
            result="gradeD";
        }
        return result;
    }
}
```

- gradA ⇒ 나머지 생략

```java
<body>
<h1 >[[${param.name}]]은 A등급입니다. 우수한 성적이네요(^^)</h1>
<a th:href='${#request.getHeader("referer")}'>성적 입력화면으로</a>
</body>
```

</div>
</details>


## 🤷‍♀️ **today’s feeling**

- 쿼리 문자열 추출하는 방법 —> 중요
- 문자열은 equals로 비교 ⇒ (== 은 Object가 같은지도 체크하기 때문)
