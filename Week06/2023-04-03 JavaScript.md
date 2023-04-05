<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566913897/noticon/xbvewg1m3azbpnrzck1k.png" height="15%" width="15%"> <br/>

# 2023-04-03 / JavaScript

🗓️ 날짜           2023/04/ 03

☁️ 날씨           🌞 맑음 ( 17°C )

</br>

## JavaScript 공부 순서

1. 구문
2. 기본 API : 표준 API, BOM, DOM
3. Map API : Kakao API, Google API
4. HTML API : Drag & Drop, Storage
5. Ajax 프로그래밍 : 
6. EcmaScript 6 에서 추가된 구문

## 01. JavaScript 기본

### 1.1 JavaScript 활용범위

- 웹 클라이언트 개발
    - 웹이 발전하면서 서버에서 처리되던 기능들이 클라이언트로 이동되었으며 , HTML5에서는 웹 클라이언트에서 처리하려는 기능들을 표준적인 방법으로 구현할 수 있게 지원하는 API들을 JavaScript로 제공한다.
- 웹 서버 개발
    - Node.js의 출현으로 JavaScript를 활용한 서버 개발도 가능하게 되었다. express,nest.js 등 라이브러리는 보다 쉽게 javaScript로 서버 개발할 수 있는 환경을 제공해 준다.

### 1.2 JavaScript 정의 방법

💡 javaScript코드는 HTML 내의 어느 부분에도 삽입해도 가능하나 주로 <body> 태그의 마지막 부분 즉 </body> 태그 바로 위에 삽입한다. →html을 먼저 읽어 렌더링을 빠르게 하기 위해서

### 1.3 JavaScript 타입

- 숫자 타입 : 100, 3.14
- 문자열 타입 : ‘가나다’ , “abc”
- 논리 타입 : true, false
- null - 객체가 없다
- undefined - 값이 없다.

### 1.4 주요 연산자

1. 수치 연산 : +, -, /, %, ++,—, -,
2. 비교 연산 : <,>, < =, > ==,===(타입확인), ! =, ! ==
3. 조건 연산자 : && (AND), || (OR), ! (NOT), ?
4. 대입 연산자 : =, +=, -=, *=, /=, %=
5. 타입 점검 연산 : typeof, instanceof

> + 는 string을 숫자로 형변환이 안된다 → 문자열 + 연산으로 처리됨
> 

### 1.5 제어문

1. 조건 제어문 if , 다중 분기문  switch
2. 반복 제어문 for, while, do-while , for ..in(for-each)
3. 분기 제어문 break, continune
4. 예외처리 구문 try-catch-finally

### 1.6 window API

- window.alert() : 경고창을 통해서 메시지를 알리는 역할
- window.prompt() : 필요한 데이터를 입력받는 역할의 서브창 출력
    - 입력없이 확인버튼 클릭되면 —→ ‘’
    - 취소버튼 클릭 되면 —→ null
    - isNaN() → 숫자가 올 수 있는지 여부
- window.comfirm() : 양자 택일을 선택할 수 있는 역할의 서브창 출력

## 2.0 js 변수의 종류

- **var**  : 전역 범위, 함수 범위
    - block scope 지원하지 않음
    - 재 선언 될 수 있고 업데이트 될 수 있다.
    - var의 호이스팅 :  변수 선언이 자동으로 맨 위로 이동되는 매커니즘 → undefined로 초기화 됨
- **let** : 블록 내에서만 사용가능 , var의 상위호환
    - block scope 지원 함.
    - 업데이트 가능, 재 선언 불가
    - let의 호이스팅: 변수 선언이 자동으로 맨 위로 이동 됨 → 초기화 되지 않음 (Reference Erro)
- **const** : 블록 범위
    - 일정한 상수 값으로 유지
    - 업데이트 불가능, 재 선언 불가능
- **변수 타입 선언 안 할 때**
    - 전역 변수로 선언한 것과 같음
    - erro 발생은 하지 않지만 지양해야 하는 방법

## 03. js 신문법

- a && b —> 조건식 && 조건식이 참일때 수행하려는 식
- a   ||   b —> 조건식 || 조건식이 거짓일때 수행하려는 식
- null ?? undefined ??  —→ undefined,null 같은 nullish만 검사
- a?.b 문법  —> a가 null이거나 undefined 여도 에러가 아닌 undefined를 남긴다.

## 04. 기타

### 4.1 CSS

- ../mycss → 상위 디렉토리 , ./mycss → 현재 디렉토리 , mycss → 같은 디렉토리
- 304(cache) , 200(서버에서)
- 브라우저는 cache를 가지고 있기 때문에 코드를 수정하더라도 변경 안될 때 가 있다.
    - html이 변경될 때만 cache 새로고침함
    - ctrl + shift + R ⇒강력 새로고침
- section > h1 - 자식( 바로 밑 하위 레벨)
- section h1 - 자손(하위 레벨의 모든 태그)
- E:nth-child(n) : 부모의 n번째 자식인 , E요소
- E:nth-of-type(n) : 같은 유형의 n번째인 , E요소

### 4.2 JavaScript

- Number() → string 을 숫자로
    - Number(num) + 10
- parseInt() → 정수만 리턴 , 소수점 이하 날림
- parseFloat() —> 실수로만 리턴
- Math.floor() → 소수점 날려버림
- Math.floor() → 소수점 날려버림
- Math.random() —> 0 < ran <1   —→ Math.floor(Math.random())


## 📎 오늘의 느낌 점
- eclips로 js를 구현 하다보니 VScode가 제공하는 tool의 이점을 느끼게 되었다.
- 등가연산 == 와 ===(타입까지 ) 의 차이점을 알게 되었다.


## Exercise01 / CSS
<details>
<summary>📜 CSS 펼쳐보기</summary>
<div markdown="1">
<img src="https://user-images.githubusercontent.com/55836020/229955272-46159d88-68cd-40af-887f-09130210fda7.png" width="20%/>

```html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HTML Study</title>
<style>
header {
	padding: 20px;
	text-align: center;
	background-image: linear-gradient(to bottom, #FEFF86, #B0DAFF, #B9E9FC, #DAF5FF);
	font-family: Arial, sans-serif;
	text-align: center;
}

h1 {
	color: #E97777;
	font-family: Arial, sans-serif;
	text-shadow: #FCDDB0 1px 1px 2px;
}

a {
	margin: 5%;
	font-family: Arial, sans-serif;
	color: #937DC2;
}

a:hover {
	color: #C689C6;
	font-family: Arial, sans-serif;
	font-weight: bold;
}

section {
	padding: 3%;
	width: 500px;
	text-align: center;
	font-family: Arial, sans-serif;
	margin: 0 auto;
}

article {
	bottom: 2%;
	padding: 2%;
	border: 1px dashed #14C38E;
	border-radius: 30px;
	text-align: left;
	margin-top: 20px;
}

section article:nth-of-type(1) h2 {
	color: #F2CD5C;
	font-family: Gmarket Sans;
}

section article:nth-of-type(2) h2 {
	color: #FFE15D;
	font-family: Gmarket Sans;
}

section article:nth-of-type(3) h2 {
	color: #FFB319;
	font-family: noto snas;
}

span {
	color: #CC9B6D;
	font-family: Gmarket Sans;
}

figure {
	text-align: center;
	font-family: Gmarket Sans;
}

figure img:hover {
	opacity: 0.5;
}

footer, aside {
	text-align: center;
	font-family: Gmarket Sans;
}

aside h2 {
	color: #FFD966;
}

table {
	border: 2px solid #9E9D89;
	border-collapse: collapse;
	text-align: center;
}

th {
	background-color: #E2BCB7;
}
</style>
</head>
<body>
	<header>
		<h1>박주희의 HTML5 학습</h1>

		<nav>
			<a href="https://www.naver.com/">Naver</a>&nbsp;<a
				href="https://github.com/juhee99">GitHub</a>&nbsp;<a
				href="https://www.w3schools.com/">W3Scools</a>
		</nav>

	</header>
	<section>
		<article>
			<h2>나의 소개</h2>
			<ul>
				<li>이름 : 박주희</li>
				<li>별명 : 노란콩</li>
				<li>관심기술 : Spring</li>
				<li>취미 : YOGA</li>
				<li>MBTI : ISTP</li>
			</ul>
		</article>

		<article>
			<h2>🍱좋아하는 음식 🍱</h2>
			<table border="1">
				<tr>
					<th>음식</th>
					<th>종류</th>
				</tr>
				<tr>
					<td>🥫 포카칩 초록색</td>
					<td>과자</td>
				</tr>
				<tr>
					<td>🥛 그릭 요거트</td>
					<td>간식</td>
				</tr>
				<tr>
					<td>🥓베이컨토마토디럭스🍔</td>
					<td>햄버거</td>
				</tr>
				<tr>
					<td>🍗 양꼬치 +꿔바로우 🥠</td>
					<td>중식</td>
				</tr>
			</table>
		</article>

		<article>
			<h2>
				자랑하고싶은 <span>우리동네</span>의 아름다운 곳
			</h2>
			<p>🥔 감자밭 : 춘천 유명 카페, 감자빵이 맛있어요🥯</p>
			<figure>
				<img src="../images/potato.jpg">
				<figcaption>감자빵</figcaption>
			</figure>
		</article>
	</section>

	<aside>
		<h2>동영상 재생</h2>
		<iframe width="560" height="315"
			src="https://www.youtube.com/embed/kaUuyO-D4XE"
			title="YouTube video player" frameborder="0"
			allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
			allowfullscreen></iframe>

	</aside>

	<footer>
		<em>이 문서는 박주희에 의해 HTML 기술을 사용하여 2023년 04월 03일에 작성하였습니다.(ver 1.2)</em>
	</footer>
</body>
</html>
```



</div>
</details>


## Exercise02 / JavaScript
<details>
<summary>📜 JavaScript 펼쳐보기</summary>
<div markdown="1">

1️⃣ **[실습 1]**

파일명 : exercise1.html

(1) <body> 태그의 첫번째 자식 태그로 <h1>자바스크립트 첫 번째 실습</h1> 과 그리고 두 번째 자식 태그로 <hr> 을 작성한다.
(2) window.prompt("숫자를 한 개를 입력하세요..") 를 사용해서 입력을 받는다.
(3) 입력된 숫자에 10을 곱한 결과는 <h2> 태그와 함께 도큐먼트 영역에 출력한다.
(4) 입력된 숫자에 10을 뺀 결과는 자바스크립트 콘솔 창에 출력한다.

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaScript first exam</title>
</head>
<body>
<h1>자바스크립트 첫 번째 실습</h1>
<hr>
<script>
var num = window.prompt("숫자를 한 개 입력하세요.");;
document.write("<h2>"+(num*10)+"</h2>");
console.log(num-10);
</script>
</body>
</html>
```

2️⃣ **[실습2]**
파일명 : exercise2.html

구현 내용

1. 프롬프트 창으로 1 부터 9사이의 숫자를 한 개 입력 받는다.(숫자만 입력받는다고 가정한다.)
2. 입력된 숫자가 1~9 사이가 아니면 다시 입력받는다.
3. 입력된 숫자에 해당하는 단의 구구단을 행단위로 출력한다.
    
    n 단입니다.  		 --> 첫번째 제목크기, 원하는 색상
    ----------------------  	 --> 분리선(<hr> 태그)
    n x 1 = y1
    n x 2 = y2
    :

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script>
var dan;
while(true){
	dan = window.prompt("1~9사이의 숫자를 입력하세요.");
	if(dan>0 && dan <10) break;
}

document.write("<h1>"+dan+"단입니다.</h1>");
document.write("<hr>");
for(let i=1 ; i<10 ; i++){
	 document.write("<p>"+dan+"*"+i+"="+(dan*i)+"</p>");
}
</script>

</body>
</html>
```

</div>
</details>
