<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566778017/noticon/ytjm1rralodyhvuggrpu.png" height="15%" width="15%"> <br/>

# 2023-04-26 / @PathVariable

🗓️ 날짜           2023/04/26 

☁️ 날씨           🌥️ 흐림 (10°C)
</br>

## 01. annotation

### 1.1 @PathVariable

💡 url의 특정 부분을 변수화 하는 기능을 지원하는 어노테이션

### 1.2@RequestBody

💡 request를 원하는 형태로 받고 싶을 때 사용 

- post 요청 방식에서만 의미가 있다.

### 1.3 @ResponseBody

💡 reponse를 원하는 형태로 보내고 싶을 때 사용

- mapping에  produces = "application/json; charset=utf-8" 속성을 이용하여 마임타입으로 원하는 타입으로 설정 한다.

### 1.4 @RestController

💡 @Controller + @ResponseBody 형태로 컨트롤러가 직접 응답한다.

1️⃣ **예제 -RequestBodyController.java, result.html**

```java
@PostMapping(value = "/rb2", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String test2(@RequestBody String param) {
        System.out.println(">>> " + param);
        return param;
    }
    @PostMapping(value = "/rb3", produces = "application/json; charset=utf-8")
    @ResponseBody
    public PersonVO test3(@RequestBody PersonVO vo) {
        System.out.println(">>> " + vo.getName()+":"+vo.getAge());
        return vo;
    }
```

```jsx
const buttons = document.querySelectorAll("button");
    const postData = event => {
        console.log("데이터 전송");
        fetch("/"+event.target.id, {
            method: 'post',
            headers: {
                'content-type': 'application/json' // json형식으로 req를 보낼거다
            },
            body : JSON.stringify({ // js의 객체를 json형태의 문자열로 바꿔서 보내겠다.
                name : event.target.getAttribute("data-pname"),
                age : "10"
            })
       })
       .then((response) => response.json())
       .then((data) => {
           console.log('성공:', data);
           document.querySelector("#msg_area").textContent = `${data.name}:${data.age}`;
       });
    };
    buttons.forEach( elem =>  elem.addEventListener("click", postData));
```

## 02. 파일 업로드 구현

- multipart/form-data

### 2.1 멀티 파트의 아규먼트

- XXX(MutilpartFile mfile)
- xxx(MultipartFile 타입을 멤버변수로 정의한 VO클래스 vo)
- xxx(MultipartFile[] 타입을 멤버변수로 정의한 VO클래스 vo) —> 다중 파일일 때
- xxx(MultipartRequest mreq) —> 다중 파일일 때

### 2.2 MultipartFile의 주요 메서드

- String getName() : 파라미터의 이름을 리턴
- String getOriginalFilename() : 업로드 한 팔의 실제 이름을 리턴
- boolean isEmpty() : 업로드 한 파일의 크기를 리턴
- long getSize() : 업로드 한 파일의 데이터를 byte 배열로 리턴한다.
- byte[] getBytes() throws IOException : 업로드 한 파일의 데이터를 byte 배열로 리턴한다.
- void transferTo(File dest) : 업로드 한 파일 데이터를 지정한 파일에 저장한다.

```java
@RequestMapping("/upload2")
	public ModelAndView saveFile(FileVO2 vo) {
	     System.out.println(vo.getUploadFiles().length+"개가 업로드 됨");
	     String resultStr = "";
	     String path = "저장할 파일 경로";
		 File isDir = new File(path);
		 if (!isDir.isDirectory()) {
			isDir.mkdirs();
		 }
	     ModelAndView mav = new ModelAndView();
	     mav.setViewName("uploadForm2");
	     
	     for (MultipartFile mfile : vo.getUploadFiles()) {
				String fileName = mfile.getOriginalFilename();
				try {
					File f = new File("c:/uploadtest/multi/" + fileName);
					if (f.exists()) {
						resultStr += fileName + " : 파일이 이미 존재해요!!<br>";
					} else {
						mfile.transferTo(f);
						resultStr += fileName + " : 파일이 저장되었어요!!<br>";
					}
				} catch (IOException e) {
					e.printStackTrace();
					resultStr += fileName + " : 오류가 발생했어요!!";				
				}
		  }	   
	     mav.addObject("msg", resultStr);	
	     return mav;
	}
```


## 03 Log

- Log API : Log4J → LogBack -> Log4J2
- Log4J가 가장 유명했지만 보안의 치명적인 단점이 발견되었다.
- spring은 기본적으로 LogBack을 채택

> 나중에 자세히 배움
>

## 기타

- 태그 내 속성명이 ‘data-’ 는 임의의 속성으로 사용자가 개발 편의성을 위해 사용한다.
- ajax시 xhr.open(”method”,”url”,bool) :세번째 아규먼트에서 false면 비동기, true 동기







## Exercise01 / @PathVariable

<details>
<summary>📜 PathVariable 실습 펼쳐보기</summary>
<div markdown="1">

1️⃣ **[실습 1]**

[4월26일실습_1.txt](https://github.com/juhee99/Msa-Dkteckin-fullstack/files/11341380/4.26._1.txt)

```java
@Controller
public class StudyPathController {

    @GetMapping("/study/{path}/thymeleaf")
    public String moveToURL(@PathVariable int path){
        String url = "";
        switch (path){
            case 1 : url="https://abbo.tistory.com/56"; break;
            case 2 : url="https://abbo.tistory.com/57"; break;
            case 3 : url="https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html"; break;
            case 4 : url="https://www.baeldung.com/dates-in-thymeleaf"; break;
        }
        return "redirect:"+url;
    }
}
```

</div>
</details>

## 🤷‍♀️ today’s feeling

- 파일 업로드 → 미니 프로젝트 때  프로필 업로드 시 사용
- PathVariable 동적으로 경로를 설정할 수 있기 때문에 자주 사용할거 같다.
