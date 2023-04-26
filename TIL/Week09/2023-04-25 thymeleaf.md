<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566778017/noticon/ytjm1rralodyhvuggrpu.png" height="15%" width="15%"> <br/>

# 2023-04-20 / Ioc

🗓️ 날짜           2023/04/25

☁️ 날씨           ☔ 비 약간 (12°C)

## Thymeleaf

💡Thymeleaf 파일은 일반 HTML 파일과 다를 것이 없다.

- 원하는 HTML 태그에 ‘th’라는 prefix를 사용
- <html xmlns:th=”http://www.thymeleaf.org”> → 최상위 태그에 추가해 줘야함

### Thymeleaf 문법

- ${…} : 변수 표현식
    - `th:속성명` 에서만 사용 가능
    - th:text = “${…}” ⇒ text로만
    - th:utext = “${…}” ⇒ 태그 인식
- @{…} : url 표현식
    - 서버의 contextPath를 추가한 URI로 변경 된다
    - @{/vdelete(id=${vo.id})} —> “/contextPath/vdelete?id=2”
- 문자열 합치기
    - |….| : js 백틱 사용법 동일
    - + 연산자 : 대신 큰따음표 안에 작은 따음표로 표시
- 비교 연산자
    - 삼항 연산 : ${info.name == kim ? ‘ok’ : ‘no’} → 연산의 결과를 출력
    - 이항 연산
- html 컨텐트 설정
    - th : text = “${…}”
- th:if , th:unless(else)
    - <p th:if=”${…}”>입장 가능 </p> —> 조건이 만족하면 p태그를 보여준다.
- th:block 태그
    - <th:block th:if=”${..}”><hr><p>..</p><hr></th:block> → th:block 의 조건이 만족하면  자식태그를 보여주겠다.
- th:switch, th:case
    
    ```html
    <th:block th:switch="${info.name}">
     <div th:case="올라프">겨울왕국</div>
     <div th:case="또치">아기공룡둘리</div>
     </th:block>
    ```
    
- th:each
    - for 반복문과 비슷하다.
    
    ```html
    <th:block th:each="data:${datas}">
    <h1 th:text="${data}"></h1>
     </th:block>
    ```
    
    - `status` 변수를 추가해 row에 대한 추가 정보를 얻을 수 있다.
    
    > index:0부터 시작, count : 1부터 시작
    > 
    > 
    > size : 총 개수 , current : 현재 index의 변수
    > 
    > even/odd : 짝/홀수  여부 , first/last : 처음/마지막 여부
    > 

## @ModelAttribute

- 메소드 레벨, 메소드의 파라미터에 적용
- 요청시 전달하는 값을 오브젝트 형태로 매핑해 주는 어노테이션
- modelattribute로 지정된 메소드들이 먼저 실행된다.-> 미리 만들어야 할 객체가 있을 때 사용

```java
@Controller
public class TestModelController2 {
	@ModelAttribute("data1")
	public int createModel1() {	
		System.out.println("createModel1() 호출");
		return 100;
	}
	@ModelAttribute("data2")
	public int createModel2() {	
		System.out.println("createModel2() 호출");
		return 200;
	}
	@RequestMapping(value="/modeltest2")
	public String handle(@ModelAttribute("data1") int vo1, 
			      @ModelAttribute("data2") int vo2) {		
		System.out.println("handle 에서 출력 : "+vo1 + " - " + vo2);
		System.out.println("=============================");
		return "modelResult2";
	}	
}
```

## Session

### @SessionAttributes

💡 @ModelAttribute 또는 model.addAttribute()를 활용하여 객체를 저장할 경우 세션에 저장

- 여러 화면(요청)에 사용해야하는 객체를 공유할 때 사용한다.
- 클래스에 선언
- sessionAttributes에 등록된 ModelAtrribute는 최초 한번만 등록된다.
- SessionStatus 객체
    - session.setComplete() : 세션객체 안에 있는 세션 삭제 → 원하는 세션만 삭제 불가능, 다 삭제됨
    - 특정 세션만 삭제 할려면 session객체를 사용해야함

### Session 객체

- HttpSession 객체 를 메소드의 파라미터로 넣으면 스피링이 알아서 객체 생성
- session.getAttribute(”세션 객체명”)
- session.setAttribute(”세션 객체명”,값);
- session.removeAttribute(”세션 객체명”);

```java
@RequestMapping(value="/count2")
	public void handle(int num1, int num2, HttpSession s) {
		System.out.println(s.getId());
		if(s.getAttribute("count3") == null )
			s.setAttribute("count3", new CountDTO());
		}
		CountDTO vo3 = (CountDTO)s.getAttribute("count3");
		
		vo3.setCountNum(num1);

		System.out.println("handle() : "+ vo3.getCountNum());
		System.out.println("=============================");
	}
```

## StringBuffer vs StringBuilder

💡 주로 문자열을 편집할 때 사용하며 API 사용 방법이 거의 동일

### StringBuffer

- thread safe :다중 스레드에 대해 대비가 되어 있다.
    - 한 스레드가 사용되면 다른 스레드는 접근 할 수 없다.
    - 이 기능이 성능을 저하 시키는 단점이 있다.
    - 다중 스레드 환경에 적절

### StringBuilder

- thread not safe : 스레드와 관계없이 사용
- 단일 스레드 환경에서 사용

## Model 객체

💡 DispatcherServlet이 view에게 데이터를 전달 

- spring이 model객체를 재활용 한다.
- spring의 권장 사항
- 메소드의 파라미터에 Model 타입이 지정된 경우 스프링은 Model 객체를 만들어 메서드에 주입한다.
- model.addAttribute(”key”, “value”);

```java
@RequestMapping(value = "/userSave", method = RequestMethod.POST)
// 쿼리 문자열을 객체로 받겠다.(객체의 멤버 변수와 쿼리 문자열이 같아야 함)
	public String userSave(UserVO userVo, Model model) { 
		System.out.println("----- UserController.userSave() : POST -----");
		System.out.println("userInfo : " + userVo.toString());
		model.addAttribute("msg", "SUCCESS");
		return "userInfo";
	}
```

## @ReponseBody

💡 controller가 직접 응답할 때 사용한다.

```java
@Controller
public class ResponseBodyController {
	
	@RequestMapping(value = "/body/json/{id}", produces = "application/json; charset=utf-8")  // text/json
	@ResponseBody
	public MyModel getByIdInJSON(@PathVariable String id) {
		MyModel my = new MyModel();
		my.setFlowerName("장미");
		my.setNum(5);
		my.setId(id);
		System.out.println(my);
		return my;
	}
}
```

> 위 코드 설명
> 
> - id -> text/ 뒤에 오는 문자는 id라는 변수에 넣어진다.
> - @PathVariable url문자열의 정보
> - produces = "application/json; charset=utf-8" -> 마인 타입으로 응답되는 타입을 알려줘야 함
> - 클라이언트 객체에게 전달하고 싶은 형식에 맞춰 객체를 만들어 리턴 하면 된다.

## 기타

- 정적 자원으로 응답 할 때
- InternalResourceView 객체에 담아서 사용해야함.
    
    ```java
    @RequestMapping("/static")
    	public ModelAndView xxx(){
    		InternalResourceView view = new InternalResourceView("/staticview.html");
    		ModelAndView viewModel = new ModelAndView(view);
    		return viewModel;
    	}
    ```

## Exercise01 / thymeleaf

<details>
<summary> 📜thymeleaf 실습 펼쳐보기</summary>
<div markdown="1">

[4월25일_1.pdf](https://github.com/juhee99/Msa-Dkteckin-fullstack/files/11327743/4.25._1.pdf)

- **lottoForm.html**
    
    ```html
    <body>
    <h1>Lotto Game</h1>
    <div><a href="/lotto?lottoNum=1" class ="shadow"><img src="images/1.png" alt="1"></a></div>
    <div><a href="/lotto?lottoNum=2" class ="shadow"><img src="images/2.png" alt="2"></a></div>
    <div><a href="/lotto?lottoNum=3" class ="shadow"><img src="images/3.png" alt="3"></a></div>
    <div><a href="/lotto?lottoNum=4" class ="shadow"><img src="images/4.png" alt="4"></a></div>
    <div><a href="/lotto?lottoNum=5" class ="shadow"><img src="images/5.png" alt="5"></a></div>
    <div><a href="/lotto?lottoNum=6" class ="shadow"><img src="images/6.png" alt="6"></a></div>
    </body>
    ```
    
- **lottoController.java**

```java
@Controller
public class lottoController {
    @GetMapping("/lotto")
    public String lotto(LottoDTO dto , Model model, HttpSession session){
        int ran = (int)((Math.random()*6)+1);
        String msg="";

        if(session.getAttribute("cnt") == null){
            session.setAttribute("cnt",new CountDTO());
        }

        CountDTO cnt = (CountDTO)session.getAttribute("cnt");

        if(cnt.getCountNum() >= 2){
            dto.setResult("over");
            dto.setImgName("");
            msg="로또 응모는 낙첨된 경우에 한하여 3번 까지만 가능합니다.<br>브라우저를 재기동한 후에 응모해 주세요";

        }else{
            if(dto.getLottoNum() == ran){
                dto.setResult("success");
                dto.setImgName("");
                msg="추카추카!!";
                session.removeAttribute("cnt");
            }else{
                dto.setResult("fail");
                dto.setImgName("");
                cnt.setCountNum(1);
                msg="아쉽네요.. 다음 기회에!!";
            }
        }

        model.addAttribute("lotto",dto);
        model.addAttribute("msg",msg);

        return "lottoView";
    }
}
```

- **lottoView.html**

```html
<body>
<h1>로또 결과</h1>
<div>
<h2 th:utext="${msg}"></h2>
<img th:src="${lotto.imgName}">
</div>
<a th:if="${lotto.result.equals('fail')}" th:href='${#request.getHeader("referer")}'>재시도...</a>
</body>
```


</div>
</details>


## Exercise02 / ResponseBody+Ajax

<details>
<summary> 📜ResponseBody+Ajax 실습 펼쳐보기</summary>
<div markdown="1">

[4월25일_2.pdf](https://github.com/juhee99/Msa-Dkteckin-fullstack/files/11327744/4.25._2.pdf)


1. **myteam.html**

```html
<body>

<h1>우리팀 소개</h1>
<hr>
<button onclick="go('name')">우리 팀명</button>
<button onclick="go('member')">우리 팀원</button>
<div id="teamContainer">
</div>

<script>
  function go(option){
    let request = new XMLHttpRequest();
    request.onload = function () {
      if (request.status == 200) {
        const result = document.getElementById("teamContainer");
        let json = JSON.parse(request.responseText);

        if(option == 'name'){
          result.innerHTML="";
          result.innerHTML+=`<h2>우리팀의 팀명은 ${json.teamName} 입니다.</h2>`
        }else{
          result.innerHTML="";
          result.innerHTML+=`<h2>${json.teamName}팀의 팀원들을 소개합니다.</h2>`
          json.teamMember.map((data) => {
            result.innerHTML+=`<p>${data.name}: 별명은 ${data.nicName} 좋아하는 음식은 ${data.food}입니다.</p>`
          });
        }
      }
    };

    request.open('GET','/team',true);
    request.send();
  }
</script>

</body>
```

2.  **MyteamController.java**

```java
@Controller
public class MyTeamController {

    @RequestMapping(value = "/team",produces = "application/json; charset=utf-8")
    @ResponseBody
    public TeamDTO myTeamInfo(){

        TeamDTO team = new TeamDTO();

        team.setTeamName("T-ko");

        List<TeamMemberVO> teamMember = new ArrayList<TeamMemberVO>(4);
        teamMember.add(new TeamMemberVO("김xx","또라이","마파두부 덮밥"));
        teamMember.add(new TeamMemberVO("김xx","열정대엽","치킨"));
        teamMember.add(new TeamMemberVO("홍xx","핑크공쥬","과자 다 좋아해요"));
        teamMember.add(new TeamMemberVO("박xx","노란콩","치킨"));

        team.setTeamMember(teamMember);
        return team;
    }
}
```
<div>
<details>

## 🤷‍♀️ today’s feeling

- th:utext —> 태그 인식해서 내용 출력
- 실습 2번째 문제에 `ajax` 부분 다시 확인해보기
- @ModelAttribute 와 Model 객체 둘 중 하나만 사용해도 된다. → 개념 헷갈리지 않기
    - model 객체 사용이 권장법으로 model객체 사용법 익히기
