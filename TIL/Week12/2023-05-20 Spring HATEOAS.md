<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566778017/noticon/ytjm1rralodyhvuggrpu.png" height="15%" width="15%"> <br/>

# 2023-05-20 /  Spring HATEOAS

🗓️ 날짜           2023/05/20

☁️ 날씨           ☀️ 맑음 (21 °C)

## Spring HATEOAS

💡 애플리케이션의 상태는 상태의 변화에 따라서 링크 정보가 변경되어야 한다. 바로 이런 것을 HATEOAS 하는데 HATEOAS를 쉽게 개발하도록 지원되는 api이다.

- 클라이언트가 서버로부터 어떠한 요청을 할 때, 요청에 필요한 URL를 응답에 포함시켜 반환하는 것을 가능하게 한다.
- spring-boot-starter-hateoas 추가 해야 사용 가능
- 

```java
@GetMapping("/h_users/{id}")
 public EntityModel<User> retrieveUser(@PathVariable int id){
 User user = service.findOne(id);
 if(user==null){
 throw new UserNotFoundException(String.format("ID[%s] not found", id));
 }
 EntityModel<User> model = EntityModel.of(user);
 WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
 model.add(linkTo.withRel("all-users"));
 return model;
 }
```

### 01. EntityModel<T>

- RepresentationModel을 extend 도메인 객체를 감싸고, 그에 링크를 추가하는 객체
    - user는 RepresentationModel을 상속받고 있다.
- EntityModel.of( ) : 팩토리 메소드
- add( ) : 링크 추가 메소드

### 1.1 WebMvcLinkBuilder

- linkTo() :  컨트롤러 클래스를 가르키는 webMvcLinkBuilder 객체를 반환
- methodOne( ) : 타겟 메소드를 호출, 즉, 컨트롤러 내에 있는 메서드 명으로 Link객체를 포함하게 된다,
    - this.getClass()→ 자기 자신에 대한 클래스 객체
- withSelfRel() : build()역할로 현재 빌더 인스턴스로 링크 객체 생성
- withRel(””) :  직접 명칭을 지정

### 1.2 RepresentationModel

<img src="https://github.com/juhee99/Kosa-fullStack/assets/55836020/6afd83df-4df1-4465-b87d-52322dd2df73" width="50%"/>

- CollectionModel은 다 수의 모델을 담아야 할 때
    - list에 url을 담아 사용
- EntityModel은 한개만 반환할 때
    - 객체 하나만 보내기

## Exercise01 / Spring Hayeoas

<details>
<summary> 📜HATEOAS 실습 펼쳐보기</summary>
<div markdown="1">

[📎5월20일실습.pdf](https://github.com/juhee99/Kosa-fullStack/files/11539870/5.20._1_.pdf)

1️⃣ rest.html

```html
<body>
<h1>5 조의 REST API 실습</h1>
<hr>
<button onclick="showActorList(); return false">둘리와 친구들 보기</button>
<div id="actorBox">
</div>

<script>
    const actorBox = document.getElementById("actorBox");

  function showActor(param){
      actorBox.innerHTML="";
      fetch(param)
          .then(res => res.json())
          .then(data =>{
              actorBox.innerHTML += `<h2>${data.name}</h2>`
              actorBox.innerHTML += `<p>${data.addr}</p>`
              actorBox.innerHTML += `<img src="/static/images/${data.image}"/>`
          })

  }

    const showActorList  = () => {
      actorBox.innerHTML="";
        fetch('http://localhost:8088/all')
            .then(res => res.json())
            .then(data => {
                console.log(data);
                const list=data._embedded.comicActorModelList;
                list.map(list => {
                    actorBox.innerHTML += `<button onclick="showActor('${list._links.self.href}')"> ${list.name}</button>`
                })
                actorBox.innerHTML += `<hr>`;
            })
    }
</script>
</body>
```

2️⃣HoteoasRestController.java

```java
@RestController
public class HoteoasRestController {

    @GetMapping("/all")
    public CollectionModel<ComicActorModel> allActor(){
        List<ComicActorModel> list = new ArrayList<>();
        list.add(new ComicActorModel("둘리"));
        list.add(new ComicActorModel("또치"));
        list.add(new ComicActorModel("도우너"));
        String [] url = {"dooly","ddochi","dauner"};
        for (int i=0 ; i<url.length;i++){
            list.get(i).add(Link.of("http://localhost:8088/"+url[i]));
        }
        CollectionModel<ComicActorModel> result = CollectionModel.of(list);
        return result;
    }

    @GetMapping("/dooly")
    public ResponseEntity<ComicActor> getDooly(){
        ComicActor dooly = new ComicActor("둘리","쌍문동","dooly.jpg");
        return ResponseEntity.ok().body(dooly);
    }

    @GetMapping("/ddochi")
    public ResponseEntity<ComicActor> getDdochi(){
        ComicActor ddochi = new ComicActor("또치","아프리카","ddochi.png");
        return ResponseEntity.ok().body(ddochi);
    }

    @GetMapping("/dauner")
    public ResponseEntity<ComicActor> getDauner(){
        ComicActor ddochi = new ComicActor("또치","아프리카","ddochi.jpg");
        return ResponseEntity.ok().body(ddochi);
    }
}
```

</div>
</details>
