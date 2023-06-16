package com.example.springedu2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import springrest.exam.entity.Friend;
import springrest.exam.repository.FriendRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@Transactional
public class FriendTest {

    @Autowired
    private FriendRepository friendRepo;

    @Test
    @Rollback(value = false)
    public void newFriend(){
        Friend f1 =Friend.builder().fname("쿠파").fage(23).build();
        Friend f2 = Friend.builder().fname("동키콩").fage(17).build();
        Friend f3 = Friend.builder().fname("마리오").fage(28).build();
        Friend f4 = Friend.builder().fname("피치").fage(20).build();
        friendRepo.save(f1);
        friendRepo.save(f2);
        friendRepo.save(f3);
        friendRepo.save(f4);
        getFriend();
    }

    @Test
    public void getFriend(){
        friendRepo.findAll().forEach(System.out::println);
    }

    @Test
    @Rollback(value = false)
    public void modifiedFriend(){
        Optional<Friend> f1 = friendRepo.findById(7);
        f1.ifPresent(friend -> friend.setFname("루이지"));
        getFriend();
    }

    @Test
    @Rollback(value = false)
    public void deleteFriend(){
        Optional<Friend> f1 = friendRepo.findById(9);
        f1.ifPresent(friend -> friendRepo.deleteById(9));
        getFriend();
    }

}
