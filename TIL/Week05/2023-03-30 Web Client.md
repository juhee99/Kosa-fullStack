<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1590043914/noticon/xe5nasyjil6mn6vk8c4s.png" height="15%" width="15%"> <br/>

# 2023-03-30 / Web Client

🗓️ 날짜            2023/03/30 

☁️ 날씨           🌞 맑음 ( 11°C )


## 01. Server/Client

💡 두대 이상의 컴퓨터들을 연결하고 서로 통신할 수 있는 것

### 1.1 🗄️ 서버

💡연결 요청을 먼저 기다리는 프로그램 

- 서비스 역할의 프로그램
- java.net.ServerSocket(서버주소: 고정 IP, 포트 : 0~65535),
- accept() : 연결 수락, 메소드가 호출될때(요청이 올 때 까지) 까지 기다림
- java.net.ServerSocket - 입력 스트림, 출력 스트림,

### 1.2 💻 클라이언트

💡 연결 요청을 수행하는 프로그램 

- 서버의 서비스를 필요로 하는 프로그램
- java.net.Socket(서버주소, 포트)객체를 직접 생성한다.
- 입력스트림 출력스트림
    
    

## 02. Web client Programming

### 2.1 WWW(World Wide Web)

💡WWW(World Wide Web, W3)은 인터넷에 연결된 컴퓨터들을 통해 사람들이 정보를 공유할 수 있는 전 세계적인 공간을 말한다.

- Web Server, Web Client(Browser), HTTP, HTML
- 🤵팀 버너스 리 → www 창시자

### 2.2 [HTML](https://www.w3schools.com/tags/default.asp)

- HTML5 이전 : 태그
- HTML5 : 태그 + API(JavaScript)
    - **웹표준**에 기반한 웹페이지 개발 지원
    - <audio>, <video>, <form> 강화 …
    - 웹스토리지, 캔버스, 웹소켓, 지오로케이션

### 2.3 웹 표준

💡 W3C에서 정한 표준 기술만을 사용하여, 웹 페이지 작성시 문서의 구조와 표현 방법, 상호 동작을 구분하여 구현하는 것

- 사용자는 장소와 기기에 상관없이 쉽게 볼 수 있다.
- 웹 개발자와 디자이너는 시간을 절약할 수 있다.
- 유지 보수 및 웹 접근성 확보할 수 있다.

## 03. HTML5의 요소

- 시작 태그(Start Tag) 와 종료 태그(End Tag)
    - ```<h1>contents</h1>```
- 태그 내 “속성”
    - ```<h1> contents </h1>```
- <head> </head> 와 <body> <body>
- 주석 : <!— 설명 —>
- HTML 태그의 컨텐트 또는 속성의 값에 의한 내용이 브라우저의 도큐먼트 영역에 출력(렌더링)될 때 태그에 따라 블럭스타일 태그와 인라인 스타일 태그로 나뉨
    - 블럭 스타일 : 태그의 내용이 랜더링되는 영역이 그 행 끝까지다.
        - hx, div, header, footer, section, nav, form, table, ul, li, ol
    - 인라인 스타일 : 태그의 내용이 랜더링되는 영역이 컨텐트의 내용 만큼이다.
        - a, img, input, span
        - 우선 순위가 높다.
- cache 기능 - 브라우저가 처음에 데이터를 불러오고 새로 도큐먼트를 부를 때 변경사항이 없으면 cache(임시 저장소)에서 가져옴

### edu 폴더를 부르는 용어

- IDE tool : 웹 프로젝트 폴더
- WAS(Web Application Server : Tomcat) :  컨텍스트
- 웹 개발자 : 웹 어플리케이션
- http://localhost:8088/edu/htmlexam/exam0.html  → URL(Uniform Resource Identity)

## 04. [Tag 정리](https://html5test.com/)

- **<iframe src=””>** </iframe> : 유튜브 video 불러올때
- **<video** src = “동영상파일 경로”>
- **<form>** <input type=””> </form>
    - action =”서블릿 프로그램의 url” method =”get/post/put/delete”
- ``` <input /> ``` : 입력 받기
    - type : email, url, number(숫자만 입력), range(슬라이스 막대), search, date, password(*표시)
    - name = “” 서버에 입력값을 보내기위함 , unique 해야함
    
    - reauired (필수로 입력), autofocus(선택안되었을때 자동 포커스)
    - placeholder ( text 힌트) , min, max
    - pattern=”[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}”
- ```<datalist> <option> </option> … </datalist>``` : selectBox
- ```<table> - 테이블 ,  <tr> 행 , <th> col이름 , <td> 행의 열```
    - colspan = “3” → 3개의 열을 묶어서 사용하겠다, rowspan → 행을 갯수만큼 묶어 사용
    
    ```html
    <table border = "1">
    <tr><th colspan = "3">이름,고향,나이</th></tr>
    <tr><td rowspan="2">둘리</td><td>쌍문동<td><td>10</td><tr>
    <tr><td></td>아프리카<td>9</td></tr>             <!--rowspan으로 열 하나 빼고-->
    ```
    
-``` <mark> </mark> : 텍스트를 강조```


## Exercise01 / Stream

<details>
<summary>📜Stream 실습 펼쳐보기</summary>
<div markdown="1">

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HTML Study</title>
</head>
<body>
<h1>HTML5 학습</h1>

<a href="https://www.naver.com/">Naver</a>&nbsp;<a href="https://github.com/juhee99">GitHub</a>&nbsp;<a href="https://www.w3schools.com/">W3Scools</a>

<h2>나의 소개</h2>
<ul>
<li>이름 : 박주희</li>
<li>별명 : 노란콩</li>
<li>관심기술 : Spring</li>
<li>취미 : YOGA</li>
</ul>


<h2>좋아하는 음식</h2>
<table border="1">
<tr><th>음식</th><th>종류</th></tr>
<tr><td>🥫 포카칩 초록색</td><td>과자</td></tr>
<tr><td>🥛 그릭 요거트</td><td>간식</td></tr>
<tr><td>🥓베이컨토마토디럭스🍔</td><td>햄버거</td></tr>
<tr><td>🍗 양꼬치 +꿔바로우 🥠</td><td>중식</td></tr>
</table>

 <br><br>

<h2>자랑하고싶은 우리동네의 아름다운 곳</h2>
<p>🥔 감자밭 : 춘천 유명 카페, 감자빵이 맛있어요🥯</p>
<img src="../images/potato.jpg">

 <br><br>
 
 <h2>동영상 재생</h2>
 <h4>원슈타인 싱글 노래 'single'나왔어요 많관부~~</h4>
 <iframe width="560" height="315" src="https://www.youtube.com/embed/2BzLz8pPS1c" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
 
 <br><br>
 
 <em>이 문서는 박주희에 의해 HTML 기술을 사용하여 2023년 03월 30일에 작성하였습니다.(ver 1.0)</em>
</body>
</html>

```

</div>
</details>
