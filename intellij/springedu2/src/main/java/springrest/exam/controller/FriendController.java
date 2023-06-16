package springrest.exam.controller;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import springrest.exam.entity.Friend;
import springrest.exam.repository.FriendRepository;

import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    FriendRepository friendRepo;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Friend>> getFriendAllList(){

        return new ResponseEntity<List<Friend>>(friendRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity getFriendById(@PathVariable  int id){
        Optional<Friend> f = friendRepo.findById(id);
       if (f.isPresent()){
           return new ResponseEntity<>(f.get(),HttpStatus.OK);
       }else {
           MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
           header.add("BAD_ID", String.valueOf(id));
           return new ResponseEntity<>(header,HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping(value = "/search/{name}",produces = "application/json; charset=utf-8" )
    public ResponseEntity getFriendByName(@PathVariable String name) throws UnsupportedEncodingException {
        Optional<Friend> f = friendRepo.findByFnameContains(name);
        if (f.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(f.get());
        }else {
            MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
            header.add("BAD_NAME", URLEncoder.encode(name,"utf-8"));
            return new ResponseEntity<>(header,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody Friend friend){
       try{
           friendRepo.save(friend);
           return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body("입력 성공");
       }catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("실패 하셨습니다.");
       }
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody Friend friend){
        Optional<Friend> f1 = friendRepo.findById(friend.getId());
        if (f1.isPresent() ){
            f1.get().setFname(friend.getFname());
            f1.get().setFage(friend.getFage());
            return ResponseEntity.status(HttpStatus.RESET_CONTENT).body("수정 성공");
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("실패 하셨습니다.");
        }
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity delete( int id){
        Optional<Friend> f1 = friendRepo.findById(id);
        if (f1.isPresent()){
            friendRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.RESET_CONTENT).body("수정 성공");
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("실패 하셨습니다.");
        }
    }

}
