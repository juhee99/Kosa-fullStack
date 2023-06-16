package springrest.exam.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springrest.exam.domain.ComicActor;
import springrest.exam.domain.ComicActorModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
