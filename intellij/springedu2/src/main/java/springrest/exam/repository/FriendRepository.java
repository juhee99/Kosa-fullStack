package springrest.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springrest.exam.entity.Friend;

import java.util.Optional;

public interface FriendRepository extends JpaRepository<Friend, Integer> {

    public Optional<Friend> findByFnameContains(String name);
}
